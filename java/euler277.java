/*
 * Andrew Koroluk
 */

public class euler277 {
	public static void main(String[] args) {
		String sol = "UDDDUdddDDUDDddDdDddDDUDDdUUDd";
		Clock c = new Clock();
		//long limit = (long)Math.pow(10, 15);
		long i = (long)Math.pow(10, 15);
		
		System.out.println(generate(1125977393124310L));
		System.out.println(tryThis(1L));
		
		long q = 335;//353
		
		while(q<=400) {
			System.out.println(generate(q));
			q+=6;
		}
		System.out.println();
		
		
		
		while(true) {
			//System.out.println(i +" "+ tryThis(i));
			if( tryThis(i) ) {
				System.out.println(i);
				break;
			}
			else {
				i++;
			}
			  if(i==Math.pow(10, 15)+1000000) break;
			//if(i==Math.pow(10, 15)+125977393124310L) break;
		}
		
		c.getTimeSeconds();
		System.out.println("done");	//1125977393124310
	}
	
	public static String generate(long num) {
		String ans = "";
		String debug = num+" ";
		String debug2 = num%3+" ";
		String debug3 = num%2+" ";
		
		for(int i=0; i<30; i++) {
			if(num % 3 == 0) {
				ans += "D";
				num /= 3;
				debug2 += " "+0;
				debug3 += " "+num%2;
			}
			else if(num % 3 == 1) {
				ans += "U";
				num = (4*num + 2)/3;
				debug2 += " "+1;
				debug3 += " "+num%2;
			}
			else {
				ans += "d";
				num = (2*num - 1)/3;
				debug2 += " "+2;
				debug3 += " "+num%2;
			}
			debug += " "+num;
			//if(num==1) break;
		}
		
		//System.out.println(debug);
		//System.out.println(debug2);
		//System.out.println(debug3);
		return ans;
	}
	
	public static boolean tryThis(long num) {
		String sol = "UDDDUdddDDUDDddDdDddDDUDDdUUDd";
		String ans = "";
		
		for(int i=0; i<30; i++) {
			while(num % 3 == 0) {
				ans += "D";
				num /= 3;
				i++;
			}
			if(num % 3 == 1) {
				ans += "U";
				num = (4*num + 2)/3;
			}
			else {
				ans += "d";
				num = (2*num - 1)/3;
			}
			if(ans.charAt(i) != sol.charAt(i))
				return false;
		}
		
		return true;
	}
}