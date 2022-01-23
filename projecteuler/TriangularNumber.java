package projecteuler;

import java.util.Scanner;

public class TriangularNumber {
	public static void main(String[] args) {
		for (int i = 1; i < 100000; i++) {
			findSum(i);
		}
	}
	static void calculateFactors(int x) {
		int count=0;
		for (int i = 1; i <= x; i++) {
			if(x%i==0) count++;
			if(count>=5) {
				System.out.print(i);
				break;
			}
		}
	}
	static void findSum(int x) {
		int sum=0;
		for (int i = 1; i <= x; i++) {
			sum+=i;
		}
		calculateFactors(sum);
	}
}
