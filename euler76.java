/*
 * Andrew Koroluk
 */

public class euler76 {
	public static void main(String[] args) {
		int[] a = new int[101];
		a[0] = 1;
		 
		for (int i = 1; i <= 99; i++)
		    for (int j = i; j <= 100; j++)
		        a[j] += a[j - i];
		
		System.out.println(a[100]);	//190569291
	}
}