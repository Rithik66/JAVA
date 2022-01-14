package Javatraining;

import java.util.Scanner;

public class FuncModulo {
	int find(int x,int y) {
		int count=0,i;
		for(i=0;i<y;i++) {
			int check=x*i;
			int rem=check%y;
			if(rem==1) {count=1;break;}
		}
		if(count==1) return i;
		else return -1;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		FuncModulo num = new FuncModulo();
		int c=num.find(a,b);
		System.out.println(c);
	}
}