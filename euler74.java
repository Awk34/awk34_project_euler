/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler74 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		int limit = 1000000;
		int ans = 0;
		 
		for(int i = 1; i <= limit; i++){
		    int n = i;
		    ArrayList<Integer> seq = new ArrayList<Integer>();
		 
		    while(!seq.contains(n)){
		        seq.add(n);
		        n = factorialSum(n);
		    }
		 
		    if (seq.size() == 60) ans++;
		}
		clock.getTimeSeconds();
		System.out.println(ans);	//402
	}
	static int[] f = {1,1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static int factorialSum(int n){
	    int temp = n;
	    int facsum = 0;
	 
	    while (temp > 0) {
	        facsum += f[temp % 10];
	        temp /= 10;
	    }
	    return facsum;
	}
}