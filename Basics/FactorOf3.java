package Javatraining;

import java.util.Scanner;

public class FactorOf3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[] = new int[a];
		int t=0,nt=0;
		for (int i = 0; i < a; i++) {
			arr[i]=scanner.nextInt();
			if(arr[i]%3==0) t++;
			else nt++;
		}
		if(nt==t || nt-t==1 || t-nt==1) {
			System.out.println("Yes");
		}else System.out.println("No");
	}
}
