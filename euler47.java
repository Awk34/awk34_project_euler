/*
 * Andrew Koroluk
 */

class euler47 {
	public static void main(String[] args) {
		int[] primes = primeSieve.sieve(100000);
		
		int consec = 1;
		int result = 2 * 3 * 5 * 7;
		
		while (consec < 4) {
		    result++;
		    if (primeFacs(result, primes) >= 4)
		        consec++;
		    else
		        consec = 0;
		}
		
		System.out.println(result-3);
	}
	private static int primeFacs(int number, int[] primes) {
	    int nod = 0;
	    boolean pf;
	    int remain = number;
	 
	    for (int i=0; i<primes.length; i++) {
	        if (primes[i] * primes[i] > number)
	            return ++nod;
	 
	        pf = false;
	        while (remain % primes[i] == 0) {
	            pf = true;
	            remain = remain / primes[i];
	        }
	        if (pf)
	            nod++;
	 
	        if (remain == 1)
	            return nod;
	    }
	    return nod;
	}
}
/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 x 7
15 = 3 x 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² x 7 x 23
645 = 3 x 5 x 43
646 = 2 x 17 x 19.

Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
*/