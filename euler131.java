/*
 * Andrew Koroluk
 */

public class euler131 {	
	public static void main(String[] args) {		
		int limit;
		int ans = 0;
		
		for(int x=1; ; x++) {
			if( (x+1)*(x+1)*(x+1) - x*x*x > 1000000 ) {
				limit = x;
				break;
			}
		}
		
		for(int x=1; x<=limit; x++) {
			if( Utils.isPrime((x+1)*(x+1)*(x+1) - x*x*x)) {
				ans++;
			}
		}
		System.out.println(ans);	//173
	}
}