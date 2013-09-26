/*
 * Andrew Koroluk
 */

//import java.math.BigDecimal;

public class euler40 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int ans = 1;
		String s = "";
		//BigDecimal b = BigDecimal.ZERO;
		
		for(int i=1; i<=1000000; i++) {
			s+=Integer.toString(i);
			if(s.length()>1000000) break;
			if(i%10000==0) System.out.println(s.length());
		}
		//System.out.println(s);
		
		ans*= Integer.parseInt(Character.toString(s.charAt(100-1)));
		ans*= Integer.parseInt(Character.toString(s.charAt(1000-1)));
		ans*= Integer.parseInt(Character.toString(s.charAt(10000-1)));
		ans*= Integer.parseInt(Character.toString(s.charAt(100000-1)));
		ans*= Integer.parseInt(Character.toString(s.charAt(1000000-1)));
		System.out.println("Time Taken: "+(System.currentTimeMillis()-time)/1000+" seconds.");
		System.out.println(ans);	//210
		
		/*for(int i=100; i<=l; i*=10) {
			ans*=Integer.parseInt(Character.toString(s.charAt(i-1)));
		}
		System.out.println(ans);*/
	}
}