/*
 * Andrew Koroluk
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

	/**
	 * returns an array of prime integers
	 * in the given range
	 * 
	 * @param start     range start
	 * @param end       range end
	 * @return
	 */
public class LongPrimeSieve {
	public static void main(String[] args) {
		Utils.print(sieve(500));
	}
	public static int start = 2;
	public static long[] sieve(long end) {
	    //long startTime = System.currentTimeMillis();

	    /* some basic range checks */
	    if(end < start || start < 1 || end  < 1) {
	        throw new ArithmeticException("Messed up input");
	    }

	    /* generate ints within range */
	    long[] naturals = new long[(int)Math.floor((end-start+1) / 2) + 1];
	    int allocator = 0;
	    for (int j = 0; j < end - start + 1; j++) {
	        if(!((start + j) % 2 == 0)) {
	            naturals[allocator++] = start + j;
	        }
	    }
	    //System.out.println("Allocation: \t" + (System.currentTimeMillis() - startTime));

	    /* init running prime to 2, and increment until
	     * running prime squared is greater than the end
	     */
	    for (int runningPrime = 2; end >= runningPrime*runningPrime; runningPrime++) {
	        for (int i = 0; i < naturals.length; i++) {
	            if(-1 != naturals[i]) {
	                if(naturals[i] != runningPrime && naturals[i] % runningPrime == 0) {
	                    naturals[i] = -1;
	                }
	            }
	        }
	    }
	    //System.out.println("Meat: \t\t" + (System.currentTimeMillis() - startTime));

	    /* handling that twat */
	    if(naturals[0] == 1) {
	        naturals[0] = -1;
	    }

	    /* list primes */
	    List<Long> list = new ArrayList<Long>();
	    for (int i = 0; i < naturals.length; i++) {
	        if(-1 != naturals[i])
	            list.add(naturals[i]);
	    }
	    //System.out.println("Listing: \t" + (System.currentTimeMillis() - startTime));

	    /* create the return int array */
	    int size = list.size();
	    int k = 0;

	    /* tricky tricky :) */
	    if(start <= 2) {
	        size += 1;
	        k = 1;
	    }

	    long[] primes = new long[size];

	    if(start <= 2) {
	        primes[0] = 2;
	    }

	    for (Iterator<Long> iterator = list.iterator(); iterator.hasNext();) {
	        primes[k++] = ((Long) iterator.next()).intValue();
	    }

	    //System.out.println("Preparing end: \t" + (System.currentTimeMillis() - startTime));
	    return primes;
	    }
	}