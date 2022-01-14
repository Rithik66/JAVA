package Javatraining;

import java.util.Scanner;

public class Aes {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int b =scanner.nextInt();
		int aes=0;
		scanner.close();
		for(int i=a;i<=b;i++) {
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}if(count==4) aes++;
	}
	System.out.println(aes);

	}
	
}