/*
 * Andrew Koroluk
 */

//import java.math.BigInteger;
import java.util.ArrayList;

public class euler362 {
	public static void main(String[] args) {
		//BigInteger b = new BigInteger("54");
		System.out.println(S(100));
		System.out.println(F(54));
	}
	public static ArrayList<Integer> primeFactors(int numbers) {
		int n = numbers; 
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}
	static int unique(ArrayList<Integer> a) {
		ArrayList<Integer> unique = new ArrayList<Integer>();
		while(a.size()>0) {
			if(!unique.contains(a.get(0))) 
				unique.add(a.get(0));
			a.remove(0);
		}
		return unique.size();
	}
	static int F(int a) {
		return unique(primeFactors(a));
	}
	static int S(int n) {
		int ans = 0;
		for(int k=2; k<=n; k++) {
			ans += F(k);
		}
		return ans;
	}
}
/*
Consider the number 54.
54 can be factored in 7 distinct ways into one or more factors larger than 1:
54, 2x27, 3x18, 6x9, 3x3x6, 2x3x9 and 2x3x3x3.
If we require that the factors are all squarefree only two ways remain: 3x3x6 and 2x3x3x3.

Let's call Fsf(n) the number of ways n can be factored into one or more squarefree factors 
larger than 1, so Fsf(54)=2.

Let S(n) be Fsf(k) for k=2 to n.

S(100)=193.

Find S(10 000 000 000).
*/