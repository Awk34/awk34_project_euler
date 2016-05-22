/*
 * Andrew Koroluk
 */

public class euler43 {
	public static void main(String[] args) {//16695334890
		//System.out.println(d(1406357289));
		//System.out.println(isPandigital(1406357289));
		//System.out.println(d(146357289));
		//if(true) return;
		long ans = 0;
		for(long i=1023456789; i<=9876543210L; i++) {
			if(Integer.parseInt(Long.toString(i).substring(7, 10))%17!=0) {continue;}
			if(Integer.parseInt(Long.toString(i).substring(5))!=5) {continue;}
			if(Integer.parseInt(Long.toString(i).substring(5, 8))%11!=0) {continue;}
			if(Integer.parseInt(Long.toString(i).substring(6, 6))%13!=0) {continue;}			
			if(isPandigital(i)) 
				if(d(i))
					ans+=i;
					
		}
		System.out.println(ans);
	}
	private static boolean isPandigital(long i) {
		String s = Long.toString(i);
		for(int x=0; x<=s.length()-1; x++) {
			if(!s.contains(Integer.toString(x))) {
				return false;
			}
		}
		
		return true;
	}
	static boolean d(long i) {
		long[] primes = {2,3,5,7,11,13,17};
		int p = 0;
		String s = Long.toString(i);
		for(int digit=1; digit<=7; digit++) {
			long num = Integer.parseInt(s.substring(digit, digit+3));
			//System.out.println(num+" / "+primes[p]);
			if(!(num%primes[p]==0)) return false;
			else p++;
		}
		System.out.println(s+" ++");
		return true;
	}
}