/*
 * Andrew Koroluk
 */

public class euler17 {
	public static void main(String[] args) {
		Integer letters = 0,
		oneto99 = 106;							//There are 106 letters in 1 - 19

		for(Integer i=20; i<=99; i++) {
			if((i>=20&&i<40)||(i>=80&&i<100)) {	//twenty,thirty,eighty,ninety
				oneto99 += 6;
			}
			else if(i>=40&&i<70) {				//forty,fifty,sixty
				oneto99 += 5;
			}
			else if(i>=70&&i<80) {				//seventy
				oneto99 += 7;
			}

			//1 - 9
			if(i%10==1 || i%10==2 || i%10==6) {
				oneto99+=3;
			}
			else if(i%10==4 || i%10==5 || i%10==9) {
				oneto99+=4;
			}
			else if(i%10==3 || i%10==7 || i%10==8) {
				oneto99+=5;
			}
		}

		System.out.println("There are "+oneto99+" letters in One - Ninety-Nine");	//854

		for(Integer i=100; i<1000; i++) {
			//100 - 900
			if((i>=100&&i<300)||(i>=600&&i<700)) {
				letters += 10;
			}
			else if((i>=300&&i<400)||(i>=700&&i<900)) {
				letters += 12;
			}
			else if((i>=400&&i<600)||i>=900) {
				letters += 11;
			}

			//and
			if(i>100 && i%100!=0) {
				letters += 3;
			}
		}

		letters += oneto99*10;
		letters += 11; //1000
		System.out.println(letters);
	}
}

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/

