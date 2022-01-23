package Javatraining;

import java.util.Scanner;
public class PatternTemp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int start=30,d1=5,d2=3,two=2,ten=10;
		System.out.print(start+" ");
		for(int i=1;i<a;i++) {
		if(i%2!=0) {
			start=start+d1;
			d1=d1-two;
			two=two+2;
			System.out.print(start+" ");
		}
		else {
			start=start+d2;
			d2=d2+ten;
			ten=ten+2;
			System.out.print(start+" ");
		}=
		}
	}
}