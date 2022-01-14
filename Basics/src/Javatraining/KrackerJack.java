package Javatraining;

import java.util.Scanner;

public class KrackerJack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		char c1;
		int a=0,b=0,min=0;
		for (int i=0;i<s1.length();i++){
			c1=s1.charAt(i);
			if(c1=='0') a++;
			else b++;
		}
		if(a==1 || b==1) System.out.println("Yes");
		else System.out.println("No");
	}
}