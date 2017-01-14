import Euler from './Euler';
import { Tick } from 'exectimer';
import { isPalindrome } from './util';

export default class Euler4 extends Euler {
    i;

    *step() {
        for(let x = 999; x >= 900; x--) {
            for(let y = 999; y >= 900; y--) {
                let tick = new Tick('step');
                tick.start();

                this.i = x * y;

                let is = isPalindrome(String(this.i));

                tick.stop();

                if(is) {
                    this.solution = this.i;
                    return this.i;
                } else {
                    yield this.i;
                }
            }
        }

        return this.solution;
    }
}
