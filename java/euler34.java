/*
 * Andrew Koroluk
 */

public class euler34 {
	public static void main(String[] args) throws Exception {
		int ans = 0;
		for(int i=10; i<99999; i++) {
			int size = Integer.toString(i).length();
			int duh = 0;
			for(int x=1; x<=size; x++) {
				duh+=Utils.factorial(Utils.numAt(i,x));
			}
			if(i==duh) {
				System.out.println(i);
				ans+=i;
			}
		}
		System.out.println(ans);
	}
}