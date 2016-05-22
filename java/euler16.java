/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler16 {
    public static void main(String... args) {
        BigInteger a = new BigInteger("4");
        a = a.pow(500);
        System.out.println(a);

        String str = a.toString(10);
        System.out.println();

        long sum = 0;
        for(int i=0; i<=301; i++) {
			sum+=Character.digit(str.charAt(i), 10);
		}
		System.out.println(sum);
    }
}

/*
215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?
*/