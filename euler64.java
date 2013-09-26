/*
 * Andrew Koroluk
 */

public class euler64 {
	public static void main(String[] args) {
        int ans = 0;

        for (int i = 2; i <= 10000; i++) {
            int limit = (int) Math.sqrt(i);                                
            if (limit * limit == i) continue;
            
            int period = 0;
            int d = 1;
            int m = 0;
            int a = limit;

            while(true){                
                m = d*a - m;                    
                d = (i - m * m) / d;
                a = (limit + m) / d;
                period++;
                if(a == 2*limit) break;
            }
            
            if (period % 2 == 1) ans++;
		}
		
		System.out.println(ans);	//1322
	}
}