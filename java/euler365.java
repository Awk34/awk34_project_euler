/*
 * Andrew Koroluk
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class euler365 {
	public static void main(String[] args) {
		long ans=0;
		/*BigInteger n = new BigInteger("10");	n = n.pow(18);
		BigInteger k = new BigInteger("10");	k = k.pow(9);
		
		BigInteger M = f(n,k).multiply( Utils.factorial(k) );
		
		System.out.println(M);
		*/
		
		BigInteger n = new BigInteger("10");
		BigInteger k = new BigInteger("18");
		int temp = 1009 * 1013 * 1019;
		BigInteger m = new BigInteger(Integer.toString(temp));
		
		System.out.println(n.modPow(k, m));
		
		//System.out.println(lnGamma());
		
		//if(true) return;
		
		System.out.println(g(5,55,221));
		
		ArrayList<Long> p = new ArrayList<Long>();
		for(long i=1001; i<5000; i++)
			if(Utils.isPrime(i)) p.add(i);
		ArrayList<Long> q = p;
		ArrayList<Long> r = p;
		System.out.println(p);
		
		for(int a=0; a<p.size(); a++) {
			for(int b=0; b<q.size()-1; b++) {
				for(int c=0; c<r.size()-2; c++) {
					if( !(p.get(a)<q.get(b)) || !(q.get(b)<r.get(c)) ) continue;
					ans+=(p.get(a)*q.get(b)*r.get(c));
				}
			}
		}
		System.out.println(ans);
	}
	static BigInteger f(BigInteger a, BigInteger b) {
		BigInteger ans = new BigInteger("1");
		
		for(; a.compareTo(b)!=0 ; a.subtract(BigInteger.ONE))
			ans = ans.multiply(a);
		
		return ans;		
	}
	static int g(int a, int b, int m) {
		int a1 = a % m;
		//int a1 = 1;
		int p = 1;
		while (b > 0) {
			if (b%2 != 0) {
				p *= a1;
				p = p % m;
			}
			b /= 2;
			a1 = (a1 * a1) % m;
		}
		return a1;
	}
	//  Used by "lnGamma()".
	private static double[] gamCoef = { 76.18009172947146, -86.50532032941677, 24.01409824083091,
										-1.231739572450155, 0.1208650973866179e-2, -0.5395239384953e-5 };
	/**
	*  Returns the natural log "ln" of the Gamma Function defined by the integral:
	*      Gamma(z) = integral from 0 to infinity of t^(z-1)*e^-t dt.
	*  It is better to implement ln(Gamma(x)) rather than Gamma(x) since the latter
	*  will overflow many computer's floating point representations at quite modest
	*  values of x.
	**/
	public static double lnGamma(double xx) {
		double x = xx, y=xx;
		double tmp = x + 5.5;
		tmp -= (x + 0.5)*Math.log(tmp);
		double ser = 1.000000000190015;
		for (int j=0; j <= 5; ++j)
			ser += gamCoef[j]/++y;
		return -tmp + Math.log(2.5066282746310005*ser/x);
	}
	static double nCr(double n, double k) {
		return Math.exp( lnGamma(n+1) - lnGamma(k+1) - lnGamma(n-k+1) );
	}
}
/*
The binomial coeffient C(10^18,10^9) is a number with more than 9 billion (9109) digits.

Let M(n,k,m) denote the binomial coefficient C(n,k) modulo m.

Calculate (SUM) M(10^18,10^9,p*q*r) for 1000pqr5000 and p,q,r prime.
*/