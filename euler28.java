/*
 * Andrew Koroluk
 */

public class euler28 {
	public static void main(String[] args) {
		int ans = 1;
		int tot = 1;
		for(int i=2; i<=1000; i+=2) {
			for(int j=1; j<=4; j++) {
				tot +=i;
				ans+=tot;
			}
		}
		System.out.println(ans);
	}
}