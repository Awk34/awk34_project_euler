/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler357 {
	public static void main(String[] args) {
		BigInteger ans = new BigInteger("1");
		for(int i = 2; i<=100000000; i+=4)
			if(d(i))  ans = ans.add(new BigInteger(Integer.toString(i)));
		System.out.println(ans);
	}
	static boolean d(int x) {
		for(int i=1; i<=(int)Math.sqrt(x); i++)
			if(x%i==0)
				if(!Utils.isPrime(i+x/i))
					return false;
		return true;
	}
}
/*
Consider the divisors of 30: 1,2,3,5,6,10,15,30.
It can be seen that for every divisor d of 30, d+30/d is prime.

Find the sum of all positive integers n not exceeding 100 000 000
such that for every divisor d of n, d+n/d is prime.
*/