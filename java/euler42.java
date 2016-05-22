/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler42 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		ArrayList<Integer> triangles = new ArrayList<Integer>();
		int ans = 0;
		
		Scanner s = new Scanner(new File("words.txt"));
		while(s.hasNext())
			words.add(s.next());
		System.out.println(words);
		
		for(int i=0; i<words.size(); i++)
			scores.add(Utils.getScore(words.get(i)));
		System.out.println(scores);
		
		for(int i=1; i<100; i++)
			triangles.add( (i*(i+1)/2) );
		
		for(int i=0; i<words.size(); i++) {
			int n = scores.get(i);
			if( triangles.contains(n) )
				ans++;
		}
		System.out.println(ans);
	}
}
/*
The nth term of the sequence of triangle numbers is given by, tn = �n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/