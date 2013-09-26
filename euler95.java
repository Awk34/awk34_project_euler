/*
 * Andrew Koroluk
 */

public class euler95 {
	public static void main(String[] args) {
		int x = 12496;
		int ansLength = 0;
		int limit = 1000000;
		int ans = 12496;
		int[] sumOfFactors = generateFactors(limit);
		
		loop:
		while (x < limit) {
			x++;
			String chain = "";
			int y= sumOfFactors[x];
			chain += x + " -> " + y;
			int length = 1;
			
			while(y != x) {
				if(y>= limit) continue loop;
				y = sumOfFactors[y];
				chain += " -> " + y;
				length += 1;
				
				if(y >= limit) continue loop;
				if(y < 4) continue loop;
				if(length > 50) continue loop;
			}
			
			if(length > ansLength) {
				System.out.println("Length: "+length+
									"\nX: "+x+
									"\n"+chain+"\n");
				ansLength = length;
				ans = x;
			}
		}
		
		System.out.println("Answer: "+ans); //14316
	}
	private static int[] generateFactors(int limit) {
	    int[] sumOfFactors = new int[limit + 1];
	    for (int i = 1; i <= limit / 2; i++) {
	        for (int j = 2 * i; j <= limit; j += i) {
	            sumOfFactors[j] += i;
	        }
	    }
	    return sumOfFactors;
	}
}