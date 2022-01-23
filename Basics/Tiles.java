package Javatraining;

import java.util.Scanner;

public class Tiles {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); //cm
		int b = scanner.nextInt(); //tiles no
		int k=0;
		for(int i=1;i*i<b;i++) {
			k=i*i;
		}
		int totalarea=k*(a*a);
		System.out.println(totalarea);
	}
}
