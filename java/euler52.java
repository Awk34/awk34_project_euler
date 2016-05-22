/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler52 {
	public static void main(String[] args) throws Exception {
		System.out.println(getDigits(1234567890));
		int x=100000;
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while(true) {
			x++;
			digits = getDigits(x);
			boolean cool=true;
			for(int y=2; y<=6; y++) {
				int num = y*x;
				ArrayList<Integer> digits2 = getDigits(num);
				for(int i=0; i<digits.size(); i++) {
					if(digits2.contains(digits.get(i))) continue;
					else {cool=false; break;}
				}
				if(!cool) break;
			}
			if(!cool) continue;
			else { System.out.println(x); break; }			
		}
	}
	static ArrayList<Integer> getDigits(int x) throws Exception {
		ArrayList<Integer> digits = new ArrayList<Integer>();		
		for(int i=0; i<Integer.toString(x).length(); i++)
			digits.add(Integer.parseInt(Character.toString(Integer.toString(x).charAt(i))));		
		return digits;
	}
}
/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/