/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler46 {
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> composites = new ArrayList<Integer>();
		for(int i=1; i<6000; i++) {
			if(Utils.isPrime(i)) primes.add(i);
			else if(i%2!=0) composites.add(i);
		}
		int x;
		for(int i=0; i<composites.size(); i++) {
			x = composites.get(i);
			boolean br = false;
			for(int k=0; k<primes.size(); k++) {
				br = false;
				for(int j=1; j<6000-x; j++) {
					if(x==primes.get(k)+2*j*j) {br=true; break;}
				}
				if(br) break;
			}
			if(!br) {System.out.println(x); break;}
		}
	}
}