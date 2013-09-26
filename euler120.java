/*
 * Andrew Koroluk
 */

public class euler120 {
	public static void main(String[] args) {		
		int ans = 0;
		for(int a=3; a<=1000; a++)
			ans += rMax(a);
		System.out.println(ans);	//333082500
	}
	static int rMax(int a) {
		if(a%2==0) return (a*a)-(2*a);
		else return (a*a)-a;
	}
}
/*
Let r be the remainder when (a-1)^n + (a+1)^n is divided by a2.

For example, if a = 7 and n = 3, then r = 42: 6^3 + 8^3 = 728 === 42 mod 49.
And as n varies, so too will r, but for a = 7 it turns out that rmax = 42.

For 3  a  1000, find  rmax.
*/