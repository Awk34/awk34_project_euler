/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler233 {
	static long[] primes;
	public static void main(String[] args) {
		//System.out.println(f(1047625));
		Clock c = new Clock();
		
		/*System.out.println(f(1328125)+" = 180?");
		System.out.println(f(84246500)+" = 420?");
		System.out.println(f(248431625)+" = 420?");
		
		c.getTimeSeconds();
		c.reset();*/
		
		long ans = 0;	//Math.pow(10, 11)
		//25*13=325
		//25*17=425
		//for N<38000000, ans = 30875234922
							  //12726092900
		for(int N=0; N<=38000000; N++) {
			if( N%13==0 || N%17==0 )
			if( f(N)==420 ) {
				ans += N;
				//System.out.println(N);
			}
			System.out.println( N + " - " + f(N) );
		}
		System.out.println(ans);
		c.getTimeSeconds();
	}
	static long f(long N) {
		return SquaresR2(N*N);
	}
	static boolean isIntLong(double a) {
		if(a==(double)(long)a) return true;
		return false;
	}
	static int SquaresR2(long n) {
		ArrayList<long[]> a = PFacWPowersLong(primeFactors(n));
		int ans = 4;
		
		for(int i=0; i<a.size(); i++) {
			long[] temp = a.get(i);
			//Utils.print(temp);
			if(temp[0]==2) continue;
			if(isP(temp[0]) && temp[1]%2==0) return 0;
			if(isQ(temp[0])) ans*= temp[1]+1;
		}
		return ans;
	}
	private static boolean isQ(long x) {
		double temp = (double)x;
		if( isIntLong((temp-1)/4) ) return true;
		return false;
	}
	private static boolean isP(long x) {
		double temp = (double)x;
		if( isIntLong( ((temp-3)/4) ) ) return true;
		return false;
	}
	public static ArrayList<Long> primeFactors(long numbers) {
		long n = numbers; 
		ArrayList<Long> factors = new ArrayList<Long>();
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1)
			factors.add(n);
		return factors;
	}
	public static ArrayList<long[]> PFacWPowersLong(ArrayList<Long> a) {
		ArrayList<long[]> ans = new ArrayList<long[]>();
		int lim = a.size();
		for(int i=0; i<lim; i++) {
			long temp = a.get(i);
			int sum = 1;
			while(i+1<lim && a.get(i+1) == temp) {
				sum++;
				a.remove(i+1);
				lim--;
			}
			long[] out = {temp,sum};
			ans.add(out);
		}
		return ans;
	}
}
/*
359125
469625
612625
718250
781625
866125
933725
939250
1047625
1119625
1225250
1288625
1336625
1366625
1436500
1481125
1542125
1563250
1592825
1596725
1732250
 */
/*
271204031455541309
(x+(N/2))^2 + (y+(N/2))^2 = r^2
y = Math.sqrt( r*r - (x+(N/2))*(x+(N/2)) )-(N/2);
r = Math.sqrt( 2 * n^2 ) /2
*/
/*System.out.println(r(1328125));

System.out.println(f(10000));
c.getTimeSeconds();
c.reset();

System.out.println(f(1328125));
c.getTimeSeconds();


LongPrimeSieve sieve = new LongPrimeSieve(10000000L);
sieve.find_primes();
primes = sieve.primes;


System.out.println("start");
Clock clock = new Clock();
while(true) {
	int i = new Scanner(System.in).nextInt();
	if(i==0) break;
	clock.reset();
	System.out.println(f2( primes[i] ));
	clock.getTimeSeconds();
}
if(true) return;

System.out.println(f(1328125));
System.out.println(f(84246500));
System.out.println(f(248431625));

long ans = 0;
for(int N=1; N<=primes.length; N++) {
	System.out.println(primes[N]);
	if( f2(primes[N])==420 ) {
		ans+= primes[N];
		System.out.println(N);
	}
}
System.out.println(ans);*/