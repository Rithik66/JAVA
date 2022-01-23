package Javatraining;

import java.util.Scanner;

public class Nurikabe1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int ar[][] = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=scanner.nextInt();
			}
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(ar[i][j]==1) {
					if(j<a-1)ar[i][j+1]=0;
					if(j!=0) ar[i][j-1]=0;				
					if(i<a-1)ar[i+1][j]=0;
					if(i!=0) ar[i-1][j]=0;
				}
			}
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
}
