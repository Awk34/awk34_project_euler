/*
 * Andrew Koroluk
 */

class euler19 {
	public static boolean isLeap(int year) {
		if( year%400 == 0 ) {
			return true;
		}
		else if( year%100 == 0 ) {
			return false;
		}
		else if( year%4 == 0 ) {
			return true;
		}
		else return false;
	}
	public static void main(String[] args) {
		int ans = 0;
		int year = 1900;
		int month = 1;
		int[] monthdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int weekday = 1;

		for(; year<=2000; year++) {
			for(; month<=12; month++) {
				int daysnumber = monthdays[month];
				if(month==2 && isLeap(year))
					daysnumber++;
				for(int i=0; i<daysnumber; i++) {
					if(year>1900 && i==0 && weekday==7) {
						ans++;
						System.out.println("Year="+year+" & Day="+i+" & Weekday="+weekday);
					}
					weekday++;
					if(weekday>7)
						weekday=1;
				}
			}
			month=1;
		}
		System.out.println(ans+" Sundays fell on the first of the month during the 20th Century.");
	}
}

/*
You are given the following information, but you may prefer to do some research for yourself.

- 1 Jan 1900 was a Monday.
- Thirty days has September, April, June and November.
- All the rest have thirty-one.
- except February, Which has twenty-eight, rain or shine.
	- And on leap years, it has twenty-nine.
- A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/