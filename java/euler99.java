/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler99 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<int[]> array = new ArrayList<int[]>();
		Scanner s = new Scanner(new File("base_exp.txt"));
		while(s.hasNextLine()) {
			String str = s.nextLine();
			int i=0;
			while(true) {
				if(str.charAt(i) == ',') break;
				i++;
			}
			int[] t = new int[2];
			t[0] = Integer.parseInt(str.substring(0,i));
			t[1] = Integer.parseInt(str.substring(i+1,str.length()));
			array.add(t);
		}
		
		int mv=0, ml=0;
		for(int i=0; i<array.size(); i++) {
			int[] aline = array.get(i);
			int val = (int)(aline[1] * Math.log(aline[0]));
			if(val > mv) {
				mv = val;
				ml = i+1;
			}
		}
		
		System.out.println(ml);	//709
	}
}