/*
 * Andrew Koroluk
 */

public class euler206 {
	public static void main(String[] args) {
		long 	start = 1000000000,
				end   = 1389026723;
		
		for(long x = start+30; x<end; x+=100)
			if(test(x*x)) System.out.println(x);
		for(long x = start+70; x<end; x+=100)
			if(test(x*x)) System.out.println(x);
		
		//1389019170
	}
	private static boolean test(long l) {
		String s = Long.toString(l);
		char c = '1';
		for(int i=0; i<s.length()-2; i+=2) {
			if(s.charAt(i) != c) return false;
			c = Character.toChars( c+1 )[0];
		}
		if(s.charAt(18) != '0') return false;
		
		return true;
	}
}