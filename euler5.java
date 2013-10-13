//***********************
// Andrew Koroluk       *
// Project Euler - 5    *
//***********************

public class euler5 {
	public static void main(String [] args) {
		int num=1;

		while(num<1000000000) {
			for(int i=2; i<=20; i++) {
				if(num%i==0) {
					continue;
					if(i==20) {
						System.out.println(num);
						return;
					}
				}
				else break;
			}
		}
	}
}

//232792560