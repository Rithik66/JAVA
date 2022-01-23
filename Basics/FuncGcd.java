package Javatraining;

import java.util.Scanner;

public class FuncGcd {
	static int findValue(int x,int y) {
		int k=0,g=0;
		if(x<y) k=x;
		else k=y;
		for(int i=1;i<=k;i++) {
			if(x%i==0 && y%i==0) g=i;
		}
		return g;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ans=findValue(a, b);
		System.out.println(ans);
	}
}
