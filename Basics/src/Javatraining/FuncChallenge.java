package Javatraining;

import java.util.Scanner;

public class FuncChallenge {
	long findSum(int x) {
		long sum = 0;
		for (int i = 0; i <=x; i++) {
			sum+=Math.pow(2, i);
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		FuncChallenge num = new FuncChallenge();
		System.out.println(num.findSum(a));
		
	}
}
