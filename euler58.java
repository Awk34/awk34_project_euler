/*
 * Andrew Koroluk
 */

public class euler58 {
	public static void main(String[] args) {
		int P=0, d=1, n=2;
		float avg=1;
		  
		while( avg >= .10 ) {
			if(Utils.isPrime(d+n)) P++;
			if(Utils.isPrime(d+n*2)) P++;
			if(Utils.isPrime(d+n*3)) P++;
			d += n*4;
			n += 2;
			avg = (float)P/(2*n);
		}
		
		System.out.println(n-1);	//26241
	}
}