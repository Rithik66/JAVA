package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class Nurikabe3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int arr[][] = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				arr[i][j]=scanner.nextInt();
			}
		}
		int[][] ar=new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=arr[i][j];
			}
		}
		int nuri=0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(ar[i][j]==1) {
					if(j<a-1)ar[i][j+1]=0;
					if(j!=0) ar[i][j-1]=0;				
					if(i<a-1)ar[i+1][j]=0;
					if(i!=0) ar[i-1][j]=0;
				}
				if(ar[i][j]!=20 && ar[i][j]!=0) {
					if(j<a-1 && i<a-1) {
					if(ar[i+1][j+1]!=20 && ar[i+1][j+1]!=0) {						
						ar[i][j+1]=0;
						ar[i+1][j]=0;
						nuri=1;
						}
					}
					if(i<a-1 && j==1 && ar[i+1][j-1]!=20) {
					ar[i][j-1]=0;
					ar[i+1][j]=0;
					nuri=1;
					}
					
				}
			}
		}
		int flag=0;
		for (int i = 0; i < a; i++) {
			if(!Arrays.equals(ar[i], arr[i])) flag=1;
		}
		if(flag==0 && nuri==1) {
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(ar[i][j]!=20 && ar[i][j]!=0) {						
					if(j!=0 && i<a-1 && ar[i+1][j-1]!=0 && ar[i+1][j-1]!=20 && ar[i][j-1]==0 && ar[i+1][j]==0) System.out.println((i+1)+" "+(j+1));
					if(j!=0 && i!=0 && ar[i-1][j-1]!=0 && ar[i-1][j-1]!=20 && ar[i+1][j]==0 && ar[i][j-1]==0) System.out.println((i+1)+" "+(j+1));
					if(j<a-1 && i!=0 && ar[i-1][j+1]!=0 && ar[i-1][j+1]!=20 && ar[i-1][j]==0 && ar[i][j+1]==0) System.out.println((i+1)+" "+(j+1));
					if(j<a-1 && i<a-1 && ar[i+1][j+1]!=0 && ar[i+1][j+1]!=20 && ar[i+1][j]==0 && ar[i][j+1]==0) System.out.println((i+1)+" "+(j+1));
				}
			}
		}
		}
		else System.out.println("-1");
	}
}
