/*
 * Andrew Koroluk
 */

public class euler301 {
	public static void main(String[] args) {
		int ans=0;
		for(int i=1; i<=(1<<30); i++)
			if( (i^(2*i)^(3*i)) == 0 ) ans++;
		System.out.println(ans);
	}
}