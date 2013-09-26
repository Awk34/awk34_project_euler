public class euler94 {
	public static void main(String[] args) {
		int ans = 0;
		long x = 2;
		long y = 1;
		long limit = 1000000000;
		
		while(true) {
			long a_x_3 = 2*x - 1;
			long area_x_3 = y*(x-2);
			if (a_x_3 > limit) break;
			
			if(a_x_3 > 0 && area_x_3 > 0 && a_x_3 % 3 == 0 && area_x_3 % 3 == 0) {
				long a = a_x_3 / 3;
				
				ans += 3*a + 1;
			}
			
			a_x_3 = 2*x + 1;
			area_x_3 = y*(x + 2);
			if (a_x_3 > limit) break;
			
			if(a_x_3 > 0 && area_x_3 > 0 && a_x_3 % 3 == 0 && area_x_3 % 3 == 0) {
				long a = a_x_3 / 3;
				
				ans += 3*a - 1;
			}
			
			long x2 = 2*x + y*3;
		    long y2 = 2*y + x;
		 
		    x = x2;
		    y = y2;
		}
		
		System.out.println(ans);	//518408346
	}
}