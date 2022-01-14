package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int b =scanner.nextInt();
		int ar[][] = new int[a][b];
		int maxnum=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				ar[i][j]=scanner.nextInt();
			}
		}
		int x=scanner.nextInt();
		int array[] = new int[a];
		for(int i=0;i<a;i++) {
			int ans=0;
			for(int j=0;j<b;j++) {
				ans=ans+ar[i][j];
			}
			array[i]=ans/b;
		}
		int count=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]>x) count++;
		}
		System.out.println(count);
	}
}
