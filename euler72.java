/*
 * Andrew Koroluk
 */

public class euler72 {
	public static void main(String[] args) {
		int lim = 1000000;
		int[] pi = new int[lim+1];
		for(int i=0; i<pi.length; i++)
			pi[i] = i;
		long ans = 0;
		for(int i = 2; i <= lim; i++){
		    if (pi[i] == i) {
		        for (int j = i; j <= lim; j += i) {
		            pi[j] = pi[j] / i * (i - 1);
		        }
		    }
		    ans += pi[i];
		}
		System.out.println(ans);	//303963552391
	}
}