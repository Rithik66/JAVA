package Javatraining;

import java.util.Scanner;

public class Stringstarbtwn {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s=scanner.nextLine();
		String ans="";
		for(int i=0;i<s.length()-1;i++) {
			char c=s.charAt(i);
			if(c==s.charAt(i+1)) {
				ans+=c+"*";
			}
			else ans+=c;
		}
		ans+=String.valueOf(s.charAt(s.length()-1));
		System.out.println(ans);
	}
}
