/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class euler79 {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("keylog.txt"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        a.add(str);
		    }
		    in.close();
		} catch (Exception e) {System.out.println("File not found");}
		
		try{for(int i=0; i<a.size(); i++)
			for(int j=0; j<a.size() && j!=i; j++)
				if(a.get(i).equals(a.get(j))) a.remove(j);
		} catch(Exception e) {}
		
		for(int i=0; i<a.size(); i++)
			System.out.println(a.get(i));
	}
}