/*
 * Andrew Koroluk
 */

public class euler73 {
	public static void main(String[] args) {
		int a = 3, b = 2, ans = 0;
		 
		for (int d = 5; d <= 12000; d++)
		    for (int n = d / a + 1; n < (d - 1) / b + 1; n++)
		        if (Utils.gcd(n, d) == 1) ans++;
		
		System.out.println(ans);	//7295372
	}
}