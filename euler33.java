/*
 * Andrew Koroluk
 */

public class euler33 {
	public static void main(String[] args) {
		for(int n=10; n<100; n++) {
			for(int m=10; m<100; m++) {
				char a = Integer.toString(n).charAt(0);
				char b = Integer.toString(n).charAt(1);
				char c = Integer.toString(m).charAt(0);
				char d = Integer.toString(m).charAt(1);
				if(b=='0' && d=='0') continue;
				if(n>=m) continue;
				if(a==c) {
					if(b=='0' || d=='0') continue;
					if((float)n/(float)m==(float)f(b)/(float)f(d)) {
						System.out.println(n+" "+m);
						System.out.println(a+""+b+"/"+c+""+d+" = "+b+"/"+d);
					}
				}
				if(b==d) {
					if(a=='0' || c=='0') continue;
					if((float)n/(float)m==(float)f(a)/(float)f(c)) {
						System.out.println(n+" "+m);
						System.out.println(a+""+b+"/"+c+""+d+" = "+a+"/"+c);
					}
				}
				if(b==c) {
					if(a=='0' || d=='0') continue;
					if((float)n/(float)m==(float)f(a)/(float)f(d)) {
						System.out.println(n+" "+m);
						System.out.println(a+""+b+"/"+c+""+d+" = "+a+"/"+d);
					}
				}
			}
		}
	}
	static int f(char a) {	//char to int
		return Integer.parseInt(Character.toString(a));
	}
}