/*
 * Andrew Koroluk
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class euler119 {
	public static void main(String[] args) {
		ArrayList<BigInteger> a = new ArrayList<BigInteger>();
		
		for(int b=2; b<600; b++) {
			for(int p=2; p<50; p++) {
				BigInteger x = Utils.pwr( new BigInteger(Integer.toString(b)), p );
				if(digSum(x).compareTo( new BigInteger(Integer.toString(b)) ) == 0) a.add(x);
				if(a.size()>33) break;
			}
		}
		
		Collections.sort(a);
		
		System.out.println(a.get(29));	//248155780267521
	}
	static long digSum(long a) {
		String s = Long.toString(a);
		long ans = 0;
		for(int i=0; i<s.length(); i++)
			ans += Integer.parseInt(Character.toString(s.charAt(i)));
		return ans;
	}
	static BigInteger digSum(BigInteger a) {
		String s = a.toString();
		BigInteger ans = BigInteger.ZERO;
		for(int i=0; i<s.length(); i++)
			ans = ans.add( new BigInteger(Character.toString(s.charAt(i))) );
		return ans;
	}
}