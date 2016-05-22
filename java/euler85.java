/*
 * Andrew Koroluk
 */

public class euler85 {
	public static void main(String[] args) {
		
		int min_x=0,min_y=0,min=2000000;
		
		for(int x=1; x<=100; x++) {
			for(int y=1; y<=100; y++) {
				int rect = (x*x+x) * (y*y+y) / 4;
			    int diff = Math.abs(2000000-rect);
			    if (diff<min) {
			    	min_x = x;
			    	min_y = y;
			    	min=diff;
			    }
			}
		}
		System.out.println(min_x*min_y);
	}
}