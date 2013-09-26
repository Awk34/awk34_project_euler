/*
 * Andrew Koroluk
 */

public class euler104 {
	public static void main(String[] args) {
		long f1 = 1;
		long f2 = 1;
		int k = 2;
		
		while(k<=2749) {
			long newF = (f1 + f2) % 1000000000;
			f1 = f2;
			f2 = newF;
			k++;
		}
		
		loop:
		while (true) {
			long newF = (f1 + f2) % 1000000000;
			f1 = f2;
			f2 = newF;
			k++;
			
			if(isPandigital(newF)) {
				System.out.println(k);
				double t = (k * 0.20898764024997873 - 0.3494850021680094);
		        if (isPandigital((long)Math.pow(10, t - (long)t + 8)))
		            break loop;
			}
		}
		
		System.out.println("Answer: " + k);	//329468
	}
	private static boolean goFish(String s) {
		String p1 = "";
		String p2 = "";
		
		p1 = s.substring(0, 9);
		p2 = s.substring(s.length()-9);
		
		if(isPandigital( Integer.parseInt(p1)) && isPandigital( Integer.parseInt(p2))) return true;
		else return false;
	}
	private static boolean isPandigital(int i) {
		String s = Integer.toString(i);
		for(int x=1; x<=s.length(); x++) {
			if(!s.contains(Integer.toString(x))) {
				return false;
			}
		}
		
		return true;
	}
	private static boolean isPandigital(long i) {
		String s = Long.toString(i);
		for(int x=1; x<=s.length(); x++) {
			if(!s.contains(Integer.toString(x))) {
				return false;
			}
		}
		
		return true;
	}
}