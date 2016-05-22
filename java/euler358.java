/*
 * Andrew Koroluk
 */

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
//import java.util.Scanner;
import java.util.Scanner;

public class euler358 {
	public static void main(String[] args) throws InterruptedException, IOException {
		//m1();
		//m2();
		m3();
	}
	static void m1() {
		System.out.println(isCyclic("43"));
		System.out.println(isCyclic("142857"));
		System.out.println(isCyclic("00000000137328414450556789"));
		String a = "00000000137";
		String c = "56789";
		String d = "";
		for(int i=8; true; i+=9) {
			//System.out.println(i);
			String b = Integer.toString(i);
			//System.out.println(c);
			d = a+b+c;
			if(isCyclic(d)) {
				System.out.println("Hooray! "+b); //3,284,144,505
				//Thread.sleep(10000);
			}
		}
	}
	static boolean isCyclic(String s) {
		String x = s;
		//System.out.println(s);
		//if(new BigInteger(s).mod(new BigInteger("9"))!=BigInteger.ZERO) return false;
		
		for(int i=0; i<s.length(); i++) {
			char c = x.charAt(0);
			x = x.substring(1);
			x = x+c;
			//System.out.println(x);
			BigInteger a = new BigInteger(s);
			BigInteger b = new BigInteger(x);
			if(a.compareTo(b)==1) {
				if(!(	a.divideAndRemainder(b)[1]==BigInteger.ZERO && 
						a.divide(b).compareTo(new BigInteger(Integer.toString(s.length())))<=0))
					return false;
			}
			else {
				if(!(	b.divideAndRemainder(a)[1]==BigInteger.ZERO && 
						b.divide(a).compareTo(new BigInteger(Integer.toString(s.length())))<=0))
					return false;
			}
		}
		
		return true;
	}
	static void m2() {
		int a=0;
		while(true) {
			a++;
			if(!Utils.isPrime(a)) continue;
			BigInteger x = (Utils.pwr(BigInteger.TEN, a-1).subtract(BigInteger.ONE)).divide(new BigInteger(Integer.toString(a)));
			System.out.println(x);
			new Scanner(System.in).nextLine();
		}
	}
	static void m3() throws IOException {
		FileWriter f = new FileWriter("out.txt");
		f.write(BigDecimal.ONE.divide(new BigDecimal(23),10000,0).toString());
		f.close();
	}
}
/*
int a=0;
while(true) {
	if(!Utils.isPrime(a)) continue;
	a++;
	BigInteger x = (Utils.pwr(BigInteger.TEN, a-1).subtract(BigInteger.ONE)).divide(new BigInteger(Integer.toString(a)));
	System.out.println(x);
	new Scanner(System.in).nextLine();
}
*/