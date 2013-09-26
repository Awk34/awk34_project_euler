/*
 * Andrew Koroluk
 */

import java.util.Scanner;
import java.io.*;

class Sudoku_2 {
	private static int[][] matrix;

	public Sudoku_2(String file) throws IOException {
		Scanner filereader = new Scanner(new File(file));
		matrix = new int[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				matrix[i][j] = filereader.nextInt();
		filereader.close();
	}

	public Sudoku_2(String file, int start) throws IOException {
		Scanner filereader = new Scanner(new File(file));
		for(int i=1; i<=start; i++) filereader.nextInt();
		matrix = new int[9][9];
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				matrix[i][j] = filereader.nextInt();
		filereader.close();
	}

	private int findUniquefor(int i, int j) {
		int val=0;
		for(int k=1; k<=9; k++) {
			if(okay(k, i, j)) {
				if(val==0)
					val=k;
				else return 0;  //more than one possible
			}
		}
		return val;	//unique answer
	}

	private boolean okay(int k, int i, int j) {
		for(int jj=0; jj<9; jj++)	//for each column
			if(jj!=j)				//except itself
				if(k==matrix[i][jj])//if the possible answer is already in there
					return false;	//its wrong
		for(int ii=0; ii<9; ii++)
			if(ii!=i)
				if(k==matrix[ii][j])
					return false;
		int topleftrow = i-i%3;
		int topleftcol = j-j%3;
		for(int ii=topleftrow; ii<topleftrow+3; ii++)
			for(int jj=topleftcol; jj<topleftcol+3; jj++)
				if(ii!=i || jj!=j)
					if(k==matrix[ii][jj])
						return false;//conflict
		return true;	//no conflicts
	}

	public void rule1() {//one possible answer
		boolean f=false;
		while(!f) {
			f=true;
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(matrix[i][j]==0) {
						int val = findUniquefor(i, j);
						if(val!=0) {
							matrix[i][j]=val;
							f=false;
						}
					}
				}
			}
		}
	}

	int zeros() {
		int ans=0;
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				if(matrix[i][j]==0)
					ans++;
		return ans;
	}

	public static void solve(Sudoku_2 euler) {
		print();
		int zeros = euler.zeros();
		int oldzeros = zeros+1;
		while(zeros<oldzeros) {//until no more possible solutions for rule1
			oldzeros = zeros;
			euler.rule1();
			//System.out.println("Result of rule1: ");
			//print();
			if(euler.zeros()==0)
				return;
			zeros=euler.zeros();
		}
	}

	static void print() {
		System.out.print(" ----------------------\n");
		for(int i=0; i<9; i++) {
			System.out.print("|");
			for(int j=0; j<9; j++) {
				if(matrix[i][j]!=0)
					System.out.print(matrix[i][j] + " ");
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

	static int first3() {
		if(matrix[0][0]==0||matrix[0][1]==0||matrix[0][2]==0) System.out.println("Caution: contains 0");
		return matrix[0][0] + matrix[0][1] + matrix[0][2];
	}

	public static void main(String[] municiple) throws IOException {
		/*while(true) {
			Scanner s = new Scanner(System.in);
			String file = s.next();
			if(file.equalsIgnoreCase("q"))
				break;
			Sudoku puzzle = new Sudoku(file);
			solve(puzzle);
		}*/
		int start=1;
		int ans=0;
		for(int i=1; i<=50; i++) {
			System.out.println("Puzzle #"+i);
			Sudoku_2 euler = new Sudoku_2("sudoku.txt", start);
			solve(euler);
			print();
			ans+=first3();
			start+=82;
			new Scanner(System.in).nextLine();
		}

		/*Sudoku puzzle = new Sudoku("sudoku2.txt");
		solve(puzzle);
		print();*/

		System.out.println(ans);
	}
}