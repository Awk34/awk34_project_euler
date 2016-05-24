'use strict';

/**
 * @param {Number} limit=1000 - end of the sieve
 */
export default function SieveOfAtkin(limit = 1000) {
    let sieve = new Array(limit + 1);
    let limitSqrt = Math.sqrt(limit).toFixed(0);

    // there may be more efficient data structure
    // arrangements than this (there are!) but
    // this is the algorithm in Wikipedia
    // initialize results array
    sieve.fill(false);
    // the sieve works only forintegers > 3, so
    // set these trivially to their proper values
    sieve[0] = false;
    sieve[1] = false;
    sieve[2] = true;
    sieve[3] = true;

    // loop through all possible integer values forx and y
    // up to the square root of the max prime forthe sieve
    // we don't need any larger values forx or y since the
    // max value forx or y will be the square root of n
    // in the quadratics
    // the theorem showed that the quadratics will produce all
    // primes that also satisfy their wheel factorizations, so
    // we can produce the value of n from the quadratic first
    // and then filter n through the wheel quadratic
    // there may be more efficient ways to do this, but this
    // is the design in the Wikipedia article
    // loop through all integers forx and y forcalculating
    // the quadratics
    for(let x = 1; x <= limitSqrt; x++) {
        for(let y = 1; y <= limitSqrt; y++) {
            // first quadratic using m = 12 and r in R1 = {r : 1, 5}
            let n = (4 * x * x) + (y * y);
            if(n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                sieve[n] = !sieve[n];
            }
            // second quadratic using m = 12 and r in R2 = {r : 7}
            n = (3 * x * x) + (y * y);
            if(n <= limit && (n % 12 == 7)) {
                sieve[n] = !sieve[n];
            }
            // third quadratic using m = 12 and r in R3 = {r : 11}
            n = (3 * x * x) - (y * y);
            if(x > y && n <= limit && (n % 12 == 11)) {
                sieve[n] = !sieve[n];
            }
            // note that R1 union R2 union R3 is the set R
            // R = {r : 1, 5, 7, 11}
            // which is all values 0 < r < 12 where r is
            // a relative prime of 12
            // Thus all primes become candidates
        }
    }
    // remove all perfect squares since the quadratic
    // wheel factorization filter removes only some of them
    for(let n = 5; n <= limitSqrt; n++) {
        if(sieve[n]) {
            let x = n * n;
            for(let i = x; i <= limit; i += x) {
                sieve[i] = false;
            }
        }
    }

    return sieve;
}
