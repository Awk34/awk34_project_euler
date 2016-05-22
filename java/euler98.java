/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class euler98 {
	public static void main(String[] args) {
		ArrayList<String> a = read(new File("words.txt"));
		ArrayList<String[]> c = new ArrayList<String[]>();
		
		System.out.println(a);
		
		c = getDoubles(a);
		
		for(int i=0; i<c.size(); i++) Utils.print(c.get(i));
		
		//ArrayList<Integer> squares = makeSquares(999999999);
		
		/*for(int i=0; i<c.size(); i++) {
			int size = c.get(i).length;
		}*/
		
		System.out.println(superSort("CARE","RACE", 1296)+"\n9216");
		
		Utils.print(intToArray(123));	//18769
	}
	public static ArrayList<String> read(File f) {
		Scanner s;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); return null;
		}
		
		ArrayList<String> ans = new ArrayList<String>();
		while(s.hasNextLine()) {
			String str = s.next();
			ans.add(str);
		}
		s.close();
		return ans;
	}
	public static String sort(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		
		return toString(c);
	}
	public static String toString(char[] c) {
		String s = "";
		for(int i=0; i<c.length; i++)
			s += c[i];
		
		return s;
	}
	public static ArrayList<String[]> getDoubles(ArrayList<String> a) {
		ArrayList<String[]> b = new ArrayList<String[]>();
		ArrayList<String[]> c = new ArrayList<String[]>();
		
		for(int i=0; i<a.size(); i++) {
			String[] temp = new String[3];
			String s = a.get(i);
			s = sort(s);
			temp[0] = s;
			if(b.contains(temp)) continue;
			else {
				temp[1] = a.get(i);
				b.add(temp);
			}
		}
		//for(int i=0; i<b.size(); i++)
			//Utils.print(b.get(i));
		for(int i=0; i<b.size(); i++) {
			for(int j=0; j<b.size(); j++) {
				if(i==j) continue;
				if(b.get(i)[0] .equals( b.get(j)[0] )) {
					//System.out.println( i + " - " + j );
					String[] temp = new String[3];
					temp[0] = b.get(i)[0];
					temp[1] = b.get(i)[1];
					temp[2] = b.get(j)[1];
					c.add(temp);
					b.remove(i);
					b.remove(j);
					//Utils.print(temp);
				}
			}
		}
		return c;
	}
	public static ArrayList<Integer> makeSquares(int limit) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i=0; i<=limit; i++) {
			double temp = Math.sqrt(i);
			if( temp == (double)(int)temp ) ans.add(i);
		}
		
		return ans;
		//this can be improved but im lazy
		//input i*i to sqrt(limit)
	}
	public static int superSort(String a, String b, int i) {
		Object[][] oa = new Object[a.length()][2];
		int[] ia = intToArray(i);
		
		return 0;
	}
	public static int[] intToArray(int num) {
		if (num<0) num=-num;
		num = Utils.reverse(num);
		int[] digits = new int[Integer.toString(num).length()];

		int i=0;
		while (num>0) {
		    digits[i] = num%10;
		    num=num/10;
		    i++;
		}
		
		return digits;
	}
}