/*
 * Andrew Koroluk
 */

public class euler101 {
	static double[] y_j;
	static int nsize = 10;
	public static void main(String[] args) {
		y_j = new double[nsize];
		for(int i=0; i<nsize; i++)
			y_j[i] = f(i+1);
		
		System.out.println(P(2));
		//if(true) return;
		
		double ans = 0;
		for(double x=1; x<=nsize; x++) {
			double P = P(x+1);
			System.out.println("f("+x+") = " + f(x) + ", P("+(x+1)+") = " + P );
			ans += P;
		}
		System.out.println("Answer: "+ans);	//37076114526
	}
	static double P(double x) {
		double sum = 0;
		
		for(int j=1; j<=x-1; j++) {
			//System.out.println("P_"+j+"("+x+")");
			sum += P_j(j, x);
		}
		
		return sum;		
	}
	static double P_j(int j, double x) {
		double ans = y_j[j-1];
		for(int k=1; k<=x-1; k++) {
			if(k==j) continue;
			ans *= (double)(x-k)/(j-k);
		}
		return ans;
	}
	static double f(double n) {
		return 1 - n + n*n - p(n,3) + p(n, 4) - p(n, 5) + p(n, 6) - p(n, 7) + p(n, 8) - p(n, 9) + p(n, 10);
		//return n*n*n;
	}
	static double p(double a, double p) {
		return Math.pow(a, p);
	}
}