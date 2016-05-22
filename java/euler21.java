/*
 * Andrew Koroluk
 */

//import java.math.BigInteger;

public class euler21 {
	boolean alreadythere(int[] a, int val) {
		for(int i=0; i<a.length; i++) {
			if(a[i]==val)
				return false;
		}
		return true;
	}
	public static void main(String[] anabelle) {
		Utils utils = new Utils();
		short[][] a = new short[10000][10000];

		for(short i=1; i<=10000; i++) {
			a[0][i-1]=i;
			a[1][i-1]=utils.sumOfDivisors(i);
		}

		//System.out.println(a[0][10000-1] +" "+ a[1][10000-1]);

		int ans=0;

		for(short i=1; i<=10000; i++) {
			for(short j=1; j<=10000; j++) {
				if(i==j) continue;
				if(a[1][i-1]==a[0][j-1]&&a[0][i-1]==a[1][j-1]) {
					System.out.println(a[0][i-1] +" "+ a[1][i-1]);
					System.out.println(a[0][j-1] +" "+ a[1][j-1]);
					ans+=a[0][i-1]+a[0][j-1];
					System.out.println(ans);
				}
			}
		}

		System.out.println("Answer: "+ans/2);
	}
}

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
*/