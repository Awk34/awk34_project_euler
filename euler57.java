/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler57 {
	public static void main(String[] args) {
		BigInteger[] N = new BigInteger[2];
		BigInteger[] D = new BigInteger[2];
		N[0] = new BigInteger("3");
		N[1] = new BigInteger("7");
		D[0] = new BigInteger("2");
		D[1] = new BigInteger("5");
		
	    int i = 0, ans = 0;
	    for(int x = 3; x<=1000; x++) {
			N[i] = (N[(i+1)%2].multiply(new BigInteger("2"))).add(N[i]);
			D[i] = (D[(i+1)%2].multiply(new BigInteger("2"))).add(D[i]);
			if( N[i].toString().length() > D[i].toString().length() ) ans++;
			i = (i+1)%2;
	    }
	    System.out.println(ans);	//153
	}
}