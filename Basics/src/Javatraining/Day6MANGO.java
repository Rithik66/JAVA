package Javatraining;

import java.util.Scanner;

public class Day6MANGO {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int Abhi = 0,Ramu=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U')
					Ramu+=s.length()-i;
			else Abhi+=s.length()-i;
		}
		if(Abhi>Ramu) System.out.println("Abhi "+Abhi);
		else System.out.println("Ramu "+Ramu);
	}
}