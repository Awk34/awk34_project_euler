/*
 * Andrew Koroluk
 */

//import java.util.Scanner;

public class euler14 {
	public static void main(String[] args) {
		//Scanner reader = new Scanner(System.in);

		long chain = 0;
		long[] array = new long[2];
		for(long i=1000000; i>837790; i--) {
			/*if(i==997023) {
				long n = i;
				System.out.print(n + " - ");
				while(n!=1) {
					if(n%2==0) {	//if even
						n *= .5;
						System.out.println(n);
						reader.nextLine();
					}
					else {			//if odd
						n = n*3 +1;
						System.out.println(n);
						reader.nextLine();
					}
					chain++;
				}
				System.out.println(chain);

				if(chain>array[1]) {
					array[0] = i;
					array[1] = chain;
				}
				chain = 0;
			}*/

			long n = i;
			System.out.print(n + " - ");
			while(n!=1) {
				if(n<=0) {
					break;
				}
				if(n%2==0) {	//if even
					n *= .5;
				}
				else {			//if odd
					n = n*3 +1;
				}
				chain++;
			}
			System.out.println(chain);

			if(chain>array[1]) {
				array[0] = i;
				array[1] = chain;
			}
			chain = 0;
		}
		System.out.println(array[0]+" - "+array[1]);
	}
}

/*
The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/