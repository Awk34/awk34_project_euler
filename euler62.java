/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler62 {
	public static void main(String[] args) {
		long n = 345, ans;
		ArrayList<long[]> cubes = new ArrayList<long[]>();
		
		while (true) {
		    n++;
		    long smallestPerm = makeLargestPerm(n*n*n);
		    if (!containsKey(cubes, smallestPerm)) {
		        cubes.add(new long[]{smallestPerm, n, 0});
		    }
		    
		    if (++getDung(cubes, smallestPerm)[2] == 5) {
		        ans = getDung(cubes, smallestPerm)[1];
		        break;
		    }
		}
		System.out.println(ans*ans*ans);
		//127035954683
	}
	public static long makeLargestPerm(long n) {
	    long k = n;
	    int[] digits = new int[10];
	    long retVal = 0;
	 
	    while (k > 0) {
	        digits[(int)(k % 10)]++;
	        k /= 10;
	    }
	 
	    for (int i = 9; i >= 0; i--) {
	        for (int j = 0; j < digits[i]; j++) {
	            retVal = retVal * 10 + i;
	        }
	    }
		return retVal;
	}
	//crap search. if it takes too long, change to binary search
	static boolean containsKey(ArrayList<long[]> a, long n) {
		for(long[] i : a)
			if(i[0]==n) return true;
		return false;
	}
	static long[] getDung(ArrayList<long[]> a, long n) {
		for(int i=0; i<a.size(); i++)
			if(a.get(i)[0]==n)
				return a.get(i);
		System.out.println("You fool!");
		return new long[]{};
	}
}
/*
The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053).
In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
Find the smallest cube for which exactly five permutations of its digits are cube.
*/