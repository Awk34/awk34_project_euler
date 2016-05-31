'use strict';
import fs from 'fs';
import path from 'path';
import _ from 'lodash';
import Euler from './Euler';
import microtime from 'microtime';
import t from 'exectimer';
const Tick = t.Tick;

const solutionMap5x5 = [
[ 1 , 0 , 1 , 1 , 1 ],
[ 1 , 1 , 1 , 0 , 1 ],
[ 0 , 0 , 0 , 1 , 1 ],
[ 0 , 0 , 0 , 1 , 0 ],
[ 0 , 0 , 0 , 1 , 1 ]];
const solution5x5 = 2297;
const solution = require('../data/solutions.json')['83'];
console.log(solution5x5);
console.log(solution);  // 425185
/**
 * G = cost from A to square
 * H = extimated cost from square to B
 * F = score, G + H
 */

let up = ([row, col]) => [row - 1, col];
let down = ([row, col]) => [row + 1, col];
let left = ([row, col]) => [row, col - 1];
let right = ([row, col]) => [row, col + 1];

export default class Euler83 extends Euler {
    position = [0, 0];
    min = 18;
    rows = 5;
    cols = 5;
    endPosition = [4, 4];
    moves = 0;
    open = [];
    closed = [];
    weightMap;
    // map;
    solution = 0;

    static parseMatrix(matrix) {
        return matrix
            .toString()
            .trim()
            .split('\n')
            .map(line => {
                return line
                    .split(',')
                    .map(c => parseInt(c));
            });
    }

    constructor(matrix) {
        super();

        this.weightMap = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;

        // this.map = (new Array(this.rows)).fill((new Array(this.cols)).fill(0));
        // this.map[0, 0] = 1;

        this.heuristicMap = [];
        for(let i = 0; i < this.rows; i++) {
            let row = [];
            for(let j = 0; j < this.cols; j++) {
                row.push(this.min * ((5 -  i) + (5 - j) - 1));
            }
            this.heuristicMap.push(row);
        }

        this.solution += this.weightMap[0][0];    // add starting position weight

        // add first points to open
        let p1 = {
            position: [0, 1],
            g: this.weightMap[0][1],
            h: this.heuristicMap[0][1]
        };
        p1.f = p1.g + p1.h;

        let p2 = {
            position: [1, 0],
            g: this.weightMap[1][0],
            h: this.heuristicMap[1][0],
        };
        p2.f = p2.g + p2.h;

        if(p1.f <= p2.f) {
            this.open.push(p1, p2);
        } else {
            this.open.push(p2, p1);
        }

        // add starting point to closed list
        let start = {
            position: [0, 0],
            g: this.weightMap[0][0],
            h: this.heuristicMap[0][0],
        };
        start.f = start.g + start.h;
        this.closed.push(start);
    }

    *step() {
        while(this.position !== this.endPosition) {
            let tick = new Tick('step');
            tick.start();

            let next = this.open.splice(0, 1)[0];
            this.info(`Next: ${next.position}`);
            this.solution += next.g;
            this.closed.push(next);

            if(next.position[0] === this.endPosition[0] && next.position[1] === this.endPosition[1]) {
                // done
                tick.stop();

                this.info('Reached end!');

                return this.solution;
            }

            // add new points, if possible (in sorted position)
            this.addToOpen(up(next.position));
            this.addToOpen(down(next.position));
            this.addToOpen(left(next.position));
            this.addToOpen(right(next.position));

            yield next;
            tick.stop();
        }
    }

    addToOpen([row, col]) {
        if(!this.canGo([row, col])) return false;
        if(this.open.map(point => point.position).indexOf([row, col]) > -1) return false;

        let point = {
            position: [row, col],
            g: this.weightMap[row][col],
            h: this.heuristicMap[row][col]
        };
        point.f = point.g + point.h;

        let index = _.sortedIndexBy(this.open, point, 'f');
        this.open.splice(index, 0, point);
    }

    canGo([row, col]) {
        // out of bounds check
        if(row < 0 || col < 0 || row >= this.rows || col >= this.cols) {
            return false;
        }

        // check if in closed list
        let closedLength = this.closed.length;
        for(let i = 0; i < closedLength; i++) {
            if(this.closed[i].position[0] === row && this.closed[i].position[1] === col) {
                return false;
            }
        }

        return true;
    }
}
