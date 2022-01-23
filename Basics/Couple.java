package Javatraining;

import java.util.Arrays;
import java.util.Scanner;

public class Couple {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[] = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		int temp[] = new int[50];
		int count=1;
		for (int i = 0; i < a; i++) {
			temp[arr[i]]+=1;
		}
		for(int i=0;i<temp.length;i++) {
			if(temp[i]!=0 && temp[i]%2!=0) {
				System.out.println(i);
				break;
			}
		}
	}
}

