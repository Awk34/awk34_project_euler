/*
 * Andrew Koroluk
 */

public class euler37 {
	public static void main(String[] pete) {
		int ans = 0;
		int x = 9;
		while(true) {
			x++;
			if(x>999999) break;
			if(!Utils.isPrime(x)) continue;
			String s = Integer.toString(x);
			boolean q = false;
			while(true) {
				s = s.substring(1);
				if(s.length()==0) { q=true; break; }
				if(!Utils.isPrime(Integer.parseInt(s))) break;
			}
			if(!q) continue;
			q=false;
			s = Integer.toString(x);
			while(true) {
				s = s.substring(0, s.length()-1);
				if(s.length()==0) { q=true; break; }
				if(!Utils.isPrime(Integer.parseInt(s))) break;
			}
			if(!q) continue;
			System.out.println(x);
			ans+=x;
		}
		System.out.println(ans);
	}
}
/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/