/*
 * Andrew Koroluk
 */

import java.util.Random;

public class euler205 {
	public static void main(String[] args) {
		Clock clock = new Clock();
		double ans = 0;		
		Random rand = new Random();
		int trials = 1000000000;
		int win=0;
		
		for(int i=1; i<=trials; i++) {
			int peter=0, colin=0;
			for(int p=1; p<=9; p++)
				peter += rand.nextInt(4)+1;
			for(int c=1; c<=6; c++)
				colin += rand.nextInt(6)+1;
			if(peter>colin) win++;
		}
		
		ans = (double)win/trials;
		clock.getTimeSeconds();
		System.out.println(ans);	//0.5731441
	} 
}