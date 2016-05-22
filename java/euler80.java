/*
 * Andrew Koroluk
 */

import java.math.BigDecimal;
import java.math.BigInteger;

public class euler80 {
	public static void main(String[] args) {
		BigSquareRoot bsr = new BigSquareRoot ();
		//bsr.setTraceFlag (true);
		bsr.setScale(101);
		bsr.setMaxIterations(20);
		
		Clock clock = new Clock();
		
		int ans = 0;
		for(int i=1; i<=100; i++) {
			if(Math.sqrt(i) == (double)(int)Math.sqrt(i)) continue;
			
			BigDecimal sqrt = bsr.get( new BigInteger(Integer.toString(i)) );
			sqrt = sqrt.multiply(BigDecimal.TEN.pow(99));
			int temp = digSum( sqrt.toBigInteger() );
			
			ans += temp;
			System.out.println(i+" "+temp);
		}
		
		clock.getTimeMillis();
		System.out.println(ans);	//40886
	}
	static int digSum(BigInteger a) {
		int ans = 0;
		String s = a.toString();
		for(int i=0; i<s.length(); i++)
			ans+= Integer.parseInt(Character.toString(s.charAt(i)));
		return ans;
	}
}