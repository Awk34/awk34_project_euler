/*
 * Andrew Koroluk
 */

import java.io.*;

public class Sudoku {
	static int[][] puzzle;
	static int[][] solved;
	
	public Sudoku(int[][] m) throws IOException {
		puzzle = m;
	}

	static boolean works(int num, int row, int col) {
		for(int i=0; i<9; i++) {
			if(puzzle[row][i] == num) return false;
			if(puzzle[i][col] == num) return false;
		}
		
		int topleftrow = row-row%3;
		int topleftcol = col-col%3;
		for(int ii=topleftrow; ii<topleftrow+3; ii++)
			for(int jj=topleftcol; jj<topleftcol+3; jj++)
				if(num==puzzle[ii][jj])
					return false;	//conflict
		return true;	//no conflicts
	}

	static int zeroes() {
		int ans=0;
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(puzzle[i][j]==0)
					ans++;
		return ans;
	}
	public void solve() {
		solve(puzzle, zeroes());
	}
	public static boolean solve(int[][] a, int zeroes) {
		//print(a);
		if(zeroes==0) {
			solved = a;
			return true;
		}
		int[] next0 = next0(a);
		for(int i=1; i<=9; i++) {
			//System.out.println("Trying "+i+" at ("+next0[0]+", "+next0[1]+"), i="+i);
			if(works(i, next0[0], next0[1])) {
				a[next0[0]][next0[1]] = i;
				//System.out.println(""+i+" Worked at ("+next0[0]+", "+next0[1]+")");
				boolean b = solve(a, zeroes-1);
				if(b) return true;
			}
			a[next0[0]][next0[1]] = 0;
		}
		return false;
	}
	private static int[] next0(int[][] a) {
		for(int row=0; row<9; row++)
			for(int col=0; col<9; col++)
				if(a[row][col]==0) return new int[] {row, col};
		return null;
	}
	void print() {
		System.out.print(" ----------------------\n");
		for(int i=0; i<9; i++) {
			System.out.print("|");
			for(int j=0; j<9; j++) {
				if(puzzle[i][j]!=0)
					System.out.print(puzzle[i][j] + " ");
				else System.out.print("  ");
				if(j==2||j==5||j==8)
					System.out.print("| ");
			}
			System.out.print("\n");
			if(i==2||i==5||i==8)
				System.out.print(" ----------------------\n");
		}
		System.out.print("\n");
	}
	static void print(int[][] a) {
		System.out.print(" ----------------------\n");
		for(int i=0; i<9; i++) {
			System.out.print("|");
			for(int j=0; j<9; j++) {
				if(a[i][j]!=0)
					System.out.print(a[i][j] + " ");
				else System.out.print("  ");
				if(j==2||j==5||j==8)
					System.out.print("| ");
			}
			System.out.print("\n");
			if(i==2||i==5||i==8)
				System.out.print(" ----------------------\n");
		}
		System.out.print("\n");
	}
	int first3() {	//for Project Euler #96
		return puzzle[0][0]*100 + puzzle[0][1]*10 + puzzle[0][2];
	}
}