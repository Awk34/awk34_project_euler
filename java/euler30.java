/*
 * Andrew Koroluk
 */

public class euler30 {
	public static void main(String[] claymore) throws Exception {
		int sum=0;
		for(int i=2; i<=354294; i++) {
			if(i==meth(i, 5)) {
				sum+=i;
				System.out.println("Number: "+i+", Sum now="+sum);
			}
		}
		System.out.println("Answer: "+sum);
	}

	static int meth(int a, int b) throws Exception {
		int ans=0;
		for(int i=String.valueOf(a).trim().length(); i>0; i--) {
			ans+=Utils.pwr(Utils.numAt(a, i), b);
		}
		return ans;
	}
}

/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 1^4 + 6^4 + 3^4 + 4^4
8208 = 8^4 + 2^4 + 0^4 + 8^4
9474 = 9^4 + 4^4 + 7^4 + 4^4
As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/