package Javatraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCount {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		int a = scanner.nextInt();
		int[]ar = new int[a];
		int count=1;
		int k=scanner.nextInt();
		for(int i =1;i<a;i++) {
			ar[i]=scanner.nextInt();
		}
		int j=0;
		for(int i=1;i<a;i++) {
			if(k<=ar[i]) { count+=1+j;j=j+1;}
			else j=0;
			k=ar[i];
		}
		System.out.println(count+a-1);
	}
}