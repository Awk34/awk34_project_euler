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
public class primeSieve {
	public static void main(String[] args) {
		for(int i=2; i<11999999; i++) {
			if(11999999%i==0)
				System.out.println(i);
		}
		System.out.println("Woot!");
		Clock c = new Clock();
		//Utils.print(sieve(12000000));
		c.getTimeSeconds();
	}
	public static int[] sieve(int end) {
		int start = 2;

	    //long startTime = System.currentTimeMillis();

	    /* some basic range checks */
	    if(end < start || start < 1 || end  < 1) {
	        throw new ArithmeticException("Messed up input");
	    }

	    /* generate ints within range */
	    int[] naturals = new int[(int)Math.floor((end-start+1) / 2) + 1];
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
	    List<Integer> list = new ArrayList<Integer>();
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

	    int[] primes = new int[size];

	    if(start <= 2) {
	        primes[0] = 2;
	    }

	    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
	        primes[k++] = ((Integer) iterator.next()).intValue();
	    }

	    //System.out.println("Preparing end: \t" + (System.currentTimeMillis() - startTime));
	    return primes;
	    }
	}