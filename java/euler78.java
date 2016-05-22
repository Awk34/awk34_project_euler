/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler78 {
	
    public static void main(String[] args) {
    	ArrayList<Integer> p = new ArrayList<Integer>();
    	//List<Integer> p = new List<Integer>();
    	p.add(1);
    	 
    	int n = 1;
    	while(true) {
    	    int i = 0;
    	    int penta = 1;
    	    p.add(0);
    	 
    	    while (penta <= n){
    	        int sign = (i % 4 > 1) ? -1 : 1;
    	        p.set(n, p.get(n) + sign * p.get(n - penta));
    	        p.set(n, p.get(n) % 1000000);
    	        i++;
    	 
    	        int j = (i % 2 == 0) ? i / 2 + 1 : -(i / 2 + 1);
    	        penta = j * (3 * j - 1) / 2;
    	    } 
    	 
    	    if (p.get(n) == 0) break;
    	    n++;
    	}
    	System.out.println(n);	//55374
    }
}