/*
 * Andrew Koroluk
 */

public class euler144 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		
		double x1 = 0;
		double y1 = 10.1;
		double x2 = 1.4;
		double y2 = -9.6;
		int ans=1;
		
		while(true) {
			double m0 = (y2-y1)/(x2-x1);
			double m1 = deriv(x2,y2);
			double tempX=x2, tempY=y2;
			double X = (m0-m1)/(1+m0*m1);
			double m2 = (m1-X)/(1+X*m1);
			//System.out.println(m2);
			
			//System.out.println("quadratic(m("+x1+","+y1+","+x2+","+y2+"),("+y1+"-"+m2+"*"+x1+"))");
			double b = (y2-m2*x2);
			x2 = quadratic(m2, b, x2);
			y2 = m2*x2 + b;
			System.out.println(x2+", "+y2);
			x1=tempX;
			y1=tempY;

			if(y2>0 && x2>-.01 && x2<.01) break;
			ans++;
		}
		clock.getTimeMillis();
		System.out.println(ans);
		
		
	}
	static double deriv(double x, double y) {
		return -4*x/y;
	}
	static double quadratic(double m2, double n, double x2) {
		double a = 4 + m2*m2;
		double b = 2*m2*n;
		double c = n*n - 100;
		
		double ans1 =  (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
		double ans2 =  (-b - Math.sqrt(b*b - 4*a*c))/(2*a);
	    double dx1 = x2 - ans1;
        double dx2 = x2 - ans2;
        dx1 = dx1>0 ? dx1 : -dx1;
        dx2 = dx2>0 ? dx2 : -dx2;
        
        if(dx1>dx2) return ans1;
        else return ans2;
	}
}