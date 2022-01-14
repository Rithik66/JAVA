package Javatraining;

import java.util.Scanner;

public class Library {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[]ar = new int[a+1];
		int[]ar1 = new int[a+1];
		int count=0;
		for(int i =1;i<=a;i++) {
			ar[i]=scanner.nextInt();
		}
		for(int i=1;i<=a;i++) {
			ar1[i]=scanner.nextInt();
			if(ar1[i]<=ar[i]-ar[i-1]) count++;
		}
		System.out.println(count);
	}
}