package Javatraining;

import java.util.Arrays;
import java.util.Scanner;
public class Nurikabe2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int arr[][] = new int[a][a];
		int[][] ar=new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				arr[i][j]=scanner.nextInt();
				ar[i][j]=arr[i][j];
			}
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				if(ar[i][j]==1){
					if(j<a-1)ar[i][j+1]=0;
					if(j>0) ar[i][j-1]=0;				
					if(i<a-1)ar[i+1][j]=0;
					if(i>0) ar[i-1][j]=0;
				}
				if(ar[i][j]!=20 && ar[i][j]!=0 && ar[i][j]!=1) {
					if(j<a-1 && i<a-1) {
					if(ar[i+1][j+1]!=20 && ar[i+1][j+1]!=0) {						
						ar[i][j+1]=0;
						ar[i+1][j]=0;
						}
					}
				}
				if(ar[i][j]!=20 && ar[i][j]!=0 && ar[i][j]!=1) {
					if(i<a-1 && j>0 && ar[i+1][j-1]!=20) {
					ar[i][j-1]=0;
					ar[i+1][j]=0;
					}
				}
				if(ar[i][j]!=20 && ar[i][j]!=0 && ar[i][j]!=1) {
					if(j<a-2 && ar[i][j+2]!=20 && ar[i][j+2]!=0) {
					ar[i][j+1]=0;
					}
					if(i<a-2 && ar[i+2][j]!=20 && ar[i+2][j]!=0) {
					ar[i+1][j]=0;
					}
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



