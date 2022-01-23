package Javatraining;

import java.util.Scanner;

public class Register {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int ar[] = new int[a];
		int k[] = new int[50];
		for(int i=0;i<a;i++) {
			ar[i] = scanner.nextInt();
		}
		for(int i=0;i<a;i++) {
			k[ar[i]]+=1;
		}
		label:for(int i=0;i<k.length;i++) {
			if(k[i]==1) {
				System.out.print(i);
				break label;
			}
			else if(k[i]%2!=0) {
				System.out.print(ar[i]);
				break label;
			}
			else{
				System.out.print(ar[i]);
				break label;
			}
		}
	}
}
