import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * Andrew Koroluk
 */



public class euler89 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> roman = new ArrayList<String>();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("roman.txt"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        roman.add(str);
		    }
		    in.close();
		} catch (Exception e) {System.out.println("File not found");}
		//System.out.println(roman);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0; i<roman.size(); i++) {
			nums.add(roman2int(roman.get(i)));
		}
		//System.out.println(nums);
		
		ArrayList<String> roman2 = new ArrayList<String>();
		for(int i=0; i<nums.size(); i++) {
			roman2.add(int2roman(nums.get(i)));
		}
		//System.out.println(roman2);
		
		System.out.println("You saved "+compareLists(roman, roman2)+" characters."); //743
	}
	public static int roman2int(String str) {
		int ans = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c=='M') ans+=1000;
			if(c=='D') ans+=500;
			if(c=='C') {
				try{if(str.charAt(i+1)=='D') {ans+=400; i++; continue;}} catch(Exception e){}
				try{if(str.charAt(i+1)=='M') {ans+=900; i++; continue;}} catch(Exception e){}
				ans+=100;
			}
			if(c=='L') ans+=50;
			if(c=='X') {
				try{if(str.charAt(i+1)=='L') {ans+=40; i++; continue;}} catch(Exception e){}
				try{if(str.charAt(i+1)=='C') {ans+=90; i++; continue;}} catch(Exception e){}
				ans+=10;
			}
			if(c=='V') ans+=5;
			if(c=='I') {
				try{if(str.charAt(i+1)=='V') {ans+=4; i++; continue;}} catch(Exception e){}
				try{if(str.charAt(i+1)=='X') {ans+=9; i++; continue;}} catch(Exception e){}
				ans+=1;
			}
		}
		return ans;
	}
	public static String int2roman(int x) {
		String ans = "";
		while (x>0) {
			if(x>1000) {ans+="M"; x-=1000;}
			else if(x>=900) {ans+="CM"; x-=900;}
			else if(x>=500) {ans+="D"; x-=500;}
			else if(x>=400) {ans+="CD"; x-=400;}
			else if(x>=100) {ans+="C"; x-=100;}
			else if(x>=90) {ans+="XC"; x-=90;}
			else if(x>=50) {ans+="L"; x-=50;}
			else if(x>=40) {ans+="XL"; x-=40;}
			else if(x>=10) {ans+="X"; x-=10;}
			else if(x>=9) {ans+="IX"; x-=9;}
			else if(x>=5) {ans+="V"; x-=5;}
			else if(x>=4) {ans+="IV"; x-=4;}
			else if(x>=1) {ans+="I"; x-=1;}
		}
		
		return ans;
	}
	public static int compareLists(ArrayList<String> a, ArrayList<String> b) {
		if(a.size()!=b.size()) {System.out.println("Arrays are of different size."); return 0;}
		
		int ans = 0;
		for(int i=0; i<a.size(); i++) {
			ans+= a.get(i).length() - b.get(i).length();
		}
		
		return ans;
	}
}