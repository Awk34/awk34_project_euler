/*
 * Andrew Koroluk
 */

//import java.util.ArrayList;

public class euler70 {
	public static void main(String[] args) {
		int[] primes = primeSieve.sieve(5000);
		
		long best = 1;
		double bestRatio = Double.POSITIVE_INFINITY;
		 
		int limit = 10000000;
		 
		for (int i = 0; i < primes.length; i++) {
		    for (int j = i+1; j < primes.length; j++) {
		        long n = primes[i] * primes[j];
		        if (n > limit) break;
		 
		        long phi = (primes[i] - 1) * (primes[j] - 1);
		        double ratio = ((double) n) / phi;
		 
		        if (isPerm(n, phi) && bestRatio > ratio) {
		            best = n;
		            bestRatio = ratio;
		        }
		    }
		}
		
		System.out.println(best);
	}
    private static boolean isPerm(long m, long n) {
        int[] arr = new int[10];

        long temp = n;
        while (temp > 0) {
            arr[(int) (temp % 10)]++;
            temp /= 10;
        }

        temp = m;
        while (temp > 0) {
            arr[(int) (temp % 10)]--;
            temp /= 10;
        }

        for (int i = 0; i < 10; i++)
            if (arr[i] != 0)
                return false;
        return true;
    }
}