package Javatraining;

import java.util.Scanner;

public class LinearSearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		int x = scanner.nextInt();
		int res=search(arr,x);
		if(res>=0) System.out.println("Element found at index "+res);
		else System.out.println("Element not found");
	}
	static int search(int[] arr,int x) {
		for (int i=0;i<arr.length;i++) {
			if(arr[i]==x) return i;
		}
		return -1;
	}
}
