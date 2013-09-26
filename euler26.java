/*
 * Andrew Koroluk
 */

import java.math.BigDecimal;
//import java.util.Scanner;

public class euler26 {
	public static void main(String[] args) throws InterruptedException {
		//System.out.println(BigDecimal.ONE.divide(new BigDecimal(983),10000,0));
		long time = System.currentTimeMillis();
		int ans = 0;
		for(	BigDecimal i=new BigDecimal(7);
				i.compareTo(new BigDecimal(1000))==-1;
				i=i.add(BigDecimal.ONE)) {
			if(d(i)>ans) ans=Integer.parseInt(i.toString());
		}
		System.out.println(ans);
		System.out.println("Time Taken: "+(System.currentTimeMillis()-time)/1000+" seconds");
	}
	static int d(BigDecimal x) throws InterruptedException {
		x = new BigDecimal(1).divide(x,10000,0);
		String s = x.toString();
		s = s.substring(2);
		while(s.charAt(0)=='0')
			s = s.substring(1);
		//System.out.println(s);
		//Thread.sleep(500);
		
		int ans = 0;
		int a = 1;
		int x1=0;
		int y1=1;
		while(true) {
			try {
			if(s.substring(x1,y1).equals(s.substring(x1+a,y1+a))) {ans = a; break;}
			else {y1++; a++;}
			} catch(Exception E) {return 0;}
		}
		//System.out.print(ans+" "+s+"/n");
		//new Scanner(System.in).nextLine();
		return ans;
	}
}
/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/