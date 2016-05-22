/*
 * Andrew Koroluk
 */

public class euler2 {
	public static void main(String [] args) {
		int num1=1, num2=1, num3, sum=0, max;
		max = 4000000;

		while(num2 < max) {
			if(num2%2==0) {
				sum += num2;
				System.out.println(num2);
			}
			num3 = num2;
			num2 = num1 + num2;
			num1 = num3;
		}

		System.out.println("The Sum of all even Fibonacci numbers below " + max + " is " + sum);
	}
}