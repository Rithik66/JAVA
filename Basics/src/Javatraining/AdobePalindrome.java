package Javatraining;
import java.util.Scanner;
public class AdobePalindrome {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int length = String.valueOf(a).length();
		int k,l=0,r,temp=a;;
		for(int i=length-1;i>=0;i--) {
			k=temp%10;
			l+=k*(int)(Math.pow(10,i));
			temp=temp/10;
		}
		if(l==a) System.out.println("Palindrome");
		else System.out.println("Not a Palindrome");
	}
}