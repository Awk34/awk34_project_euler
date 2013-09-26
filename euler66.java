/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler66 {
	public static void main(String[] args) {
		int ans = 0;
		BigInteger max = new BigInteger("0");
		
		for(int D=2; D<=1000; D++) {
			BigInteger lim = new BigInteger(Integer.toString((int)Math.sqrt(D)));
			if (lim.multiply(lim).compareTo( new BigInteger(Integer.toString(D)) ) == 0) continue;
			
		    BigInteger m = BigInteger.ZERO;
		    BigInteger d = BigInteger.ONE;
		    BigInteger a = lim;
		 
		    BigInteger numm1 = BigInteger.ONE;
		    BigInteger num = a;
		 
		    BigInteger denm1 = BigInteger.ZERO;
		    BigInteger den = BigInteger.ONE;
		 
		    while( ( num.multiply(num) ).subtract( new BigInteger(Integer.toString(D)).multiply(den).multiply(den) ).compareTo(BigInteger.ONE) != 0) {
		        m = ( d.multiply(a) ).subtract(m);
		        d = ( new BigInteger(Integer.toString(D)).subtract(m.multiply(m)) ).divide(d);
		        a = ( lim.add(m) ).divide(d);
		 
		        BigInteger numm2 = numm1;
		        numm1 = num;
		        BigInteger denm2 = denm1;
		        denm1 = den;
		 
		        num = ( a.multiply(numm1) ).add(numm2);
		        den = ( a.multiply(denm1) ).add(denm2);
		    }
		 
		    if (num.compareTo(max) == 1) {
		        max = num;
		        ans = D;
		    }
		}
		System.out.println(ans);
	}
}