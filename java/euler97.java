/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

class euler97 {
	public static void main(String[] args) {
		BigInteger x = BigInteger.ONE.shiftLeft(7830457);
		x = x.mod(new BigInteger("1000000000000"));
		x=x.multiply(new BigInteger("28433"));
		x=x.add(BigInteger.ONE);
		x = x.mod(new BigInteger("10000000000"));
		System.out.println(x);	//8739992577
	}
}

/*
The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 2^6972593-1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433 x 2^7830457+1.

Find the last ten digits of this prime number.
*/