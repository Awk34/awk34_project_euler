/*
 * Andrew Koroluk
 */

public class euler71 {
	public static void main(String[] args) {
		long n1 = 3;
		long d1 = 7;                        
		long nbest = 0;
		long dbest = 1;
		int limit = 1000000;

        for (int d2 = limit; d2 > 2; d2--) {                
            long n2 = (n1 * d2 - 1) / d1;               
            if (n2 * dbest > nbest * d2) {                    
                //Console.WriteLine("{0}/{1} < {2}/{3} < {4}/{5}", nbest, dbest, n2, d2, n1, d1);                    
                dbest = d2;
                nbest = n2;                  
            }                
        }

        long factor = Utils.gcd(nbest, dbest);
        nbest /= factor;
        dbest /= factor;
        
        System.out.println(nbest);
	}
}