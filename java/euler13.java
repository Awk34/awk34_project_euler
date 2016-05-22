/*
 * Andrew Koroluk
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class euler13 {
    public static void main(String[] args) {
    	ArrayList<BigInteger> array = read(new File("euler13.txt"));
    	BigInteger sum = BigInteger.ZERO;

    	for(int i=0; i<array.size(); i++)
    		sum = sum.add( array.get(i) );

    	String str = sum.toString();

    	System.out.println(str.substring(0,10));
    }
    public static ArrayList<BigInteger> read(File f) {
		Scanner s;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		ArrayList<BigInteger> ans = new ArrayList<BigInteger>();
		while(s.hasNextLine()) {
			String str = s.next();
			ans.add(new BigInteger(str));
		}
		s.close();
		return ans;
	}
}

/*
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
<euler13.txt>
*/