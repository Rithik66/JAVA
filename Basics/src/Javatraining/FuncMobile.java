package Javatraining;

import java.util.Scanner;

public class FuncMobile {
	void find(int x,int y,int z) {
		int i;
		double morA=(((double)x-100)*25)/100;
		if(morA<0) morA=0;
		double morB=(((double)x-250)*45)/100;
		if(morB<0) morB=0;
		double eveA=((double)y*15)/100;
		double eveB=((double)y*35)/100;
		double weeA=((double)z*20)/100;
		double weeB=((double)z*25)/100;
		double totA=Math.round((morA+eveA+weeA)*100);
		totA = totA/100;
		double totB=morB+eveB+weeB;
		System.out.println("Plan A costs "+totA);
		System.out.println("Plan B costs "+totB);
		if(totA>totB) System.out.println("Plan B is cheapest");
		else if(totA<totB) System.out.println("Plan A is cheapest");
		else System.out.println("Plan A and B are the same price");
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		FuncMobile num = new FuncMobile();
		num.find(a,b,c);
	}
}
