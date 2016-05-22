//***********************
// Andrew Koroluk       *
// Project Euler - 9    *
//***********************

import java.util.Random;

public class euler9
{
	public static void main(String [] args)
	{
		Random gen = new Random();
		int a = gen.nextInt(1000), b = gen.nextInt(1000), c = gen.nextInt(1000);

		while(a>=0 && b>=0 && c>=0)
		{
			if(a*a + b*b == c*c && a+b+c==1000)
			{
				System.out.println("a = " + a);
				System.out.println("b = " + b);
				System.out.println("c = " + c);
				break;
			}
			a = gen.nextInt(1000);
			b = gen.nextInt(1000);
			c = gen.nextInt(1000);
		}
	}
}