package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class AdobePascalTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int ar[][] = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j) ar[i][j]=1;
				else if(j==0) ar[i][j]=1;
				else ar[i][j]=ar[i-1][j-1]+ar[i-1][j];
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
}
