/*
 * Andrew Koroluk
 */

import java.util.ArrayList;

public class euler61 {
	static int[][] numbers = new int[6][];
	static int[] ans = new int[6];
	public static void main(String[] args) {		
        for (int i = 0; i < 6; i++)
            numbers[i] = gen(i);
        
        for (int i = 0; i < numbers[5].length; i++) {
            ans[5] = numbers[5][i];
            if (FindNext(5, 1)) break;
        }
        System.out.println(sum(ans));
	}
    private static boolean FindNext(int a, int l) {
    	for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) continue;                
            for (int j = 0; j < numbers[i].length; j++) {

                boolean unique = true;                                                       
                for(int k = 0; k < ans.length; k++){
                    if (numbers[i][j] == ans[k]) {
                        unique = false;
                        break;
                    }                                                
                }
                                        
                if ( unique && ((numbers[i][j] / 100) == (ans[a] % 100))) {                        
                	ans[i] = numbers[i][j];
                    if (l == 5) {
                        if (ans[5] / 100 == ans[i] % 100) return true;
                    }
                    if (FindNext(i, l + 1)) return true;                        
                }                    
            }
            ans[i] = 0;
        }            
        return false;
	}
	private static int sum(int[] a) {
    	int ans = 0;
		for(int i : a)
			ans += i;
		return ans;
	}
	public static int[] gen(int type) {
    	ArrayList<Integer> numbers = new ArrayList<Integer>();

        int n = 0;
        int number = 0;

        while (number < 10000) {
            n++;
            switch(type) {
                case 0:	// Triangle numbers
                	number = n * (n + 1) / 2;
                	break;
                case 1:	// Square numbers                    
                    number = n * n;
                    break;
                case 2:	// Pentagonal numbers                    
                    number = n * (3 * n - 1) / 2;
                    break;
                case 3:	// Hexagonal numbers                    
                    number = n * (2*n - 1);
                    break;
                case 4:	// Heptagonal numbers                    
                    number = n * (5 * n - 3) / 2;
                    break;
                case 5:	// Octagonal numbers                    
                    number = n * (3 * n - 2);
                    break;
            }
            if (number > 999)
                numbers.add(number);
        }
        Object[] a = numbers.toArray();
        int[] ans = new int[a.length];
        for(int i=0; i<a.length; i++)
        	ans[i] = (Integer)a[i];

        return ans;
    }
}