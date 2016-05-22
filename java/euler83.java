/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class euler83 {
	public static void main(String[] args) {
		int[][] a = new int[80][80];
		try {
			BufferedReader b = new BufferedReader(new FileReader("matrix.txt"));
			for(int y=0; y<80; y++) {
				String s = b.readLine();
				String str = "";
				int pos = 0;
				for(int x=0; x<s.length(); x++) {
					if(s.charAt(x)==',') {
						a[y][pos] = Integer.parseInt(str);
						str = "";
						pos++;
					}
					else {
						str += s.charAt(x);
					}
				}
				a[y][pos] = Integer.parseInt(str);
			}
			b.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		//Utils.print(a);
		
		ArrayList<Pair[]> openList = new ArrayList<Pair[]>();
		
		/*
		 * Set up searched array
		 * 0: Not Searched
		 * 1: Open List
		 * 2: Closed List
		 */
		int[][] searched = new int[80][80];
		for(int i=0; i<80; i++)
			for(int j=0; j<80; j++)
				searched[i][j] = 0;
		
		//Set up G array
		int[][] g = new int[80][80];
		for(int i=0; i<80; i++)
			for(int j=0; j<80; j++)
				g[i][j] = Integer.MIN_VALUE;
		
		//Set up H array
		int[][] h = new int[80][80];
		for(int j=0; j<80; j++)
			h[79][j] = 80-j;	
		for(int i=78; i>=0; i--)
			for(int j=0; j<80; j++)
				h[i][j] = h[i+1][j]+1;
		
		g[0][0] = a[0][0];
		openList.add(new Pair[] {new Pair(g[0][0]+h[0][0], 0), new Pair(0,0)} );
		
		//while we have not searched the bottom-right square
		while(searched[79][79]<2) {
			/*SORT OPEN LIST*/
			Pair current = openList.get(0)[1];
			openList.remove(0);
			int ci = current.x;
			int cj = current.y;
			searched[ci][cj] = 2;
			
		    //Check the four adjacent squares
		    for (int k = 0; k < 4; k++) {
		        int cinew = 0;
		        int cjnew = 0;
		        switch (k) {
		            case 0: //Check the square above
		                cinew = ci - 1;
		                cjnew = cj;
		                break;
		            case 1: //Check the square below
		                cinew = ci + 1;
		                cjnew = cj;
		                break;
		            case 2: //Check the square right
		                cinew = ci;
		                cjnew = cj+1;
		                break;
		            case 3: //Check the square left
		                cinew = ci;
		                cjnew = cj -1;
		                break;
		        }
		        if (cinew >= 0 && cinew < 80 &&
		            cjnew >= 0 && cjnew < 80 &&
		            searched[cinew][cjnew] < 2) {
		            if (g[cinew][cjnew] > g[ci][cj] + a[cinew][cjnew]) {
		                g[cinew][cjnew] = g[ci][cj] + a[cinew][cjnew];
		 
		                if(searched[cinew][cjnew] == 1){
		                    int index = search(openList, new Pair(cinew, cjnew));
		                    openList.remove(index);
		                }
		                int l = 0;
		                while(containsKey(openList,new Pair(g[cinew][cjnew] + h[cinew][cjnew],l))) l++;
		                openList.add(new Pair[]{new Pair(g[cinew][cjnew] + h[cinew][cjnew],l), new Pair(cinew, cjnew)});
		                searched[cinew][cjnew] = 1;
		            }
		        }
		    }
		}
		System.out.println(g[79][79]);
	}

	private static boolean containsKey(ArrayList<Pair[]> openList, Pair pair) {
		for(Pair[] p: openList)
			if(p[0].equals(pair)) return true;
		return false;
	}

	private static int search(ArrayList<Pair[]> openList, Pair pair) {
		for(int i=0; i<openList.size(); i++) {
			if(openList.get(i)[1].equals(pair)) return i;
		}
		return 0;
	}
}

class Pair {
	public int x;
	public int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Pair() {
		x=0;
		y=0;
	}
}