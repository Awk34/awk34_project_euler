/*
 * Andrew Koroluk
 */

public class euler39 {
	public static void main(String[] args) {
		long result = 0, resultSolutions = 0;
		 
		for (long p = 2; p <= 1000; p += 2) {
		    int numberOfSolutions = 0;
		    for (long a = 2; a < (p/3); a++) {
		          if(p*(p-2*a) % (2*(p-a)) == 0){
		              numberOfSolutions++;
		          }
		      }
		      if(numberOfSolutions > resultSolutions){
		        resultSolutions = numberOfSolutions;
		        result = p;
		    }
		}
		System.out.println(result);
	}
	static boolean pythagorean(int a, int b, int c) {
		a*=a;
		b*=b;
		c*=c;
		if((a+b)==c) return true;
		else return false;
	}
}
/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p <= 1000, is the number of solutions maximised?
*/