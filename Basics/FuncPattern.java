package Javatraining;

import java.util.Scanner;

public class FuncPattern {
	int find(int x) {
		int count=0,i=0,j=0;
		A:for(i=0;i<x;i++) {
			for(j=0;j<=i;j++) {
				count++;
				if(count==x) break A;
			}
		}
		if(i==j) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		FuncPattern num = new FuncPattern();
		int b=num.find(a);
		if(b==1) System.out.println("Yes");
		else System.out.println("No");
	}
}