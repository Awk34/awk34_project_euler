/*
 * Andrew Koroluk
 */

public class euler86 {
	public static void main(String[] args) {
		int l=2, i=0;
		
		while(i<1000000) {
			l++;
			for(int wh=3; wh<2*l; wh++) {	//wh = w+h
				double sqrt = Math.sqrt(l*l + wh*wh);
				if(sqrt==(int)sqrt) 
					i += (wh<l) ? wh/2 : 1+(l - (wh+1)/2);
			}
		}
		System.out.println(l);	//1818
	}
}