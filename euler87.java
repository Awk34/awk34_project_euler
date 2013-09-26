/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler87 {
	public static void main(String[] args) {
		Clock c = new Clock();
		int limit = 50000000;
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		int[] sieve2 = primeSieve.sieve(7072);
		int[] sieve3 = primeSieve.sieve(369);
		int[] sieve4 = primeSieve.sieve(84);
		
		for(int p4: sieve4) {
			for(int p3: sieve3) {
				for(int p2: sieve2) {
					int z = Utils.pwr(p2, 2) + Utils.pwr(p3, 3) + Utils.pwr(p4, 4);
					if(z < limit) a.add(z);
					else break;
					//System.out.println(p2+"^2 + "+p3+"^3 + "+p4+"^4 = "+z);
				}
			}
		}
		System.out.println(a.size());
		Utils.removeDuplicates(a);
		
		c.getTimeSeconds();
		System.out.println(a.size());	//1097343
	}
}