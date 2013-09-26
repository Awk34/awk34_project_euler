/*
 * Andrew Koroluk
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class euler265 {
	public static void main(String[] args) {
		//32 digits
		//000101 = 101
		BigInteger i, lim=new BigInteger("11111111111111111111111111111111"), one=BigInteger.ONE, ans=BigInteger.ZERO;
		for(i = new BigInteger("00010000000000000000000000000000"); i.compareTo(lim)<=0; i=i.add(one)) {
			/*ArrayList<Short> a = new ArrayList<Short>();
			for(int j=0; j<32; j++) {
				a.add( (short)Integer.parseInt(Character.toString(i.toString().charAt(j))) );
			}*/
			String s = i.toString();
			if(!works(s)) continue;
			else ans = ans.add(i);
		}
		System.out.println(ans);
	}
	private static boolean works(String s) {
		ArrayList<String> stack = new ArrayList<String>();
		int length = s.length();
		String t = "";
		for(int i=0; i<length-2; i++) {
			t = s.substring(i, i+3);
			if(stack.contains(t)) return false;
			stack.add(t);
		}
		t = s.substring(length-2, length) + s.substring(0, 1);
		if(stack.contains(t)) return false;
		stack.add(t);
		t = s.substring(length-1, length) + s.substring(0, 2);
		if(stack.contains(t)) return false;
		return true;
	}
}