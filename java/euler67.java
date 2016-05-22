/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler67 {
	private static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("triangle.txt"));
		
		int row=0, num=1;
		while(s.hasNext()) {
			a.add(row, new ArrayList<Integer>());
			for(int i=1; i<=num; i++) {
				a.get(row).add(s.nextInt());
			}
			row++;
			num++;
		}
		
		System.out.println(a);
		
		for(int i=0; i<a.size(); i++) {
			flattenRow(i);
			//System.out.println(a.get(i));
		}
		findBiggest();
	}
	static void flattenCell(int row, int col) {
		if(row==0) return;
		if(col==0) {a.get(row).set(col, (a.get(row).get(col)).intValue() + a.get(row-1).get(col).intValue()); return;}
		if(col==a.get(row).size()-1) {a.get(row).set(col, (a.get(row).get(col)).intValue() + a.get(row-1).get(col-1).intValue()); return;}
		
		int l=a.get(row-1).get(col-1), r=a.get(row-1).get(col);
		if(l>r)
			a.get(row).set(col, (a.get(row).get(col)).intValue() + l);
		else
			a.get(row).set(col, (a.get(row).get(col)).intValue() + r);
	}
	static void flattenRow(int row) {
		for(int i=0; i<a.get(row).size(); i++)
			flattenCell(row, i);
	}
	static void findBiggest() {
		int ans=0;
		for(int i=0; i<a.get(a.size()-1).size(); i++) {
			if(a.get(a.size()-1).get(i).intValue()>ans) ans=a.get(a.size()-1).get(i).intValue();
		}
		System.out.println(ans);
	}
}
/*
*/