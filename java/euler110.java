/*
 * Andrew Koroluk
 */

public class euler110 {
	public static void main(String[] args) {
		long n = 1;
		long ans = 0;
		long[] primes = LongPrimeSieve.sieve(100000);
		System.out.println("Done Sieveing.");
		
		while(true) {
			if( (NumDivisors2(n, primes)+1)/2 > 4000000) {
				System.out.println("Ans: " + n);
				break;
			}
			n++;
		}
	}
	private static long NumDivisors2(long number, long[] primelist) {
		//finds the number of divisors of number^2
	    long nod = 1;
	    long exponent;
	    long remain = number;
	 
	    for (int i = 0; i < primelist.length; i++) {
	        // In case there is a remainder this is a prime factor as well
	        // The exponent of that factor is 1
	        if (primelist[i] * primelist[i] > number) {
	            return nod * 2;
	        }
	 
	        exponent = 1;
	        while (remain % primelist[i] == 0) {
	            exponent+=2;
	            remain = remain / primelist[i];
	        }
	        nod *= exponent;
	 
	        //If there is no remainder, return the count
	        if (remain == 1) {
	            return nod;
	        }
	    }
	    return nod;
	}
}