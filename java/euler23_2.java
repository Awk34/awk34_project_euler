import java.util.ArrayList;
import java.util.Iterator;

/*
 * Andrew Koroluk
 */

public class euler23_2 {
	public static void main(String[] args) {
		System.out.println(d(12));
		int s = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int n=1; n<=20162; n++) {
		  if(d(n) > n)
		    a.add(n);
		  else {
			  Iterator<Integer> itr = a.iterator();
			  while (itr.hasNext()) {
				  if(a.contains(n-itr.next()))
					  s += n;
			  }
		  }
		}
		 
		System.out.println("Answer to PE #23 = "+s);
	}
	static int d(int n) {
		  int s = 1;
		  int t = (int) Math.sqrt(n);
		  for(int i=2; i<=t+1; i++)
		    if(n%i == 0) s += (i + n)/i;
		  if(t == (int)t) s -= t;
		  return s;
	}
}