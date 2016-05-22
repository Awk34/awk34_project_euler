/*
 * Andrew Koroluk
 */

public class euler63 {
	public static void main(String[] args) {
		int s = 0;
		for(double n=1; n<10; n++)
			s += (int)(1 / (1 - Math.log10(n)));
		System.out.println(s);
	}
}