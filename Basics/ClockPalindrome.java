package Javatraining;
import java.util.Scanner;
public class ClockPalindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] s = scanner.nextLine().split(":");
		int h =Integer.parseInt(s[0]);
		int m =Integer.parseInt(s[1]);
		int count=0;
		String rev=reverse(s[1]),right="";
		while(!s[0].equals(rev)){
			if(m<59) {
				m++;
				count++;
				if(String.valueOf(m).length()==1) {
					right="0"+String.valueOf(m);
					rev=reverse(right);
				}
				else rev=reverse(String.valueOf(m));
			}
			else if(m>=59) {
				m=00;
				h++;
				if(h==24) h=0;
				rev=reverse(String.valueOf(m));
				if(String.valueOf(m).length()==1) {
					right="0"+String.valueOf(m);
					rev=reverse(right);
					
				}else rev=reverse(String.valueOf(m));
				if(String.valueOf(h).length()==1) {
					s[0]="0"+String.valueOf(h);
				}
				else s[0]=String.valueOf(h);
			}
		}
		System.out.println(count+1);
		
	}
	static String reverse(String s) {
		String ans="";
		for(int i=s.length()-1;i>=0;i--) {
			ans+=s.charAt(i);
		}
		return ans;
	}
}
