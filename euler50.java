/*
 * Andrew Koroluk
 */

//import java.util.ArrayList;

public class euler50 {
	public static int max = 0;
	public static void main(String args[]) {
		int sum = 0;
		int count=0;
		for(int i = 2; i <4000; i++) {
			count=0;
			sum = 0;
			for(int j = i; j<4000;j++)          
				if(Utils.isPrime(j)) {
					count++;
					sum = sum + j;
					if(Utils.isPrime(sum))
						if(sum<1000000)
							if(max<count) {
								max = count;
								System.out.println(sum);	//997651
							}
				}
		}
	}
}

/*
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/