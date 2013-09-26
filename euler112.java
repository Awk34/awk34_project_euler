/*
 * Andrew Koroluk
 */

public class euler112 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		int bouncy=0, n=1;
		while( true ) {
			n++;
			if( isBouncy(n) ) bouncy++;
			//System.out.println( (double) bouncy/n*100 );
			if( (double) bouncy/n*100 == 99.0 ) break;
		}
		clock.getTimeSeconds();
		System.out.println(n);	//1587000
		System.out.println(bouncy);	//1571130
	}
	static boolean isBouncy(int n) {
		//int[] s = toIntArray(Integer.toString(n));
		//if( s.length < 3 ) return false;
		if( isIncreasing(n) || isDecreasing(n) ) return false;
		return true;
	}
	static boolean isIncreasing(int n) {
		int[] s = toIntArray(Integer.toString(n));
		for(int i=1; i<s.length; i++)
			if(s[i-1]>s[i]) return false;
		return true;
	}
	static boolean isDecreasing(int n) {
		int[] s = toIntArray(Integer.toString(n));
		for(int i=1; i<s.length; i++)
			if(s[i-1]<s[i]) return false;
		return true;
	}
	private static int[] toIntArray(String s) {
		int[] a = new int[s.length()];
		for(int i=0; i<a.length; i++)
			a[i] = Integer.parseInt( Character.toString( s.charAt(i) ) );
		return a;
	}
}