package Javatraining;

import java.util.Scanner;

public class WelcomeParty {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int ar[] = new int[a];
		for (int i = 0; i < a; i++) {
			ar[i]=scanner.nextInt();
		}
		int k[] = new int[4];
		for (int i = 0; i < a; i++) {
			k[ar[i]]+=1;
		}
		int max=0;
		for(int i=0;i<4;i++) {
			if(k[i]>max) max=k[i];
		}
		System.out.println(a-max);
	}
}