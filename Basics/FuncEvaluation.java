package Javatraining;

import java.util.Scanner;

public class FuncEvaluation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		long c=calculate(a,b);
		System.out.println(c);
	}
	static int calculate(int x,int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=Math.pow(x, i);
		}
		if(sum>=2147483647) return 2147483647;
		return sum;
	}
}