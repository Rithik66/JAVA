package Javatraining;

import java.util.Scanner;

public class RecOlympiad {
	static int ans2=0,count=0;
	static int sum(int n,int m) {
		if(m>1) {
			sum(sum(n,m-1),1);
		}
		else {
			if(n>0) {
				if(n!=ans2) {
				ans2+=n;
				}
				n--;
				sum(n,1);
			}
		}
		return ans2;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		System.out.println(sum(n,m));
	}
}
