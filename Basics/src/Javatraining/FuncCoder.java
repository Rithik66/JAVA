package Javatraining;

import java.util.Scanner;

public class FuncCoder {
	int findValue(String a,String b) {
		int count=0;
		int len = a.length()-b.length();
		int ax = Integer.parseInt(a.substring(len));
		if(ax==Integer.parseInt(b)) count=1;
		else count=0;
		return count;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		FuncCoder num = new FuncCoder();
		int c = num.findValue(a,b);
		if(c==1) System.out.println("Yes");
		else System.out.println("No");
	}
}
