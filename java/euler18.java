/*
 * Andrew Koroluk
 */

//import java.util.Scanner;
//import java.math.BigInteger;

public class euler18 {
	private static int[][] a;
	public static void main(String[] args) {
		int[][] array ={{75, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{95, 64, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{17, 47, 82, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{18, 35, 87, 10, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{20, 04, 82, 47, 65, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{19, 01, 23, 75, 03, 34, 00, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{88, 02, 77, 73, 07, 63, 67, 00, 00, 00, 00, 00, 00, 00, 00},
				 		{99, 65, 04, 28, 06, 16, 70, 92, 00, 00, 00, 00, 00, 00, 00},
				 		{41, 41, 26, 56, 83, 40, 80, 70, 33, 00, 00, 00, 00, 00, 00},
				 		{41, 48, 72, 33, 47, 32, 37, 16, 94, 29, 00, 00, 00, 00, 00},
				 		{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 00, 00, 00, 00},
				 		{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57, 00, 00, 00},
				 		{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 00, 00},
				 		{63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 00},
				 		{04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23}};
		a=array;
		for(int i=1; i<=14; i++) {
			flattenRow(i);
		}
		findBiggest();
		System.out.println(a[1][0]);
		for(int i=0; i<a.length; i++) {
			Utils.print(a[i]);
		}
	}
	static void flattenCell(int row, int col) {
		if(row==0) return;
		if(col==0) {a[row][col] += a[row-1][col]; return;}
		if(col==14) {a[row][col] += a[row-1][col-1]; return;}
		
		if(a[row-1][col-1]>a[row-1][col]) {
			a[row][col] += a[row-1][col-1];
		}
		else {
			a[row][col] += a[row-1][col];
		}
	}
	static void flattenRow(int row) {
		for(int i=0; i<=14; i++) {
			flattenCell(row, i);
		}
	}
	static void findBiggest() {
		int ans=0;
		for(int i=0; i<=14; i++) {
			if(a[14][i]>ans) ans=a[14][i];
		}
		System.out.println(ans);
	}
}

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
*/