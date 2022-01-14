package Javatraining;

import java.util.Scanner;

public class Matcher {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		int count=0;
		for (int i=0;i<s1.length();i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			if(c1==c2 || c1=='?' || c2=='?') count=0;
			else {count=1;break;}
		}
		if(count==1) System.out.println("No");
		else System.out.println("Yes");
	}
}