package Javatraining;

import java.util.Scanner;

public class BasicPatterns {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		for(int i=0;i<a;i++) {
//			for(int j=0;j<a;j++) { 
//				if(j<=i)System.out.print("*");
//				else System.out.print(" ");
//			}
//			System.out.println();
//		}
		  Scanner scanner = new Scanner(System.in);
		  int a = scanner.nextInt();
		  int t=a-1;
		  for(int i=0;i<a;i++){
		      for(int j=(a-i)+t-1;j>0;j--){
		           System.out.print(" ");
		      }
		      System.out.print("*");
		      for(int j=0;j<i;j++){
		           System.out.print("   ");
		           System.out.print("*");
		      }
		      for(int j=(a-i)+t-1;j>0;j--){
		           System.out.print(" ");
		      }
		      System.out.println();
		      t--;
		 }
	}
}