package Javatraining;

import java.util.Scanner;

public class FuncPerfect {
	static int findType(int x) {
		int sum=0;
		for (int i = 1; i < x; i++) {
			if(x%i==0) {
				sum+=i;
			}
		}
		if(sum==x) return 0;
		else if(sum<x) return 1;
		else return -1;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b=findType(a);
		if(b==0) System.out.println(a+" is a perfect number");
		if(b==1) System.out.println(a+" is a deficient number");
		if(b==-1) System.out.println(a+" is a abundant number");
	}
}
