/*
 * Andrew Koroluk
 */

import java.util.Scanner;
import java.math.BigInteger;

public class euler48_2 {
	public static void main(String[] args) {
	    Scanner reader = new Scanner(System.in);
	    BigInteger a = new BigInteger("1");
	    long n=0;
	    //System.out.println(Math.pow(1000, 1000));

	    ///*
	    for(double i=2; i<=1000; i++) {
			@SuppressWarnings("unused")
			BigInteger x = new BigInteger(Double.toString(i));
			n = (int)Math.pow(i, i);

			a = a.add(new BigInteger(Long.toString(n) ) );
			System.out.println(i+"\n"+n+"\n"+a);
			reader.nextLine();

		}
		int length = a.toString().length();
		for(int i=10;i>=1;i--) {
		System.out.print((a.toString()).charAt(length-i));
		}
		System.out.println("\n"+a);
		//*/
	}
}

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
*/