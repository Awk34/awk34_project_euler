/*
 * Andrew Koroluk
 */

public class Clock {
	private long time;
	private long nanotime;
	//public static void main(String[] args) {}
	//System.nanoTime();
	public Clock() {
		time = System.currentTimeMillis();
	}
	public long getTimeMillis() {
		long temp = System.currentTimeMillis();
		System.out.println(temp - time + " Milliseconds elapsed.");
		return temp;
	}
	public double getTimeSeconds() {
		double temp = (double)(System.currentTimeMillis() - time)/1000;
		System.out.println(temp + " Seconds elapsed.");
		return temp;
	}
	public long getTimeNanos() {
		long temp = System.nanoTime();
		System.out.println(temp - nanotime + " Nanoseconds elapsed.");
		return temp;
	}
	public long newTimeMillis() {
		long temp = System.currentTimeMillis() - time;
		time = System.currentTimeMillis();
		System.out.println(temp + " Milliseconds elapsed.");
		return temp;
	}
	public double newTimeSeconds() {
		double temp = (double)(System.currentTimeMillis() - time)/1000;
		time = System.currentTimeMillis();
		System.out.println(temp + " Seconds elapsed.");
		return temp;
	}
	public void startNanos() {
		nanotime = System.nanoTime();
	}
	public void reset() {
		time = System.currentTimeMillis();
	}
}