package Javatraining;

import java.util.Scanner;

public class Pattern1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int start = 30,count=1,x=5,y=3,ten=10,two=2;
		int even=start,odd=start;
		System.out.print(start+" ");
		for(int i=1;i<a;i++) {
			if(count%2!=0) {
				start=start+x;
				System.out.print(start+" ");
				x=x-two;
				two=two+2;
				count++;
			}
			else{
				start=start+y;
				System.out.print(start+" ");
				y=y+ten;
				count++;
				ten=ten+2;
			}
		}
	}
}
