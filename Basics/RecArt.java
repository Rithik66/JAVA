package Javatraining;

import java.util.Scanner;

public class RecArt {
	static void printNumbers(int x) {
		if(x>0) {
			printNumbers(x-1);
			System.out.print(x+" ");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		printNumbers(a);
	}
}
