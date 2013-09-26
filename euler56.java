import java.math.BigInteger;

/*
 * Andrew Koroluk
 */

public class euler56 {
	public static void main(String[] args) {
		int ans = 0;
		for(int i=99; i>10; i--) {
			for(int j=99; j>10; j--) {
				int temp = 0;
				BigInteger n = new BigInteger(Integer.toString(i));
				n = n.pow(j);
				String s = n.toString();
				System.out.println(s);
				for(int k=0; k<s.length(); k++)
					temp+= Integer.parseInt((Character.toString(s.charAt(k))));
				if(temp>ans) ans=temp;
			}
		}
		System.out.println(ans);	//972
	}
}