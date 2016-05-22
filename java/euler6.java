//***********************
// Andrew Koroluk       *
// Project Euler - 6    *
//***********************

public class euler6
{
	public static void main(String [] args)
	{
		int num1=1, num2=1, sum1=0, sum2=0, sum3=0;

		while(num1<=100)
		{

			sum1 = sum1 + (num1*num1);
			num1++;
		}
		while(num2<=100)
		{
			sum2 = sum2 + num2;
			num2++;
		}
		sum2 = (sum2*sum2);
		sum3 = sum2-sum1;
		System.out.println(sum3);
	}
}