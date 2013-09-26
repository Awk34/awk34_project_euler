/*
 * Andrew Koroluk
 */

public class euler3 {
	public static void main(String [] args) {
		Clock c = new Clock();
		long num=600851475143L;
		int fac=1;

		while(fac < num && fac > 0) {
			if(num%fac==0)
				System.out.println(fac);

			fac = fac+2;
		}
		c.getTimeSeconds();
	}
}