/*
 * Andrew Koroluk
 */

class Palindrome {
	private char[] a1;

	public void setArray (char[] array){
		a1=array;
	}

	public boolean test() {
		char a = a1[0];
		char b = a1[1];
		char c = a1[2];
		char d = a1[3];
		char e = a1[4];
		char f = a1[5];
		if (a==f && b==e && c==d) {return true;}
		else {return false;}
	}
}

public class euler4{
	public static void main (String[] args){
		char[] array = new char[] {0, 0, 0, 0, 0, 0};
		String n;
		//char a;
		int i;

		for(int x=999; x>=900; x--) {
			for(int y=999; y>=900; y--) {
				i=x*y;
				n = Integer.toString(i);
				array = n.toCharArray();

				Palindrome p1 = new Palindrome();
				p1.setArray(array);

				if (p1.test()) {
					System.out.println(i);
					//break;
				}
			}
		}
	}
}

/*
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91  99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */