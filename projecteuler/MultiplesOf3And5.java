package projecteuler;

import java.util.Scanner;

public class MultiplesOf3And5 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int j,sum=0;
			for(j=1;j<a;j++) {
			if(j%3==0||j%5==0)
				sum+=j;
			}
		System.out.println(sum);
		}}