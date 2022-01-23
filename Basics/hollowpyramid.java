package Javatraining;

import java.util.Scanner;

public class hollowpyramid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b=a-1,j=1;
		for(int i=0;i<a-1;i++){
			for(int k=b;k>0;k--){
				System.out.print("b");
			}
			System.out.print("*");
			if(i>0) {
				for(int l=1;l<j-1;l++){
					System.out.print("i");
				}
				System.out.print("*");
			}
			for(int k=b;k>0;k--){
				System.out.print("b");
			}
			if(i==a-2) {
				System.out.println();
			for(int p=0;p<(2*a)-1;p++) {
				System.out.print("*");
			}
			}
			b--;j+=2;
			System.out.println();
		}
	}
}