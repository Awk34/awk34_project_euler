/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler125 {
	public static void main(String[] args) {
		long limit = Utils.pwr(10,8);
		ArrayList<Long> a = new ArrayList<Long>();
				 
		for(long i=1; i<limit; i++) {
			long x = i*i;
			for(long j=i+1; j<limit; j++) {
				x += j*j;
				if(x>=limit) break;
				if(Utils.isPalindrome(x))
					a.add(x);
			}
		}
		
		Utils.removeDuplicates(a);
		System.out.println(Utils.sum(a)+" "+a);	//2906969179
	}
}