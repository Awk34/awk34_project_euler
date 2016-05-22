/*
 * Andrew Koroluk
 */

import java.util.Scanner;

public class euler51 {
	public static void main(String[] args) throws Exception {
		/*ArrayList<Integer> primes = new ArrayList<Integer>();
		int pos = 0;
		for(int i=99999; i<1000000; i++) {
			if(Utils.isPrime(i)) {
				primes.add(pos, i);
				pos++;
			}
		}
		System.out.println(replace(999999,0,2,4,1));*/
		System.out.println(Utils.isPrime(120303));
		
		for(int i=99999; i<1000000; i++) {
			int prime = 0;
			/*for(int j=0; j<6; j++)
				for(int q=0; q<6 && q!=j; q++)
					for(int l=0; l<6 && l!=q; l++)*/
						for(int k=1; k<10; k++)
							if(Utils.isPrime(replace(i,0,2,4,k))) {prime++; System.out.println(replace(i,0,2,4,k)+" "+Utils.isPrime(replace(i,0,2,4,k)));}
			if(prime==8) {System.out.println(i+" "+Utils.isPrime(i)); new Scanner(System.in).nextLine();}
		}
	}

	static int replace(int i, int j, int q, int l, int k) {
		String str = Integer.toString(i);
		String ans = "";
		for(int w=0; w<str.length(); w++) {
			if (w==j || w==q || w==l) ans+=k;
			else ans+= str.charAt(w);
		}
		return Integer.parseInt(ans);
	}
}

/*By replacing the 1st digit of *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.*/