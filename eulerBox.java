/*
 * Andrew Koroluk
 */

//import java.util.Scanner;
//import java.math.BigInteger;

class Euler {
	public long factorial (int num) {
		long result=1;

		for(int i=num; i>=1; i--) {
			result *= i;
		}

		return result;
	}
	public long pascal (int num1, int num2) {
		long result=1;

		result = (num1*factorial(num1-1)) / factorial(num2);	//NOT TOO SURE ABOUT THIS

		return result;
	}
}

public class eulerBox {
	public static void main(String[] args) {
		//Scanner reader = new Scanner(System.in);
		//BigInteger a = new BigInteger("0");
		Euler f = new Euler();
		long end = 0;

		for(int i=1; i<=20; i++) {
			for(int j=1; j<=20; j++) {
				end += f.pascal(i,j);
			}
		}

		System.out.println(end);
	}
}

/*

*/