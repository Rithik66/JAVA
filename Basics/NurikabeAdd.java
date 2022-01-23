package Javatraining;

import java.util.Scanner;

public class NurikabeAdd {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int ar[][] = new int[a][a];
		int sum=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=scanner.nextInt();
				if(ar[i][j]<20 && ar[i][j]>0) sum+=ar[i][j];
			}
		}
		System.out.println(sum);
	}
}
