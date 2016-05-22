
/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler105 {
	public static void main(String[] args) {
		System.out.println(read("sets.txt"));
	}
	public static ArrayList<String> read(String in) {
		Scanner s;
		try {
			s = new Scanner(new File(in));
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
}