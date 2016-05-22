/*
 * Andrew Koroluk
 */

public class euler145 {
	public static void main(String[] args) {
		int sum=0;
				 
		for(int i=1; i<10; i++) {
			if(i%4==1)
				continue;
			else if(i%2==0)
				sum +=  20*( Utils.pwr(30, (i/2)-1) );
			else if(i%4==3)
				sum += 100*( Utils.pwr(500, i/4) );
		}
		 
		System.out.println(sum);	//608720
	}
}