/*
 * Andrew Koroluk
 */

import java.util.ArrayList;
import java.util.Iterator;

public class euler23 {
  public static void main(String[] args){
    ArrayList<Integer> abundants = new ArrayList<Integer>();
    for(int i = 1; i <= 28123; i++){
       int j = divisors(i);
       if(j > i){
         abundants.add(i);
       }
     }
     int[] array = new int[28123];
     int len = array.length;
     for(int i = 0; i < len; i++){
       array[i] = i + 1;
     }
     Iterator<Integer> it = abundants.iterator();
     while(it.hasNext()){
       int one = (Integer) it.next();
       for(int j = 0; j < abundants.size(); j++){
         int sum = one + (Integer)abundants.get(j);
         if(sum <= len){
           array[sum - 1] = 0;
         }
       }
       it.remove();//remove it as checked against ALL numbers
    } 
    int sum = 0;
     len = array.length;
     for(int i = 0; i < len; i++){
       sum += array[i];
     }
     System.out.println(sum);
   }
   public static int divisors(int number){
     int d = (int) Math.sqrt(number) + 1;
     int sum = 1;
     for(int i = 2; i < d; i++){
       if(number % i == 0){
         sum += i;
         if(i != (number / i)){
           sum += (number / i);
         }
       }
     }
     return sum;
   }
}

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 
would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper 
limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant 
numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/