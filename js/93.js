'use strict';
import _ from 'lodash';
import Euler from './Euler';
import t from 'exectimer';
const Tick = t.Tick;
import math from 'mathjs';

/**
 * @returns {Boolean}
 */
function repeats(a, b, c, d) {
    return _.uniq([a, b, c, d]).length !== 4;
}

function permute(array, returnMap = false) {
    var p = -1;
    var j;
    var k;
    var f;
    var r;
    var l = array.length;
    // number of permutations
    var q = math.factorial(l);
    var i = l + 1;

    var x = [new Array(l), new Array(l), new Array(l), new Array(l)];

    for(j = q, k = l + 1, i = -1; ++i < l; x[2][i] = i, x[1][i] = x[0][i] = j /= --k);

    for(r = new Array(q); ++p < q;) {
        for(r[p] = new Array(l), i = -1; ++i < l; !--x[1][i] && (x[1][i] = x[0][i],
            x[2][i] = (x[2][i] + 1) % l), r[p][i] = returnMap ? x[3][i] : array[x[3][i]]) {
            for(x[3][i] = x[2][i], f = 0; !f; f = !f) {
                for(j = i; j; x[3][--j] == x[2][i] && (x[3][i] = x[2][i] = (x[2][i] + 1) % l, f = 1));
            }
        }
    }

    return r;
};

const operators = ['+', '-', '*', '/'];

export default class Euler83 extends Euler {
    methods = [{
        key: 'bruteForce1',
        name: 'Brute Force 1',
        description: 'My first brute force attempt'
    }];
    solution = {
        numConsecutive: 28,
        a: 1,
        b: 2,
        c: 3,
        d: 4
    };

    constructor() {
        super();

        this.method = this[this.methods[0].key];
    }

    // brute force, get's the job done, but takes about 300s
    *bruteForce1() {
        for(let a = 1; a <= 6; a++) {
            for(let b = 2; b <= 7; b++) {
                for(let c = 3; c <= 8; c++) {
                    for(let d = 4; d <= 9; d++) {
                        // if(any digits repeat) continue
                        if(repeats(a, b, c, d)) continue;
                        // each sequence
                        let tick = new Tick('step');
                        tick.start();

                        let numPermutations = permute([a, b, c, d]);
                        let targets = [];

                        _.forEach(numPermutations, np => {
                            _.forEach(operators, op1 => {
                                _.forEach(operators, op2 => {
                                    _.forEach(operators, op3 => {
                                        targets.push(math.eval(`${np[0]} ${op1} ${np[1]} ${op2} ${np[2]} ${op3} ${np[3]}`));
                                        targets.push(math.eval(`(${np[0]} ${op1} ${np[1]}) ${op2} (${np[2]} ${op3} ${np[3]})`));
                                        targets.push(math.eval(`${np[0]} ${op1} (${np[1]} ${op2} ${np[2]} ${op3} ${np[3]})`));
                                        targets.push(math.eval(`${np[0]} ${op1} (${np[1]} ${op2} ${np[2]}) ${op3} ${np[3]}`));
                                        targets.push(math.eval(`${np[0]} ${op1} ${np[1]} ${op2} (${np[2]} ${op3} ${np[3]})`));
                                    });
                                });
                            });
                        });

                        // filter & sort
                        targets = _.chain(targets)
                            .filter(target => math.isInteger(target) && target > 0)
                            .uniq()
                            .thru(targets => targets.sort((a, b) => a - b))
                            .value();

                        let numConsecutive = 1;

                        for(let i = 0; i < targets.length; i++) {
                            if(targets[i] + 1 === targets[i + 1]) {
                                numConsecutive++;
                            } else {
                                break;
                            }
                        }

                        if(numConsecutive > this.solution.numConsecutive) {
                            this.solution = {numConsecutive, a, b, c, d}
                        }

                        this.info(`[${a}, ${b}, ${c}, ${d}]: ${numConsecutive}`);

                        yield numConsecutive;

                        tick.stop();
                    }
                }
            }
        }

        this.info(`Solution: [${a}, ${b}, ${c}, ${d}]: ${numConsecutive}`);

        return this.solution;
    }

    *step() {
        yield* this.method();
    }
}
