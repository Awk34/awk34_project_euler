/*
 * Andrew Koroluk
 */

public class euler41 {
	public static void main(String[] args) {
		/*ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
		BigInteger x = new BigInteger("1");
		while(true) {
			x = x.add(BigInteger.ONE);
			if(Utils.isPrime(x)) primes.add(x);
			if(x.compareTo(new BigInteger("987654321"))==1) break;
		}
		System.out.println(primes);*/
		
		int[] primes = primeSieve.sieve(10000000);
		for(int i=primes.length-1; true; i--) {
			if(isPandigital(primes[i])) {
				System.out.println(primes[i]);	//7652413
				break;
			}
		}
	}
	private static boolean isPandigital(int i) {
		String s = Integer.toString(i);
		for(int x=1; x<=s.length(); x++) {
			if(!s.contains(Integer.toString(x))) {
				return false;
			}
		}
		
		return true;
	}
}