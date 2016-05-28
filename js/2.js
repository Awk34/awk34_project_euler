'use strict';
import Euler from './Euler';
import microtime from 'microtime';
import t from 'exectimer';
const Tick = t.Tick;

export default class Euler2 extends Euler {
    num1 = 1;
    num2 = 1;
    num3;
    sum = 0;
    max = 4000000;

    constructor() {
        super();
    }

    *step() {
        while(this.num2 < this.max) {
            let tick = new Tick('step');
            tick.start();
            if(this.num2 % 2 == 0) {
                this.sum += this.num2;
            }
            this.num3 = this.num2;
            this.num2 = this.num1 + this.num2;
            this.num1 = this.num3;
            tick.stop();
            yield this.num2;
        }
        return this.sum;
    }

    run() {
        this.start();

        const stepper = this.step();

        let step;
        do {
            step = stepper.next();
            this.verbose(`step: ${step.value}`);
        } while(!step.done);

        this.end();

        let stepTimer = t.timers.step;

        this.info(`Took ${stepTimer.count()} steps`);
        this.info(`Took ${stepTimer.parse(stepTimer.duration())}`);
        console.log(`The Sum of all even Fibonacci numbers below ${this.max} is ${this.sum}`);

        return this.sum;
    }
}
