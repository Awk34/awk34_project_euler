/*
 * Andrew Koroluk
 * Project Euler - 1
 */

public class euler1 {
	public static void main(String [] args) {
		Clock clock = new Clock();
		clock.startNanos();
		int ans=0;

		for(int n=1; n<1000; n++)
			if(n%3==0 || n%5==0)
				ans += n;

		clock.getTimeNanos();
		System.out.println(ans);
	}
}
/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/