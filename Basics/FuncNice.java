package Javatraining;

import java.util.Scanner;

public class FuncNice {
	int findType(int x) {
		int count=0;
		for (int i = 1; i <= x; i++) {
			if(x%i==0) {
				count++;
			}
		}
		if(count==4) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		FuncNice func = new FuncNice();
		int b=func.findType(a);
		if(b==0) System.out.println(a+" is a not Nice number");
		if(b==1) System.out.println(a+" is a Nice number");
	}
}
