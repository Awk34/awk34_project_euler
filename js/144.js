'use strict';

import Euler from './Euler';
import quadratic from './util/quadratic';

class Point {
    constructor(x, y, z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

export default class Euler144 extends Euler {
    x1;
    y1;
    x2;
    y2;
    ans;

    constructor() {
        super();
        this.p1 = new Point(0.0, 10.1);
        this.p1 = new Point(1.4, -9.6);
        this.x1 = 0.0;
        this.y1 = 10.1;
        this.x2 = 1.4;
        this.y2 = -9.6;
        this.ans = 1;
    }

    run() {
        while(true) {
            let m0 = (this.y2 - this.y1) / (this.x2 - this.x1);
            let m1 = Euler144.deriv(this.x2, this.y2);
            let tempX = this.x2;
            let tempY = this.y2;
            let X = (m0 - m1) / (1 + m0 * m1);
            let m2 = (m1 - X) / (1 + X * m1);

            let b = (this.y2 - m2 * this.x2);
            this.x2 = quadratic(m2, b, this.x2);
            this.y2 = m2 * this.x2 + b;
            this.info(`${this.x2}, ${this.y2}`);
            this.x1 = tempX;
            this.y1 = tempY;

            if(this.y2 > 0 && this.x2 > -.01 && this.x2 < .01) break;
            this.ans++;
        }
        return this.ans;
    }

    static deriv(x, y) {
        return -4 * x / y;
    }
}
