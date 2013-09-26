/*
 * Andrew Koroluk
 */

//import java.util.ArrayList;

public class euler75 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		int ans = 0;
		
		int limit = 1500000;
		int[] triangles = new int[limit+1];
		int mlimit = (int)Math.sqrt(limit / 2);
		 
		for (long m = 2; m < mlimit; m++) {
		    for (long n = 1; n < m; n++) {
		        if (((n + m) % 2) == 1 && Utils.gcd(n, m) == 1) {
		            long a = m * m + n * n;
		            long b = m * m - n * n;
		            long c = 2 * m * n;
		            long p = a + b + c;
		            while(p <= limit){
		                triangles[(int)p]++;
		                if (triangles[(int)p] == 1) ans++;
		                if (triangles[(int)p] == 2) ans--;
		                p += a+b+c;
		            }
		        }
		    }
		}
		
		clock.getTimeMillis();
		System.out.println(ans);	//161667
	}
}