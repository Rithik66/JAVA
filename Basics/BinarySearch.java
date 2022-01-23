package Javatraining;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int[] arr = new int [n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		int x = scanner.nextInt();
		int res = binarySearch(arr,x);
		if(res>=0) System.out.println("Element found at index "+res);
		else System.out.println("Element not found");
	}
	static int binarySearch(int[] arr,int x){
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (high+low)/2;
			if(arr[mid]==x) return mid;
			if(x<arr[mid]) high=mid-1;
			else low=mid+1;
		}
		return -1;
	}
}
