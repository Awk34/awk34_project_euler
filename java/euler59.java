/*
 * Andrew Koroluk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class euler59 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		ArrayList<Integer> file = new ArrayList<Integer>();
		String in="";
		try {
			in = new BufferedReader(new FileReader("cipher1.txt")).readLine();
		} catch (Exception e1) { e1.printStackTrace(); }
		
		
		String s = "";
		for(int index=0; index<in.length(); index++) {
			if(in.charAt(index)==',') {
				file.add(Integer.parseInt(s));
				s="";
				continue;
			}
			s += Character.toString(in.charAt(index));
		}
		file.add(Integer.parseInt(s));
		
		ArrayList<String> crap = new ArrayList<String>();
		for(int i=0; i<file.size(); i++)
			crap.add(num2Binary(file.get(i)));		
		
		int ans = 0;
		String ans2 = "";
		for(int a=97; a<=122; a++) {
			for(int b=97; b<=122; b++) {
				for(int c=97; c<=122; c++) {
					String str = crap2WIN(crap,a,b,c);
					int newAns = countLetters(str);
					if(newAns>ans) {
						ans = newAns;
						ans2 = str;
					}
				}
			}
		}
		System.out.println(Answer(ans2));	//107359
		System.out.println((System.currentTimeMillis() - time) / 1000 + " seconds");
	}
	private static int Answer(String s) {
		int ans = 0;
		for(int i=0; i<s.length(); i++)
			ans += (int)s.charAt(i);
		
		return ans;
	}
	static int countLetters(String s) {
		int ans = 0;
		for(int i=0; i<s.length(); i++) {
			int x = (int)s.charAt(i);
			if( x>=97 && x<=122 ) ans++;
		}
		
		return ans;
	}
	static int binary2Num(String s) {
		int ans=0, var=1;
		for(int i=s.length()-1; i>=0; i--) {
			if(s.charAt(i)=='1') {
				ans += var;
			}
			var*=2;
		}
		return ans;
	}
	static String num2Binary(int num) {
		String binary = "";
		while(num!=0) {
			binary = Integer.toString(num%2).concat(binary);
			num/=2;
		}
		return binary;
	}
	static String XOR(String a, String b) {
		while(a.length()<8)
			a = "0"+a;
		while(b.length()<8)
			b = "0"+b;
		
		String ans = "";
		for(int i=7; i>=0; i--) {
			if(a.charAt(i)==b.charAt(i)) ans = "0"+ans;
			else ans = "1"+ans;
		}
		//for(int i=0; i<a.length()-b.length();)
		return ans;
	}
	static String num2String(int n) {
		return Character.toString((char)n);
	}
	static String crap2WIN(ArrayList<String> crap, int a, int b, int c) {
		String ans="";
		int x=1;
		for(int i=0; i<crap.size(); i++) {
			String pass="";
			if(x==1) 		pass = num2Binary(a);
			else if(x==2) 	pass = num2Binary(b);
			else { 			pass = num2Binary(c); x=0; }
			//System.out.println(crap.get(i)+" XOR "+pass+" = "+XOR( crap.get(i), pass ));
			ans += num2String(binary2Num(XOR( crap.get(i), pass )));
			x++;
		}		
		return ans;		
	}
}