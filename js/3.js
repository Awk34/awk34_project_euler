'use strict';
import Euler from './Euler';
import t from 'exectimer';
const Tick = t.Tick;

export default class Euler3 extends Euler {
    fac = 2;
    num = 600851475143;
    solution;

    constructor() {
        super();
    }

    *step() {
        let sqrtNum = Math.sqrt(this.num).toFixed(0);
        while(this.fac <= sqrtNum) {
            let tick = new Tick('step');
            tick.start();

            if(this.num % this.fac == 0) {
                let otherFac = this.num / this.fac;
                if(Euler3.isPrime(otherFac)) {
                    this.solution = otherFac;
                    tick.stop();
                    return otherFac;
                } else {
                    if(Euler3.isPrime(this.fac)) {
                        this.solution = this.fac;
                    }
                }
            }

            this.fac++;
            tick.stop();
            yield this.fac;
        }

        return this.solution;
    }

    static isPrime(n) {
        let i = 2;
        let sqrtN = Math.sqrt(n).toFixed(0);

        while(i <= sqrtN) {
            if(n % i === 0) {
                return false;
            } else {
                i++;
            }
        }

        return true;
    }
}
