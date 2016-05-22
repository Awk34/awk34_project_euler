/*
 * Andrew Koroluk
 */

import java.util.Scanner;
import java.io.*;

class Sort {
	void QuickSort(String a[], int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		String mid;

		if (hi0 > lo0) {

			/*
			 * Arbitrarily establishing partition element as the midpoint of the
			 * array.
			 */
			mid = a[(lo0 + hi0) / 2];

			// loop through the array until indices cross
			while (lo <= hi) {
				/*
				 * find the first element that is greater than or equal to the
				 * partition element starting from the left Index.
				 */
				while ((lo < hi0) && (a[lo].compareTo(mid) < 0))
					++lo;

				/*
				 * find an element that is smaller than or equal to the
				 * partition element starting from the right Index.
				 */
				while ((hi > lo0) && (a[hi].compareTo(mid) > 0))
					--hi;

				// if the indexes have not crossed, swap
				if (lo <= hi) {
					String t = a[hi];
					a[hi] = a[lo];
					a[lo] = t;

					++lo;
					--hi;
				}
			}

			/*
			 * If the right index has not reached the left side of array must
			 * now sort the left partition.
			 */
			if (lo0 < hi)
				QuickSort(a, lo0, hi);

			/*
			 * If the left index has not reached the right side of array must
			 * now sort the right partition.
			 */
			if (lo < hi0)
				QuickSort(a, lo, hi0);

		}
	}
}

public class euler22 {
	static void display(String[] a) {
		System.out.print("Data:");
		for (int i = 0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}

	static int StringtoAlphabeticalValue(String str) {
		int ans=0;//A=65

		for(int i=0; i<str.length(); i++) {
			ans += ChartoAlphabeticalValue(str.charAt(i));
		}

		return ans;
	}
	static int ChartoAlphabeticalValue(char c) {
		if(c=='A'||c=='a')
			return 1;
		else if(c=='B'||c=='b')
			return 2;
		else if(c=='C'||c=='c')
			return 3;
		else if(c=='D'||c=='d')
			return 4;
		else if(c=='E'||c=='E')
			return 5;
		else if(c=='F'||c=='f')
			return 6;
		else if(c=='G'||c=='g')
			return 7;
		else if(c=='H'||c=='h')
			return 8;
		else if(c=='I'||c=='i')
			return 9;
		else if(c=='J'||c=='j')
			return 10;
		else if(c=='K'||c=='k')
			return 11;
		else if(c=='L'||c=='l')
			return 12;
		else if(c=='M'||c=='m')
			return 13;
		else if(c=='N'||c=='n')
			return 14;
		else if(c=='O'||c=='o')
			return 15;
		else if(c=='P'||c=='p')
			return 16;
		else if(c=='Q'||c=='q')
			return 17;
		else if(c=='R'||c=='r')
			return 18;
		else if(c=='S'||c=='s')
			return 19;
		else if(c=='T'||c=='t')
			return 20;
		else if(c=='U'||c=='u')
			return 21;
		else if(c=='V'||c=='v')
			return 22;
		else if(c=='W'||c=='w')
			return 23;
		else if(c=='X'||c=='x')
			return 24;
		else if(c=='Y'||c=='y')
			return 25;
		else if(c=='Z'||c=='z')
			return 26;
		else
			return 0;
	}

	public static void main(String[] thor) throws Exception {
		long time = System.currentTimeMillis();
		Scanner s = new Scanner(new File("names.txt"));
		String names = s.nextLine();

		String[] a = new String[5163];

		int numnames=0;
		for(int i=1; i<46447; i++) {
			a[numnames]="";
			while(names.charAt(i)!='"') {
				a[numnames]+=names.charAt(i);
				i++;
			}
			numnames++;
			i+=2;
		}

		//display(a);

		Sort sorter = new Sort();
		sorter.QuickSort(a,0,5162);
		//display(a);

		long answer = 0;

		for(int i=0; i<5163; i++) {
			answer+= StringtoAlphabeticalValue(a[i])*(i+1);
		}
		System.out.println(answer);
		time = System.currentTimeMillis()-time;
		System.out.println("Time taken: "+time*.001+" seconds");
	}
}

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938	53 = 49714.

What is the total of all the name scores in the file?
*/
/*
class ShellSort {
	public static void main(String[] args) {
		int maxSize = 10;
		ShellSort arr = new ShellSort(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
		arr.shellSort();
		arr.display();
	}
}
*/