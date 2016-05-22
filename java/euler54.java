/*
 * Andrew Koroluk
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class euler54 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> player1 = new ArrayList<String>();
		ArrayList<String> player2 = new ArrayList<String>();
		int ans=0;
		
		Scanner s = new Scanner(new File("poker.txt"));
		
		while(s.hasNextLine()) {
			String str = s.nextLine();
			player1.add(str.substring(0,14));
			player2.add(str.substring(15));
		}
		for(int i=0; i<player1.size(); i++) {
			if(whoWon(player1.get(i), player2.get(i))==1) ans++;
			System.out.println("P1 "+player1.get(i)+" "+getScore(player1.get(i))+"\nP2 "+player2.get(i)+" "+getScore(player2.get(i)));
			System.out.println(whoWon(player1.get(i), player2.get(i)));
		}
		System.out.println("Ans = "+ans);	//376
	}
	@SuppressWarnings("unused")
	private static void test() {
		System.out.println(whoWon("5H 5C 6S 7S KD","2C 3S 8S 8D TD"));//2
		System.out.println(whoWon("5D 8C 9S JS AC","2C 5C 7D 8S QH"));//1
		System.out.println(whoWon("2D 9C AS AH AC","3D 6D 7D TD QD"));//2
		System.out.println(whoWon("4D 6S 9H QH QC","3D 6D 7H QD QS"));//1
		System.out.println(whoWon("2H 2D 4C 4D 4S","3C 3D 3S 9S 9D"));//1
		System.out.println(CardToNum('A'));
		System.out.println(getScore("2H 2D 4C 4D 4S")); //60404040202
	}
	static int whoWon(String p1, String p2) {
		long s1, s2;
		//System.out.println("s1 "+p1+" "+getScore(p1)+"\ns2 "+p2+" "+getScore(p2));
		s1 = getScore(p1);
		s2 = getScore(p2);
		
		if(s1==s2) {
			System.out.println("s1 "+p1+" "+getScore(p1)+"\ns2 "+p2+" "+getScore(p2));
			return 0;
		}
		else if(s1>s2) return 1;
		else return 2;
	}
	private static long getScore(String s) {
		int[] cards = {CardToNum(s.charAt(0)), CardToNum(s.charAt(3)), CardToNum(s.charAt(6)), CardToNum(s.charAt(9)), CardToNum(s.charAt(12)), };
		Utils.quickSort(cards, 0, 4);
		
		boolean sameSuit = false;
		boolean straight = false;
		long ans=00000000000;
		long card1=0,card2=0,card3=0,card4=0,card5=0;
		
		//if all cards are same suit
		if(	s.charAt(1)==s.charAt(4) && s.charAt(4)==s.charAt(7) && s.charAt(7)==s.charAt(10) && s.charAt(10)==s.charAt(13)) {
			if(cards[0]==10 && cards[1]==11 && cards[2]==12 && cards[3]==13 && cards[4]==14) return 91413121110L;
			sameSuit = true;
		}
		
		//if there is a straight (including ace first)
		int one = cards[0];
		if(cards[0]==2 && cards[1]==3 && cards[2]==4 && cards[3]==5 && cards[4]==14) straight=true;
		else if(cards[1]==one+1 && cards[2]==one+2 && cards[3]==one+3 && cards[4]==one+4) straight=true;
		if(sameSuit && straight) {
			card1=cards[4]*100000000; card2=cards[3]*1000000; card3=cards[2]*10000; card4=cards[1]*100; card5=cards[0]; 
			return 80000000000L + card1+card2+card3+card4+card5;
		}
		
		ArrayList<Integer> a = array2AList(cards);
		
		boolean twoKind=false, threeKind=false, twoPair=false;
		for(int i=0; a.size()!=0; ) {
			int card = a.get(i);
			int mult=1;
			for(int j=1; j<a.size(); j++) {
				if(i==j) continue;
				if(card==a.get(j)) {
					mult++;
					a.remove(j);
					j--;
				}
			}
			if(mult==4) {
				ans+= 70000000000L;
				ans+= card*100000000 + card*1000000 + card*10000 + card*100;
				a.remove(i);
				break;
			}
			if(mult==3) {
				threeKind=true;
				ans+= card*100000000 + card*1000000 + card*10000;
				card1=card;
				a.remove(i);
				continue;
			}
			if(twoKind&&mult==2) {
				twoPair=true;
				if(card>card1) {
					card3=card1; card4=card1;
					card1=card; card2=card;
				}
				else {
					card3=card; card4=card;
				}
				ans+= card1*100000000 + card2*1000000 + card3*10000 + card4*100;
				a.remove(i);
				continue;
			}
			if(mult==2) {
				twoKind=true;
				card1=card; card2=card;
			}
			a.remove(i);
		}
		
		if(threeKind && twoKind) {
			ans+= card1*100 + card2;
			return 60000000000L + ans;
		}
		if(sameSuit) return 50000000000L + cards[4]*100000000 + cards[3]*1000000 + cards[2]*10000 + cards[1]*100 + cards[0];
		if(straight) return 40000000000L + card1*100000000 + card2*1000000 + card3*10000 + card4*100 + card5;
		if(threeKind) {
			int var = 100;
			for(int i=cards.length-1; i>=0; i--) {
				int temp = cards[i];
				if(temp==card1) continue;
				ans += temp*var;
				var/=100;
			}
			return 30000000000L + ans + card4*100 + card5;
		}
		if(twoPair) {
			for(int i=cards.length-1; i>=0; i--) {
				int temp = cards[i];
				if(temp==card1 || temp==card3) continue;
				ans += temp;
				break;
			}
			return 20000000000L + ans + card1*100000000 + card2*1000000;
		}
		if(twoKind) {
			int var = 10000;
			for(int i=cards.length-1; i>=0; i--) {
				int temp = cards[i];
				if(temp==card1) continue;
				ans += temp*var;
				var/=100;
			}
			return 10000000000L + card1*100000000 + card2*1000000 + ans;
		}
		
		return cards[4]*100000000 + cards[3]*1000000 + cards[2]*10000 + cards[1]*100 + cards[0];
	}
	static int CardToNum(char c) {
		if(c>='2' && c<='9') return Integer.parseInt(Character.toString(c));
		if(c=='T') return 10;
		else if(c=='J') return 11;
		else if(c=='Q') return 12;
		else if(c=='K') return 13;
		else if(c=='A') return 14;
		else return 0;
	}
	static ArrayList<Integer> array2AList(int[] array) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<array.length; i++)
			a.add(array[i]);
		return a;
	}
}
/*
0 High Card: Highest value card.
1 One Pair: Two cards of the same value.
2 Two Pairs: Two different pairs.
3 Three of a Kind: Three cards of the same value.
4 Straight: All cards are consecutive values.
5 Flush: All cards of the same suit.
6 Full House: Three of a kind and a pair.
7 Four of a Kind: Four cards of the same value.
8 Straight Flush: All cards are consecutive values of same suit.
9 Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
*/