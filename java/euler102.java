/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class euler102 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> file = new ArrayList<ArrayList<Integer>>();
		String in="";
		try {
			BufferedReader r = new BufferedReader(new FileReader("triangle2.txt"));
			for(int i=0; i<1000; i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				in = r.readLine();
				String str = "";
				for(int x=0, pos=0; pos<6; x++) {
					if(in.charAt(x)==',') {
						temp.add(Integer.parseInt(str));
						pos++;
						str = "";
					}
					else {
						str += Character.toString(in.charAt(x));
					}
				}
				file.add(temp);
			}
			r.close();
		} catch (Exception e1) { e1.printStackTrace(); }
		System.out.println("File input took "+(System.currentTimeMillis()-time)+" ms.\n");
		time = System.currentTimeMillis();
		
		int ans=0;
		Point d = new Point(0,0);
		
		for(int i=0; i<file.size(); i++) {
			ArrayList<Integer> temp = file.get(i);
			Point a = new Point(temp.get(0), temp.get(1));
			Point b = new Point(temp.get(2), temp.get(3));
			Point c = new Point(temp.get(4), temp.get(5));
			if( area(a,b,d) + area(b,c,d) + area(a,c,d) == area(a,b,c) ) ans++;
		}
		System.out.println("Answer: "+ans);	//228
		System.out.println("Calculation took "+(System.currentTimeMillis()-time)+" ms.");
	}
	static double area(Point a, Point b, Point c) {
		return Math.abs((a.x-b.x)*(a.y-c.y)-(a.y-b.y)*(a.x-c.x));
	}
}