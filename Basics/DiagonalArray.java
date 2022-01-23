package Javatraining;

import java.util.Scanner;

public class DiagonalArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int ar[][] = new int[a][a];
		int k=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=scanner.nextInt();
				if(i==j & ar[i][j]>18 && ar[i][j]<60) k++;
			}
		}
	}
}
