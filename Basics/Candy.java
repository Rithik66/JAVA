package Javatraining;

import java.util.Scanner;

public class Candy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int count=0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='4') count++;
		}
		System.out.println(count);
	}
}
