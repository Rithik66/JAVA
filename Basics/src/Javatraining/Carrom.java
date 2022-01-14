package Javatraining;

import java.util.Scanner;

public class Carrom {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		if(a<1||a>9) System.out.println("Invalid Input");
		else {
		char c = scanner.next().charAt(0);
		if(c=='y') System.out.println(a+5);
		else if(c=='n') System.out.println(a);
		}
	}
}
