package Javatraining;

import java.util.Scanner;

public class Cellstwo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int ar[][] = new int[5][5];
		int count=0,maxnum=0,c=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=scanner.nextInt();
				if(ar[i][j]!=20) {
					c = ar[i][j];
					maxnum=Math.max(maxnum, ar[i][j]);
				}
			}
		}
		System.out.println(maxnum);
	}
}
