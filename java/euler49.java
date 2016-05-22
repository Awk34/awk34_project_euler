/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler49 {
	public static void main(String[] args) throws Exception {
		for(int i=1000; i<=3339; i++) {
			int a = i, b = i+3330, c = b+3330;
			if(!Utils.isPrime(a) || !Utils.isPrime(b) || !Utils.isPrime(c)) continue;
			if(!sameDigits(a,b) || !sameDigits(a,c)) continue;
			System.out.println(a+""+b+""+c);
		}
	}
	static boolean sameDigits(int a, int b) throws Exception {
		ArrayList<Integer> digits = getDigits(a);
		ArrayList<Integer> digits2 = getDigits(b);
		if(Integer.toString(a).length() != Integer.toString(b).length())
			System.out.println("sameDigits method: Integers a and b are of different digit lengths.");
		
		for(int i=0; i<digits.size(); i++) {
			if(digits2.contains(digits.get(i))) continue;
			else {return false;}
		}
		return true;
	}
	static ArrayList<Integer> getDigits(int x) throws Exception {
		ArrayList<Integer> digits = new ArrayList<Integer>();		
		for(int i=0; i<Integer.toString(x).length(); i++)
			digits.add(Integer.parseInt(Character.toString(Integer.toString(x).charAt(i))));		
		return digits;
	}
}