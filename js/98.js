'use strict';
import fs from 'fs';
import path from 'path';
import _ from 'lodash';
import Euler from './Euler';
import t from 'exectimer';
const Tick = t.Tick;
import math from 'mathjs';
import {permute} from './util/array';

// CARE = 1296 = 36^2
// RACE = 9216 = 96^2

function groupPairs(items) {
    let pairs = [];

    _.forEach(items, (item1, i) => {
        _.forEach(items, (item2, j) => {
            if(j <= i) return;

            pairs.push([item1, item2]);
        });
    });

    return pairs;
}

function getSquarePairs(upToLength) {
    let i = 1;
    let limit = math.pow(10, upToLength);
    let pairs = {};

    while(true) {
        let square = i * i;
        if(square > limit) break;

        let hash = `${square}`.split('').sort().join('');

        if(!pairs[hash]) pairs[hash] = [];
        pairs[hash].push(square);

        i++;
    }

    let take2 = array => _.partialRight(_.take, 2)(array);
    return _.chain(pairs)
        .filter(group => group.length > 1)
        .flatMap(group => {
            if(group.length === 2) return [group];

            return groupPairs(group);
        })
        .value();
}

/**
 * @param {String} word
 * @param {String} number
 */
function getLetterMapping(word, number) {
    word = word.split('');
    number = number.split('');
    let mapping = {};

    for(let i = 0; i < word.length; i++) {
        // make sure that letters are only assigned a single value
        let previousMapping = mapping[word[i]];
        if(previousMapping && previousMapping !== number[i]) {
            return false;
        }

        mapping[word[i]] = number[i];
    }

    // make sure two different letters aren't assigned the same value
    let accumulator = {};
    for(let key of Object.keys(mapping)) {
        if(accumulator[mapping[key]]) return false;

        accumulator[mapping[key]] = true;
    }

    return mapping;
}

function mapWord(word, mapping) {
    let number = [];
    _.forEach(word.split(''), letter => {
        number.push(mapping[letter]);
    });
    return parseInt(number.join(''));
}

export default class Euler98 extends Euler {
    solution = 0;

    constructor() {
        super();

        this.words = Euler98.parseWords(fs.readFileSync(path.join(__dirname, '..', 'data/words98.txt'), 'utf8'));
    }

    static parseWords(str) {
        return str.split(',').map(word => word.replace(/"/g, ''));
    }

    *step() {
        const self = this;
        // get groups of anagramic pairs
        let wordPairs = _.chain(this.words)
            // group by words converted to strings of their sorted letters ('SHOE' => 'EHOS')
            .groupBy(word => word.split('').sort().join(''))
            // filter out any groups of only one word (no pairs)
            .filter(group => group.length > 1)
            // split groups of 3+ into all possible pairs
            .flatMap(group => {
                if(group.length === 2) return [group];

                return groupPairs(group);
            })
            .value();

        this.verbose(wordPairs);
        
        yield wordPairs;

        let maxLength = 0;

        // get the lengths of words we have
        _.forEach(wordPairs, group => {
            let length = group[0].length;
            if(length > maxLength) maxLength = length;
        });

        let squarePairs = _.groupBy(getSquarePairs(maxLength), pair => `${pair[0]}`.length);

        this.verbose(squarePairs);

        yield squarePairs;

        _.forEach(wordPairs, wordPair => {
            let length = wordPair[0].length;
            _.forEach(squarePairs[length], squarePair => {
                let tick = new Tick('step');
                tick.start();

                let mapping0 = getLetterMapping(wordPair[0], `${squarePair[0]}`);
                if(mapping0 === false) return;

                let mappedNum = mapWord(wordPair[1], mapping0);

                if(squarePair[1] === mappedNum) {
                    self.info(`Pair found: ${wordPair[0]} -> ${squarePair[0]}, ${wordPair[1]} -> ${squarePair[1]}`);
                    if(squarePair[0] > this.solution) this.solution = squarePair[0];
                    if(squarePair[1] > this.solution) this.solution = squarePair[1];
                }

                tick.stop();

                // yield {wordPair, squarePair};
            });
        });

        return this.solution;
    }

    run() {
        this.start();

        const stepper = this.step();

        let step;
        do {
            let tick = new Tick('step');
            tick.start();
            step = stepper.next();
            tick.stop();
            this.verbose(`step: ${step.value}`);
        } while(!step.done);

        this.end();

        let stepTimer = t.timers.step;

        this.info(`Took ${stepTimer.count()} steps`);
        this.info(`Took ${stepTimer.parse(stepTimer.duration())}`);
        this.info(`Soluion: ${this.solution}`);

        return this.sum;
    }
}
