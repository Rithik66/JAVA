package Javatraining;

import java.util.Scanner;

public class RecCoordinates {
	static int count=0;
	static int find(int x1,int y1,int x2,int y2) {
		if(x1>x2 || y1>y2)return 0;
		else if(x1==x2 && y1==y2)return 1;
		else {
			if(y1!=y2 && y1<y2)count=find(x1,y1+x1,x2,y2);
			else if(x1!=x2 && x1<x2)count=find(x1+y1,y1,x2,y2);
			if(count==0)return 0;
			else return 1;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int a = find(x1,y1,x2,y2);
		if(count==1) System.out.println("True");
		else System.out.println("False");
	}
}