import Euler from './Euler';
import t from 'exectimer';
const Tick = t.Tick;

export default class Euler1 extends Euler {
    n = 1;
    total = 0;

    constructor() {
        super();
    }

    *step() {
        for(; this.n < 1000; this.n++) {
            let tick = new Tick('step');
            tick.start();

            if(this.n % 3 === 0 || this.n % 5 === 0) this.total += this.n;

            tick.stop();
            yield this.total;
        }
        return this.total;
    }
}
