//***********************
// Andrew Koroluk       *
// Project Euler - 7    *
//***********************

public class euler7
{
	public static boolean isPrime ( int num )
	{
		boolean prime = true;
		int limit = (int) Math.sqrt ( num );

		for ( int i = 2; i <= limit; i++ )
		{
			if ( num % i == 0 )
			{
			prime = false;
			break;
			}
		}
	return prime;
	}

	public static void main ( String[] args )
	{
		int primes=1;
		for ( int i = 2; i >= 0; i++ )
		{
			if ( isPrime (i) && primes<=10001 )
			{
				primes++;
				System.out.println ( i );
			}
		}
	}
}