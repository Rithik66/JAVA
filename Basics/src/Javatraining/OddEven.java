package Javatraining;

import java.util.Scanner;

public class OddEven {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int arr[] = new int[a];
		int odd=0,even=0;
		for (int i = 0; i < a; i++) {
			arr[i]=scanner.nextInt();
			if(arr[i]%2==0) {
				even++;
			}
			else odd++;
		}
		System.out.println(even+" "+odd);
	}
	
}
