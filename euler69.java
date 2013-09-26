/*
 * Andrew Koroluk
 */

public class euler69 {
	public static void main(String[] args) {
		int ans = 1;
		int[] primes = primeSieve.sieve(200);
		int i = 0;
		 
		while(ans* primes[i] < 1000000){
		    ans *= primes[i];
		    i++;
		}
		System.out.println(ans);
	}
	public static int totient(int num){
		int count=0;
		for(int a=1;a<num;a++)
			if(GCD(num,a)==1)
				count++;
		return(count);
	}
	public static int GCD(int a, int b){
		int temp;
		if(a<b) {
			temp=a;
			a=b;
			b=temp;
		}
		if(a%b==0)
			return(b);
		return(GCD(a%b,b));
	}
}