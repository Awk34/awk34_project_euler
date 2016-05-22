import java.util.ArrayList;

/*
 * Andrew Koroluk
 */

public class euler32 {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int[] nums = new int[10];
		for(int i=2; i<100; i++)
			for(int j=1; j<10000/i+1; j++) {
				boolean br = false;
				String a1 = Integer.toString(i);
				String b = Integer.toString(j);
				String c = Integer.toString(i*j);
				String d = a1+b+c;
				if(d.length()<9) {j*=10; continue;}
				if(d.length()>9) break;
				for(int x=0; x<9; x++) {
					int y = Integer.parseInt(Character.toString(d.charAt(x)));
					if(y==0) {br=true; break;}
					if(nums[y]==1) {br=true; break;}
					else nums[y]=1;
				}
				nums = new int[10];
				if(br) continue;
				if(!a.contains(i*j)) a.add(i*j);
			}
		int ans = 0;
		for(int i=0; i<a.size(); i++) ans+=a.get(i);
		System.out.println(a);
		System.out.println(ans);
	}
}