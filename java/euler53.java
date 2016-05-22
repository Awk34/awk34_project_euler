/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler53 {
	public static void main(String[] args) {
		int ans = 0;
		for(int n=1; n<=100; n++) {
			for(int r=1; r<=n; r++) {
				try {
					//System.out.println(n+" "+r+" "+Utils.nCr(n,r));
					if(Utils.nCr(BigInteger.valueOf(n),BigInteger.valueOf(r)).compareTo(BigInteger.valueOf(1000000))>0)
						ans++;
				}
				catch(Exception E) {
					System.out.println("whoops");
				}
			}
		}
		System.out.println("And the winner is: "+ans); //4075
	}
	//int nCr(int n, int r)
}

/*
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,

nCr =	
n!
r!(nr)!
,where r  n, n! = n(n1)...321, and 0! = 1.
It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1  n  100, are greater than one-million?
*/