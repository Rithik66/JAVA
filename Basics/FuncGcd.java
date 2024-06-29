package Javatraining;

import java.util.Scanner;

public class FuncGcd {
	static int findValue(int x,int y) {
		int small=0,large=0;
		if(x<y) small=x;
		else small=y;
		for(int i=1;i<=small;i++) {
			if(x%i==0 && y%i==0) large=i;
		}
		return large;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ans=findValue(a, b);
		System.out.println(ans);
	}
}
