/*
 * Andrew Koroluk
 */

import java.util.Arrays;

public class euler381 {
	static int limit = 100000000; //10^8
	static boolean[] primes = new boolean[limit];
	
	public static void main(String[] args) {
		long ans = 480L;
		int p = 7;
		Clock clock = new Clock();
		
		fillPrimes();
		
		clock.getTimeSeconds();
		
		for(; p<limit; p++) {
			if(!primes[p]) continue;
			
			long bucket = 0L;
			
			//bucket += -1 % p;
			bucket += 1;
			//bucket += -1/(p-1) % p;
			//bucket += -1/( (p-1)*(p-2) ) % p;
			//bucket += -1/( (p-1)*(p-2)*(p-3) ) % p;
			//bucket += -1/( (p-1)*(p-2)*(p-3)*(p-4) ) % p;
			
			bucket = bucket % p;
			
			System.out.println("p= "+p+", bucket= "+bucket);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) { e.printStackTrace(); }
			
			ans += bucket;
		}
		
		System.out.println(ans);	//139602943319822
	}

	public static void fillPrimes() {
	    Arrays.fill(primes,true);
	    primes[0]=primes[1]=false;
	    for (int i=2;i<primes.length;i++) {
	        if(primes[i]) {
	            for (int j=2;i*j<primes.length;j++) {
	                primes[i*j]=false;
	            }
	        }
	    }
	}
}