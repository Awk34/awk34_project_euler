/*
 * Andrew Koroluk
 */

public class euler91 {
	public static void main(String[] args) {
		int max=50;
		int ans = max*max*3;
		for (int x = 1; x <= max; x++) {
		    for (int y = 1; y <= max; y++) {
		        int fact = Utils.gcd(x, y);
		        ans += Math.min(y*fact/x, (max - x)*fact/y) * 2;
		    }
		}
		
		System.out.println(ans);	//14234
	}
}