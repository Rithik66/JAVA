package Javatraining;

import java.util.Scanner;

public class RecReverse {
	static int rev(int n) {
		int r=0;
		if(n>0) {
			r=n%10;
			System.out.print(r);
			rev(n/10);
		}
		return r;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		rev(n);
	}
}
