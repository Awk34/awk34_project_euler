/*
 * Andrew Koroluk
 * Java Utilities
 * http://www.network-science.de/ascii/		font: big
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Utils {
	/**********************************************************************
	 *    _____   _                                   _    _              *
	 *   |  __ \ (_)                                 | |  (_)             *
	 *   | |  | | _   __ _   __ _  _ __    ___   ___ | |_  _   ___  ___   *
	 *   | |  | || | / _` | / _` || '_ \  / _ \ / __|| __|| | / __|/ __|  *
	 *   | |__| || || (_| || (_| || | | || (_) |\__ \| |_ | || (__ \__ \  *
	 *   |_____/ |_| \__,_| \__, ||_| |_| \___/ |___/ \__||_| \___||___/  *
	 *                       __/ |                                        *
	 *                      |___/                                         *
	 **********************************************************************/
	private static boolean diag=false;
	static void diagON() { diag=true; }
	static void diagOFF() { diag=false; }
	static boolean diag() { return diag; }
	/**********************************************************************
	 *                                       _______             _        *
	 *      /\                              |__   __|           | |       *
	 *     /  \    _ __  _ __  __ _  _   _     | |  ___    ___  | | ___   *
	 *    / /\ \  | '__|| '__|/ _` || | | |    | | / _ \  / _ \ | |/ __|  *
	 *   / ____ \ | |   | |  | (_| || |_| |    | || (_) || (_) || |\__ \  *
	 *  /_/    \_\|_|   |_|   \__,_| \__, |    |_| \___/  \___/ |_||___/  *
	 *                                __/ |                               *
     *                               |___/                                *
	 **********************************************************************/
	void randomize(int[] a, int max) {
		for(int i=0; i<a.length; i++) {
			a[i] = new Random().nextInt(max)+1;
			while(duplicates(a, a[i], i)) {
				a[i] = new Random().nextInt(max)+1;
			}
		}
	}
	static boolean duplicates(int[] a, int num, int j) {
		for(int i=0; i<j; i++) {
			if(a[i]==num) {
				System.out.println("-----duplicates found-----");print(a);System.out.println("--------------------------");
				return true;
			}
		}
		return false;
	}
	static void duplicates1(ArrayList<Integer> a) {
		int size = a.size();
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(i==j) continue;
				if(a.get(i)==a.get(j)) {
					System.out.println("Duplicate of "+a.get(i)+" found at i="+i+" & j="+j);
				}
			}
		}
	}
	static boolean duplicates(ArrayList<Long> a) {
		for(int x=0; x<a.size(); x++) {
			for(int i=0; i<a.size() && x!=i ; i++) {
				if(a.get(i)==a.get(x)) {
					System.out.println("Duplicate of "+a.get(i)+" found.");
					return true;
				}
			}
		}
		return false;
	}
	@SuppressWarnings("all")
	public static void removeDuplicates(ArrayList a) {
		HashSet h = new HashSet(a);
		a.clear();
		a.addAll(h);
	}
	@SuppressWarnings("all")
	public static void removeDuplicatesWithOrder(ArrayList arlList) {
	   Set set = new HashSet();
	   ArrayList newList = new ArrayList();
	   for (Iterator iter = arlList.iterator(); iter.hasNext();) {
	      Object element = iter.next();
	      if (set.add(element))
	         newList.add(element);
	   }
	   arlList.clear();
	   arlList.addAll(newList);
	}
	static void print(int[] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			if(i==a.length-1) {System.out.print(a[i]);continue;}
			System.out.print(a[i]+", ");
		}
		System.out.print(" ]\n");
	}
	static void print(Object[] object) {
		System.out.print("[ ");
		for(int i=0; i<object.length; i++) {
			if(i==object.length-1) {System.out.print(object[i]);continue;}
			System.out.print(object[i]+", ");
		}
		System.out.print(" ]\n");
	}
	static void print(char[] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			if(i==a.length-1) {System.out.print(a[i]);continue;}
			System.out.print(a[i]+", ");
		}
		System.out.print(" ]\n");
	}
	static void print(byte[] bs) {
		System.out.print("[ ");
		for(int i=0; i<bs.length; i++) {
			if(i==bs.length-1) {System.out.print(bs[i]);continue;}
			System.out.print(bs[i]+", ");
		}
		System.out.print(" ]\n");
	}
	static void print(long[] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			if(i==a.length-1) {System.out.print(a[i]);continue;}
			System.out.print(a[i]+", ");
		}
		System.out.print(" ]\n");
	}
	/* Prints out an array's cells, separated by spaces */
	static void display(String[] a) {
		for (int i = 0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}
	static void display(int[] a) {
		for (int i = 0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println("");
	}
	public static void print(int[][] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			print(a[i]);
			
			//if(i==a.length-1) {System.out.print(a[i]);continue;}
			//System.out.print(a[i]+", ");
		}
		System.out.print(" ]\n");
	}
	public static BigInteger sum(ArrayList<Long> a) {
		BigInteger ans = BigInteger.ZERO;
		
		for(int i=0; i<a.size(); i++)
			ans = ans.add( new BigInteger(Long.toString(a.get(i))) );
		
		return ans;
	}
	/*********************************************
	 *   _            _    _                     *
	 *  | |          | |  | |                    *
	 *  | |      ___ | |_ | |_  ___  _ __  ___   *
	 *  | |     / _ \| __|| __|/ _ \| '__|/ __|  *
	 *  | |____|  __/| |_ | |_|  __/| |   \__ \  *
	 *  |______|\___| \__| \__|\___||_|   |___/  *
	 *********************************************
	/* Converts all Characters in the String to their Alphabetical Position, and adds them */
	static int StringtoAlphabeticalValue(String str) {
		int ans=0;
		for(int i=0; i<str.length(); i++) {
			ans += ChartoAlphabeticalValue(str.charAt(i));
		}
		return ans;
	}
	/* Converts a Character to its Alphabetical Position (or returns 0) */
	static int ChartoAlphabeticalValue(char c) {
		if(c=='A'||c=='a') return 1;
		else if(c=='B'||c=='b') return 2;
		else if(c=='C'||c=='c') return 3;
		else if(c=='D'||c=='d') return 4;
		else if(c=='E'||c=='E') return 5;
		else if(c=='F'||c=='f') return 6;
		else if(c=='G'||c=='g') return 7;
		else if(c=='H'||c=='h') return 8;
		else if(c=='I'||c=='i') return 9;
		else if(c=='J'||c=='j') return 10;
		else if(c=='K'||c=='k') return 11;
		else if(c=='L'||c=='l') return 12;
		else if(c=='M'||c=='m') return 13;
		else if(c=='N'||c=='n') return 14;
		else if(c=='O'||c=='o') return 15;
		else if(c=='P'||c=='p') return 16;
		else if(c=='Q'||c=='q') return 17;
		else if(c=='R'||c=='r') return 18;
		else if(c=='S'||c=='s') return 19;
		else if(c=='T'||c=='t') return 20;
		else if(c=='U'||c=='u') return 21;
		else if(c=='V'||c=='v') return 22;
		else if(c=='W'||c=='w') return 23;
		else if(c=='X'||c=='x') return 24;
		else if(c=='Y'||c=='y') return 25;
		else if(c=='Z'||c=='z') return 26;
		else return 0;
	}
	static int getScore(char c) {
		if(!Character.isLetter(c)) return 0;
		else {
			Character.toUpperCase(c);
			return (int)c-64;
		}
	}
	static int getScore(String s) {
		int ans = 0;
		for(int i=0; i<s.length(); i++)
			ans+= getScore(s.charAt(i));
		return ans;
			
	}
	/*************************************************
	 *    _____               _    _                 *
	 *   / ____|             | |  (_)                *
	 *  | (___    ___   _ __ | |_  _  _ __    __ _   *
	 *   \___ \  / _ \ | '__|| __|| || '_ \  / _` |  *
	 *   ____) || (_) || |   | |_ | || | | || (_| |  *
	 *  |_____/  \___/ |_|    \__||_||_| |_| \__, |  *
	 *                                        __/ |  *
	 *                                       |___/   *
	 *************************************************/
	static int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		};
		return i;
	}
	/* quickSort (int[]) */
	static void quickSort(int[] a) {
		quickSort(a, 0, a.length);
	}
	static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1) quickSort(arr, left, index - 1);
		if (index < right) quickSort(arr, index, right);
	}
	
	
	static int partition(char[] c, int left, int right) {
		int i = left, j = right;
		char tmp;
		int pivot = c[(left + right) / 2];
		while (i <= j) {
			while (c[i] < pivot) i++;
			while (c[j] > pivot) j--;
			if (i <= j) {
				tmp = c[i];
				c[i] = c[j];
				c[j] = tmp;
				i++;
				j--;
			}
		};
		return i;
	}
	static void quickSort(char[] c) {
		quickSort(c, 0, c.length);
	}
	static void quickSort(char[] c, int left, int right) {
		int index = partition(c, left, right);
		if (left < index - 1) quickSort(c, left, index - 1);
		if (index < right) quickSort(c, index, right);
	}
	/* Quicksort (String[]) */
	void quickSort(String[] a) {
		quickSort(a, 0, a.length);
	}
	void quickSort(String[] a, int lo0, int hi0) {
		int lo = lo0;
		int hi = hi0;
		String mid;

		if (hi0 > lo0) {
			mid = a[(lo0 + hi0) / 2];
			while (lo <= hi) {
				while ((lo < hi0) && (a[lo].compareTo(mid) < 0)) ++lo;
				while ((hi > lo0) && (a[hi].compareTo(mid) > 0)) --hi;
				if (lo <= hi) {
					String t = a[hi];
					a[hi] = a[lo];
					a[lo] = t;

					++lo;
					--hi;
				}
			}
			if (lo0 < hi) quickSort(a, lo0, hi);
			if (lo < hi0) quickSort(a, lo, hi0);
		}
	}
	void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	boolean sorted(int[] a) {
		for(int i=0; i<a.length-1; i++) {
			if(a[i]>a[i+1])
				return false;
		}
		return true;
	}
	/*******************************************************
	 *  _____                         _  _                 *
	 * |  __ \                       | || /        /\      *
	 * | |__) |__ _  ___   ___  __ _ | ||/___     /  \     *
	 * |  ___// _` |/ __| / __|/ _` || | / __|   /    \    *
	 * | |   | (_| |\__ \| (__| (_| || | \__ \  /      \   *
	 * |_|    \__,_||___/ \___|\__,_||_| |___/ /________\  *
	 *                                                     *
	 *******************************************************/
	/* Pascal's Triangle Number (n Choose r) (int) */
	static int nCr(int n, int r) {
		return factorial(n) / (factorial(r)*factorial(n-r));
	}
	/* Factorial (int) */
	static int factorial(int a) {
		int ans=1;
		for(int i=a; i>0; i--)
			ans*=i;
		return ans;
	}
	/* Pascal's Triangle Number (n Choose r) (long) */
	long nCr(long n, long r) {
		return factorial(n) / (factorial(r)*factorial(n-r));
	}
	/* Factorial (long) */
	long factorial(long a) {
		long ans=1;
		for(long i=a; i>0; i--)
			ans*=i;
		return ans;
	}
	/* Pascal's Triangle Number (n Choose r) (BigInteger) */
	static BigInteger nCr(BigInteger n, BigInteger r) {
		return factorial(n).divide((factorial(r).multiply(factorial(n.subtract(r)))));
	}
	/* Factorial (BigInteger) */
	static BigInteger factorial(BigInteger a) {
		BigInteger ans=new BigInteger("1");
		for(BigInteger i=a; i.compareTo(new BigInteger("0"))==1; i=i.subtract(new BigInteger("1")))
			ans=ans.multiply(i);
		return ans;
	}
	/******************************************************************
	 *   ____   _         _____         _                             *
	 *  |  _ \ (_)       |_   _|       | |                            *
	 *  | |_) | _   __ _   | |   _ __  | |_  ___   __ _   ___  _ __   *
	 *  |  _ < | | / _` |  | |  | '_ \ | __|/ _ \ / _` | / _ \| '__|  *
	 *  | |_) || || (_| | _| |_ | | | || |_|  __/| (_| ||  __/| |     *
	 *  |____/ |_| \__, ||_____||_| |_| \__|\___| \__, | \___||_|     *
	 *              __/ |                          __/ |              *
     *             |___/                          |___/               *
	 ******************************************************************/
	static BigInteger pwr(BigInteger a, int pwr) {
		BigInteger ans=new BigInteger("1");
		for(int i=pwr; i>0; i--) {
			ans=ans.multiply(a);
			if(diag) {System.out.println(ans +" * "+ a); new Scanner(System.in).nextLine();}
		}
		return ans;
	}
	static BigInteger IntToBig(int a) {
		return new BigInteger(Integer.toString(a));
	}
	BigInteger pwr97(BigInteger a, int pwr) {
		BigInteger ans=new BigInteger("1");
		for(int i=pwr; i>0; i--) {
			ans=ans.multiply(a);
			ans = ans.mod(new BigInteger("10"));
			if(diag) {System.out.println(ans +" * "+ a); new Scanner(System.in).nextLine();}
		}
		return ans;
	}
	/**************************************************
	 *   _____   _         _                          *
	 *  |  __ \ (_)       (_)                         *
	 *  | |  | | _ __   __ _  ___   ___   _ __  ___   *
	 *  | |  | || |\ \ / /| |/ __| / _ \ | '__|/ __|  *
	 *  | |__| || | \ V / | |\__ \| (_) || |   \__ \  *
	 *  |_____/ |_|  \_/  |_||___/ \___/ |_|   |___/  *
	 **************************************************/
	int sumOfDivisors(int a) {
		int ans=0;
		for(int i=1; i<a; i++)
			if(a%i==0)
				ans+=i;
		return ans;
	}
	short sumOfDivisors(short a) {
		short ans=0;
		for(short i=1; i<a; i++)
			if(a%i==0)
				ans+=i;
		return ans;
	}
	static ArrayList<Integer> divisors(int a) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=1; i<a; i++)
			if(a%i==0)
				array.add(i);
		return array;
	}
	/*************************************************************************
	 *   _____        _  _             _                                     *
	 *  |  __ \      | |(_)           | |                                    *
	 *  | |__) |__ _ | | _  _ __    __| | _ __  ___   _ __ ___    ___  ___   *
	 *  |  ___// _` || || || '_ \  / _` || '__|/ _ \ | '_ ` _ \  / _ \/ __|  *
	 *  | |   | (_| || || || | | || (_| || |  | (_) || | | | | ||  __/\__ \  *
	 *  |_|    \__,_||_||_||_| |_| \__,_||_|   \___/ |_| |_| |_| \___||___/  *
	 *************************************************************************/
	static boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		return isPalindrome(str);
	}
	static boolean isPalindrome(long x) {
		String str = Long.toString(x);
		return isPalindrome(str);
	}
	static boolean isPalindrome(BigInteger x) {
		String str = x.toString();
		for(int i=0,j=str.length()-1; i<str.length()/2; i++,j--) {
			if(str.charAt(i)==str.charAt(j))
				continue;
			else return false;
		}
		return true;
	}
	static boolean isPalindrome(String str) {
		for(int i=0,j=str.length()-1; i<str.length()/2; i++,j--) {
			if(str.charAt(i)==str.charAt(j))
				continue;
			else return false;
		}
		return true;
	}
	static int reverse(int n) {
		int rev=0;
		if(diag) System.out.println("Original: "+n+" + Reverse: "+rev);
		while (n > 0) {
			rev *= 10;		// shift rev digits left
			rev += n % 10;	// put rightmost digit of n onto right of rev
			n /= 10;		// remove rightmost digit of n
			if(diag) System.out.println("n="+n+" + rev="+rev);
		}
		return rev;
	}
	static boolean Lychrel(int x) {
		for(int i=0; i<50; i++) {
			x += reverse(x);
			if(isPalindrome(x))
				return false;
		}
		return true;
	}
	/***********************
	 *  __  __ _           *
	 * |  \/  (_)          *
	 * | \  / |_ ___  ___  *
	 * | |\/| | / __|/ __| *
	 * | |  | | \__ \ (__  *
	 * |_|  |_|_|___/\___| *
	 ***********************/
	static boolean isPrime(int n) {
		if(n==1) return false;
		boolean prime = true;
		int limit = (int) Math.sqrt(n);
		for (int i=2; i<=limit; i++) {
			if (n%i==0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
	public static boolean isPrime(long n) {
		if(n==1) return false;
		boolean prime = true;
		long limit = (long) Math.sqrt(n);
		for (long i=2; i<=limit; i++) {
			if (n%i==0) {
				prime = false;
				break;
			}
		}
		return prime;
	}
	static boolean isPrime(BigInteger n) {
		if(n.compareTo(BigInteger.ONE)==1) return false;
		boolean prime = true;
		BigInteger limit = Utils.sqrt(n,false);
		for (BigInteger i=new BigInteger("2"); i.compareTo(limit)==-1; i=i.add(BigInteger.ONE)) {
			if(n.mod(i).compareTo(BigInteger.ZERO)==0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

	public static int pwr(int a, int b) {
		int ans = 1;
		for(int i=b; i>0; i--) {
			ans*=a;
			if(diag) {System.out.println(ans +" * "+ a); new Scanner(System.in).nextLine();}
		}
		return ans;
	}
	public static long pwr(long a, long b) {
		long ans = 1;
		for(long i=b; i>0; i--) {
			ans*=a;
			if(diag) {System.out.println(ans +" * "+ a); new Scanner(System.in).nextLine();}
		}
		return ans;
	}

	public static int numAt(int a, int b) throws Exception {
		//b--;
		try {
			if(a<10 && a>-10)
				return a;
			b=pwr(10, String.valueOf(a).trim().length()-b+1); if(diag) System.out.println("b=pwr(10, b); --> "+b);
			/*if(b>a || b<1) {
				System.out.println("Caution: Index out of range. Returning 0.");
				return 0;
			}*/
			int ans = (a%b)/(b/10);
			return ans;
		} catch(Exception e) {
			System.out.println("Caution: Method numAt(int, int) caught an Exception. Returning 0.");
			return 0;
		}
	}
	public static ArrayList<Integer> fillPrimes(ArrayList<Integer> list, int limit) {
		for(int x=2; x<=limit; x++) {
			int lim = (int)Math.sqrt((double)x);
			boolean prime=true;
			for (int i=2; i <= lim; i++) {
				if (x % i == 0) {
					prime=false;
					break;
				}
			}
			if(prime) list.add(x);
		}
		return list;
	}
	public static ArrayList<Integer> makePrimes(int limit) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int x=2; x<=limit; x++) {
			int lim = (int)Math.sqrt((double)x);
			boolean prime=true;
			for (int i=2; i <= lim; i++) {
				if (x % i == 0) {
					prime=false;
					break;
				}
			}
			if(prime) list.add(x);
		}
		return list;
	}
	/*public static int getSize(int x) {
		return x;
	}*/
	
	
	public static BigInteger sqrt(BigInteger testSubject, boolean round) {
		int digitsInTestSubject = testSubject.toString().length();

		double sPoint = (double)digitsInTestSubject / 2.0;

		BigInteger startPoint = BigInteger.valueOf(Math.round(sPoint));
		BigInteger lastGuess = null;
		BigInteger guess = null;

		BigInteger lower= null;
		BigInteger upper = null;

		if(digitsInTestSubject < 3) {
			lastGuess = BigInteger.valueOf(0L);
			lower = lastGuess;
			guess = BigInteger.valueOf(5L);
			upper = BigInteger.valueOf(10L);
		}
		else {
			startPoint = startPoint.subtract
			(BigInteger.valueOf(1L));
			startPoint = pow(BigInteger.valueOf
			(10L),startPoint);

			lastGuess = startPoint;
			lower = lastGuess;
	
			guess = startPoint.multiply(BigInteger.valueOf(5L));
			upper= startPoint.multiply(BigInteger.valueOf(10L));
		}

		//int guesses = 0;
		while(true) {
			//guesses++;
			BigInteger ans = guess.pow(2);
	
			if(ans.compareTo(testSubject) == 0) break;
	
			if(lastGuess.compareTo(guess) == 0) {
				if(round) {
					if(guess.compareTo(testSubject) == 1)
						guess = guess.subtract(BigInteger.valueOf(1));
					else
						guess = guess.add(BigInteger.valueOf(1));
				}
				else
					guess = null;
				break;
			}
	
			if(ans.compareTo(testSubject) == 1) {
				BigInteger tmp;
		
				if(guess.compareTo(lastGuess) == 1) {
					upper = guess;
					tmp = upper.subtract(lower);
					tmp = tmp.divide(BigInteger.valueOf(2L));
					tmp = lower.add(tmp);
				}
				else {
					upper = guess;
					tmp = upper.subtract( upper.subtract(lower).divide(BigInteger.valueOf(2L) ));
				}
				lastGuess = guess;
				guess = tmp;
			}
			else {
				BigInteger tmp;
				if(guess.compareTo(lastGuess) == 1) {
					lower = guess;
					tmp = upper.subtract(lower);
					tmp = tmp.divide
					(BigInteger.valueOf(2L));
					tmp = upper.subtract(tmp);
				}
				else {
					lower = guess;
					tmp = lower.add( upper.subtract
					(lower).divide(BigInteger.valueOf(2L) ));
				}
		
				lastGuess = guess;
				guess = tmp;
			}
		}

		return guess;
	}

	public static BigInteger pow(BigInteger testSubject, BigInteger pow) {
		BigInteger index = BigInteger.valueOf(1L);
		BigInteger retVal = BigInteger.valueOf(10L);
	
		while(index.compareTo(pow) != 0) {
			retVal = retVal.multiply(testSubject);
			index = index.add(BigInteger.valueOf(1L));
		}
	
		return retVal;
	}
	static double pwr(double a, int pwr) {
		double ans = 1;
		for(int i=pwr; i>0; i--) {
			ans*=a;
		}
		return ans;
	}
	public static int gcd(int a, int b) {
		   if (b==0) return a;
		   return gcd(b,a%b);
		}
	public static long gcd(long a, long b) {
	   if (b==0) return a;
	   return gcd(b,a%b);
	}
	public static int totient(int num){ //euler's totient function calculator. returns totient
		int count=0;
		for(int a=1;a<num;a++){ //definition of totient: the amount of numbers less than num coprime to it
			if(gcd(num,a)==1) //coprime
				count++;
		}
		return(count);
	}
}