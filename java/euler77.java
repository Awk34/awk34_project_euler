/*
 * Andrew Koroluk
 */

public class euler77 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		
		int target = 2;
		int[] primes = primeSieve.sieve(100);
		Utils.print(primes);
		 
		while (true) {
		    int[] a = new int[target+1];
		    a[0] = 1;
		 
		    for (int i = 0; i < primes.length-1; i++)
		        for (int j = primes[i]; j <= target; j++)
		            a[j] += a[j - primes[i]];
		 
		    if (a[target] > 5000) break;
		    target++;
		}		
		
		clock.getTimeMillis();
		System.out.println(target);	//71
	}
}