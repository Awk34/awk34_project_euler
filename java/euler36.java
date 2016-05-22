/*
 * Andrew Koroluk
 */

public class euler36 {
	public static void main(String[] args) {
		long ans = 0;
		for(int i=1; i<1000000; i++) {
			if(Utils.isPalindrome(i) && Utils.isPalindrome(base2(i))) {System.out.println(i+" "+base2(i)); ans+=i;}
		}
		System.out.println(ans); //872187
	}
	public static String base2(int x) {
		String str = "";
		if(x/2!=0) str+= (x%2+base2((int)(x/2)));
		else str+= x%2;
		return str;
	}
}