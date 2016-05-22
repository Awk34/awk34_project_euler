/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler20 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("1");
        //BigInteger lim= new BigInteger("1");
        BigInteger i= new BigInteger("100");
		for(int j=1; j<=99; j++) {
			BigInteger jj = new BigInteger(Integer.toString(j));
			a = a.multiply(i.subtract(jj));
		}

		System.out.println(a);

		String str = a.toString(10);
        System.out.println();

        int sum = 0;
        for(int x=0; x<=155; x++) {
			sum+=Character.digit(str.charAt(x), 10);
		}
		System.out.println(sum);
    }
}

/*
n! means n x (n - 1) x ... x 3 x 2 x 1

Find the sum of the digits in the number 100!
*/