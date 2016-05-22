/*
 * Andrew Koroluk
 */

public class euler27 {
	@SuppressWarnings("static-access")
	public static void main(String[] domination) {
		Utils utils = new Utils();
		int ans=0;

		for(int a=-1000; a<1000; a++) {
			for(int b=-1000; b<1000; b++) {
				int run=0;
				for(int n=0; n<1000; n++) {
					if(utils.isPrime(n*n + a*n + b)) {
						run++;
						continue;
					}
					else break;
				}
				if(run>ans) {
					ans=run;
					System.out.println("a= "+a+", b= "+b+", primes= "+run+" and ans= "+(a*b));
				}
			}
		}
	}
}

/*
Euler published the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.

Using computers, the incredible formula  n²  79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, 79 and 1601, is 126479.

Considering quadratics of the form:

n² + an + b, where |a|  1000 and |b|  1000

		where |n| is the modulus/absolute value of n
		e.g. |11| = 11 and |4| = 4

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
*/