/*
 * Andrew Koroluk
 */

public class euler92 {
	public static void main(String[] args) {
		int ans = 0;
		for(int i=1; i<10000000; i++)
			if(f(i))
				ans++;
		
		System.out.println(ans); //8581146
	}
	public static boolean f(int x) {
		int y = 0;
		int digits = 0;
		String s = Integer.toString(x);
		while(true) {
			digits = s.length();
			char[] c = s.toCharArray();
			for(int i=0; i<digits; i++) {
				y += Integer.parseInt(Character.toString(c[i]))*Integer.parseInt(Character.toString(c[i]));
			}
			
			if(y==1)
				return false;
			else if(y==89)
				return true;
			else {
				x=y;
				y=0;
				s = Integer.toString(x);
			}
		}
	}
}

/*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44  32  13  10  1  1
85  89  145  42  20  4  16  37  58  89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?
*/