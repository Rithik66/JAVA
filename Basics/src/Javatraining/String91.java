package Javatraining;

import java.util.Scanner;

public class String91 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		if(a.length()==13) {
			String a1 = a.substring(0,3);
			int check=a.compareTo("+91");
			String a2 = a.substring(3);
			if(check==10) System.out.println("Mobile number valid");
			else System.out.println("Mobile number invalid");
		}
		else System.out.println("Mobile number invalid");
	}
}