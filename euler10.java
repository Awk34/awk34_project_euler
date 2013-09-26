//************************
//* Andrew Koroluk       *
//* Project Euler - 10   *
//************************

public class euler10 {
	public static void main (String[] args) {
		long sum=0;
		for(int i=2;i<2000000;i++)
			if(isPrime (i))
				sum+=i;
		System.out.println ("The Answer to PE #10 is "+sum);
	}

	public static boolean isPrime(int num) {
		boolean prime = true;
		int limit = (int)Math.sqrt((double)num);

		for ( int i = 2; i <= limit; i++ )
			if ( num % i == 0 ) {
				prime = false;
				break;
			}
		return prime;
	}
}