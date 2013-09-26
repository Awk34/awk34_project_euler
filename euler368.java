/*
 * Andrew Koroluk
 */

import java.math.BigDecimal;

class euler368 {
	public static void main(String[] args) {
		BigDecimal ans = new BigDecimal("0.0");
		BigDecimal one = BigDecimal.ONE;
		for(int i=1; i<=1000000; i++) {
			if( hasTrip(i) ) continue;
			
			ans = ans.add( one.divide( new BigDecimal( i )) );
		}
		System.out.println( ans );
	}
	static boolean hasTrip(int a) {
		String s = Integer.toString(a);
		for(int i=0; i<s.length()-2; i++) {
			if( s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2) )
				return true;
		}
		return false;
	}
}