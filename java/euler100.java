/*
 * Andrew Koroluk
 */

import java.math.BigInteger;

public class euler100 {
	public static void main(String[] args) {
		BigInteger b = new BigInteger("85");
		BigInteger n = new BigInteger("120");
		while(n.compareTo(BigInteger.TEN.pow(12)) == -1) {
			BigInteger b1 = b;
			BigInteger n1 = n;
			b = (b1.multiply(new BigInteger("3")).add(n1.multiply(new BigInteger("2")))).subtract(new BigInteger("2"));
			n = (b1.multiply(new BigInteger("4")).add(n1.multiply(new BigInteger("3")))).subtract(new BigInteger("3"));
		}
		System.out.println(b);	//756872327473
	}
}