/*
 * Andrew Koroluk
 */

import java.util.Random;

public class euler84 {
	static int[] board = new int[40];
	static int samples = 1000000;
	static int sides = 4;
	static int pos = 0;
	static int CCpos = 0;
	static int Chancepos = 0;
	static Random rand = new Random();
	public static void main(String[] args) {		
		for(int i=0; i<samples; i++) {			
			int d1 = rand.nextInt(sides) +1;
			int d2 = rand.nextInt(sides) +1;
			
			pos = (pos + d1 + d2) % 40;
			
            if (pos == 7 || pos == 22 || pos == 36) Chance();
            if (pos == 2 || pos == 17 || pos == 34) CC();
            if (pos == 30) pos = 10;
            
            board[pos]++;
		}
		
		int max1=0, max2=0, max3=0;
		for(int i=0; i<board.length; i++) {
			if(board[i] > board[max1]) max1 = i;
		}
		board[max1]=0;
		for(int i=0; i<board.length; i++) {
			if(board[i] > board[max2]) max2 = i;
		}
		board[max2]=0;
		for(int i=0; i<board.length; i++) {
			if(board[i] > board[max3]) max3 = i;
		}
		board[max3]=0;
		String ans = "";
		
		if(max1<10) ans += "0"+Integer.toString(max1);
		else ans += Integer.toString(max1);
		if(max2<10) ans += "0"+Integer.toString(max2);
		else ans += Integer.toString(max2);
		if(max3<10) ans += "0"+Integer.toString(max3);
		else ans += Integer.toString(max3);
		
		System.out.println(ans);	//101524
	}
	private static void Chance() {
        int[] chance = { 0, 10, 11, 24, 39, 5 };

        Chancepos = ++Chancepos % 16;

        if (Chancepos < 6)
            pos = chance[Chancepos];
        if (Chancepos == 6 || Chancepos == 7) {                
            if (pos == 7) pos = 15;
            if (pos == 22) pos = 25;
            if (pos == 36) pos = 5;                
        }
        if (Chancepos == 8)
        	pos = (pos == 22) ? 28 : 12;  
        if (Chancepos == 9) pos -= 3;
	}
	private static void CC() {
        CCpos = ++CCpos % 16;
        
        if(CCpos == 0) pos = 0;
        if(CCpos == 1) pos = 10;
	}
}