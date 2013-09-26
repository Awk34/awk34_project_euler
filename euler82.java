/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class euler82 {
	public static void main(String[] args) {
		int[][] a = new int[80][80];
		try {
			BufferedReader b = new BufferedReader(new FileReader("matrix.txt"));
			for(int y=0; y<80; y++) {
				String s = b.readLine();
				String meow = "";
				int pos = 0;
				for(int x=0; x<s.length(); x++) {
					if(s.charAt(x)==',') {
						a[y][pos] = Integer.parseInt(meow);
						meow = "";
						pos++;
					}
					else {
						meow += s.charAt(x);
					}
				}
				a[y][pos] = Integer.parseInt(meow);
			}
			b.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		//for(int i=0; i<matrix.length; i++) Utils.print(matrix[i]);
		Clock clock = new Clock();
		
		int size = a.length;
		int[] ans = new int[size];
		
		for (int i = 0; i < size; i++)
			ans[i] = a[i][size - 1];
		
		for (int i = size - 2; i >= 0; i--) {
			ans[0] += a[0][i];
		    for (int j = 1; j < size; j++)
		    	ans[j] = Math.min(ans[j - 1] + a[j][i], ans[j] + a[j][i]);
		 
		    for (int j = size - 2; j >= 0; j--)
		    	ans[j] = Math.min(ans[j], ans[j+1] + a[j][i]);
		}
		
		clock.getTimeMillis();
		System.out.println(min(ans));	//260324
	}
	static int min(int[] a) {
		int min=a[0];
		for(int i=1; i<a.length; i++)
			if(a[i]<min) min = a[i];
		return min;
	}
}