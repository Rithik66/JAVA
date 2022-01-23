package Javatraining;

import java.util.Scanner;

public class StringCSK {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine().toUpperCase();
		int check=0;
		if(s.length()==3 || s.length()==2 || s.length()==1) check=1;
		else {
		char k=s.charAt(0);
		char l=s.charAt(1);
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==k || s.charAt(i)==l) check=0;
			else check=1;
		}
		if(check==0) {
		int count=0;
		String s1 = "",s2="";
		for (int i = 0; i < s.length()-1; i+=2) {
			char x=s.charAt(i);
			char y=s.charAt(i+1);
			if(count==0) {
			s1=String.valueOf(x)+String.valueOf(y);
			count=1;
			}
			else {
			s2=String.valueOf(x)+String.valueOf(y);
			if(s1.equals(s2)) check=0;
			else check=1;
			}
		}
		}
		}
		if(check==0) { System.out.println("Yes");}
		else System.out.println("No");
	}
}
