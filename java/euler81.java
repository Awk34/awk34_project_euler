/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class euler81 {
	public static void main(String[] args) {
		int[][] matrix = new int[80][80];
		try {
			BufferedReader b = new BufferedReader(new FileReader("matrix.txt"));
			for(int y=0; y<80; y++) {
				String s = b.readLine();
				String meow = "";
				int pos = 0;
				for(int x=0; x<s.length(); x++) {
					if(s.charAt(x)==',') {
						matrix[y][pos] = Integer.parseInt(meow);
						meow = "";
						pos++;
					}
					else {
						meow += s.charAt(x);
					}
				}
				matrix[y][pos] = Integer.parseInt(meow);
			}
			b.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		//for(int i=0; i<matrix.length; i++) Utils.print(matrix[i]);
		
		int nrows = matrix.length-1, minx;
				 
		for(int i=nrows; i>=0; i--)
			for(int j=nrows; j>=0; j--) {
				if (i==nrows && j==nrows) continue;
				if (j==nrows) minx = matrix[i+1][j];
				else if (i==nrows) minx = matrix[i][j+1];
				else minx = Math.min(matrix[i+1][j], matrix[i][j+1]);
				matrix[i][j] += minx;
			}
				 
		System.out.println(matrix[0][0]);	//427337
	}
}