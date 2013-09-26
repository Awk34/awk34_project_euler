/*
 * Andrew Koroluk
 */

public class euler243 {
	public static void main(String[] args) {
		double limit = 15499.0/94744;
		int ans = 0;
		int i = 12;
		//int[] primes = primeSieve.sieve(1000000000);
		
		while(true) {
			i++;
			if(Utils.totient(i)/(i-1.0)<limit) {
				ans = i;
				System.out.println(ans);
				break;
			}
			if(i%1000==0) {
				System.out.println(i);
			}
		}
		
		System.out.println(ans);	//892371480
	}
}

//totient function is too slow for this..