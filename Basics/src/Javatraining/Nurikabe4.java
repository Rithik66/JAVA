package Javatraining;

import java.util.Scanner;

public class Nurikabe4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int ar[][] = new int[a][a];
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				ar[i][j]=scanner.nextInt();
			}
		}
		int flag=0;
		for(int i=0;i<a;i++){
			for(int j=0;j<a;j++){
				if(ar[i][j]==1){
					if(j<a-1 && ar[i][j+1]!=0)
						flag=1;
					if(j!=0 && ar[i][j-1]!=0)
						flag=1;
					if(i<a-1 && ar[i+1][j]!=0)
						flag=1;
					if(i!=0 && ar[i-1][j]!=0)
						flag=1;
				}
				else if(ar[i][j]!=20 && ar[i][j]!=0 && ar[i][j]!=-1) {
					if(j<a-2 && ar[i][j+2]!=20)
						if(ar[i][j+1]!=0) flag=1;
				}
				System.out.print(flag+" ");
			}
			System.out.println();
		}
		if(flag==0)System.out.println("Yes");
		else System.out.println("No");
	}
}
