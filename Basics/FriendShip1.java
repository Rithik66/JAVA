package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class FriendShip1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int temp[] = new int[a];
		int arr[] = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		int k=0;
		for (int i = 0; i < a-1; i++) {
			if(arr[i]!=arr[i+1]) {
				temp[k]=arr[i];
				k++;
			}
			temp[k]=arr[a-1];
		}
		System.out.println(k+1);
	}
}
