package Javatraining;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeSteve {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ar[] = new int[n+1];
		ArrayList<Integer> res = new ArrayList<>();
		int l = (int)Math.sqrt(n);
		for(int i=2;i<n;i++) {
			if(ar[i]==0) {
				if(i<=l) {
				}
			}
		}
	}
}
