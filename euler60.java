/*
 * Andrew Koroluk
 */

import java.util.HashSet;

public class euler60 {
	static int[] primes;
	public static void main(String[] args) {
		int result = Integer.MAX_VALUE;
		System.out.println(result);
		primes = primeSieve.sieve(30000);
		
		@SuppressWarnings("rawtypes")
		HashSet[] pairs = new HashSet[primes.length];
		 
		for (int a = 1; a < primes.length; a++) {
		    if (primes[a] * 5 >= result) break;
		    if (pairs[a] == null) pairs[a] = MakePairs(a);
		    for (int b = a + 1; b < primes.length; b++) {
		        if (primes[a] + primes[b] * 4 >= result) break;
		        if (!pairs[a].contains(primes[b])) continue;
		        if (pairs[b] == null) pairs[b] = MakePairs(b);
		 
		        for (int c = b + 1; c < primes.length; c++) {
		            if (primes[a] + primes[b] + primes[c] * 3 >= result) break;
		            if (!pairs[a].contains(primes[c]) || !pairs[b].contains(primes[c])) continue;
		            if (pairs[c] == null) pairs[c] = MakePairs(c);

		            for (int d = c + 1; d < primes.length; d++) {
		                if (primes[a] + primes[b] + primes[c] + primes[d] * 2 >= result) break;
		                if (!pairs[a].contains(primes[d]) ||
		                !pairs[b].contains(primes[d]) ||
		                !pairs[c].contains(primes[d])) continue;
		                if (pairs[d] == null) pairs[d] = MakePairs(d);
		 
		                for (int e = d + 1; e < primes.length; e++) {
		                    if (primes[a] + primes[b] + primes[c] + primes[d] + primes[e] >= result) break;
		                    if (!pairs[a].contains(primes[e]) ||
		                    !pairs[b].contains(primes[e]) ||
		                    !pairs[c].contains(primes[e]) ||
		                    !pairs[d].contains(primes[e])) continue;
		 
		                    if (result > primes[a] + primes[b] + primes[c] + primes[d] + primes[e])
		                        result = primes[a] + primes[b] + primes[c] + primes[d] + primes[e];
		 
		                    System.out.println(primes[a] +" " + primes[b] +" " + primes[c] +" " + primes[d] +" " + primes[e] +" " + result);
		                    break;	//26033
		                }
		            }
		        }
		    }
		}
	}
	static int concat(int a, int b) {
		try {
			return Integer.parseInt(Integer.toString(a) + Integer.toString(b));
		} catch(NumberFormatException e) {
			//e.printStackTrace();
			return 0;
		}
	}
	private static HashSet<Integer> MakePairs(int a) {
	    HashSet<Integer> pairs = new HashSet<Integer>();
	    for (int b = a + 1; b < primes.length; b++) {
	        if (Utils.isPrime(concat(primes[a], primes[b])) &&
	        	Utils.isPrime(concat(primes[b], primes[a])))
	            pairs.add(primes[b]);
	    }
	    return pairs;
	}
}

/*
int result = Integer.MAX_VALUE;
System.out.println(result);
primeSieve erat = new primeSieve(30000);
erat.find_primes();
int[] primes = erat.primes;

ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
for(int i=0; i<primes.length; i++) {
	ArrayList<Integer> temp = new ArrayList<Integer>();
	temp.add(primes[i]);
	a.add(temp);
}		

for(int i=0; i<1000; i++) {
	ArrayList<Integer> temp = new ArrayList<Integer>();
	int x = combine(a.get(i).get(0), primes[i]);
	System.out.println(x);
	if(Utils.isPrime(x)) temp.add(primes[i]);
}
System.out.println(a);
System.out.println(Utils.isPrime(347));
*/