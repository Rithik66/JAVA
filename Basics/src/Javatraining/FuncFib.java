package Javatraining;

import java.util.Scanner;

public class FuncFib {
	int fiboLastDigit(int x) {
		long a=0,b=1,temp=0;
		for (int i = 0; i < x; i++) {
			temp=a+b;
			a=b;
			b=temp;
		}
		return (int)(a%10);
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		FuncFib n = new FuncFib();
		System.out.println(n.fiboLastDigit(a));
	}
}