/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler96 {
	static ArrayList<int[][]> read(File f) {
		Scanner s;
		try { s = new Scanner(f);
		} catch (FileNotFoundException e) { e.printStackTrace(); return null; }
		
		ArrayList<int[][]> ans = new ArrayList<int[][]>();
		while(s.hasNextLine()) {
			s.nextLine();
			int[][] m = new int[9][9];
			for(int i=0; i<9; i++) {
				String str = s.nextLine();
				for(int j=0; j<9; j++)
					m[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
			}
			ans.add(m);
		}
		s.close();
		return ans;
	}
	public static void main(String[] municiple) throws IOException {
		int ans=0;
		ArrayList<int[][]> a = new ArrayList<int[][]>();
		a = read(new File( "sudoku.txt" ));
		
		for(int i=1; i<=50; i++) {
			System.out.println("Puzzle #"+i);
			Sudoku puzzle = new Sudoku(a.get(i-1));
			puzzle.solve();
			puzzle.print();
			ans += puzzle.first3();
		}
		
		System.out.println(ans);	//24702
	}
}