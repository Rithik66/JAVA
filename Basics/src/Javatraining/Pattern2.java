package Javatraining;

import java.util.Scanner;
public class Pattern2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int start = 20,count=40;
		System.out.print(start+" ");
		for(int i=0;i<a-1;i++) {
			start=start+count;
			count=count+4;
			System.out.print(start+" ");
		}
	}
}