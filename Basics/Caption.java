package Javatraining;

import java.util.Scanner;

public class Caption {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		String s2 = scanner.nextLine();
		int k=0,l=0;
		for (int i=0;i<s1.length();i++) {
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			if(c1!=c2 && c1!='?' && c2!='?') k++;
			if(c1=='?' || c2 =='?' || c2!=c1) l++;
		}
		System.out.println(k+" "+l);
	}
}