package Javatraining;

import java.util.Scanner;

public class Wb {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1=scanner.nextLine().toUpperCase();
		String s2=scanner.nextLine().toUpperCase();
		String ans="";
		char count=1;
		for (int i=0;i<s1.length();i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			char c3=0;
			if(c1==c2 && c1=='W') c3='B';
			else if(c1==c2 && c1=='B') c3='W';
			else if(c1!=c2 && c1=='B') {
				if(count%2!=0) c3='B';
				else c3='W';
				count++;
			}
			else if(c1!=c2 && c1=='W') {
				if(count%2!=0) c3='W';
				else c3='B';
				count++;
			}
			ans+=String.valueOf(c3);
		}
		System.out.println(ans);
	}
}
