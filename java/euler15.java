/*
 * Andrew Koroluk
 */

//import java.util.Scanner;
import java.math.BigInteger;

public class euler15 {
	public static void main(String[] args) {
		System.out.println(Utils.nCr(new BigInteger("40"), new BigInteger("20")));
	}
}

/*
Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20x20 grid?
*/