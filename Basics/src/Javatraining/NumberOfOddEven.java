package Javatraining;

import java.util.Scanner;

class NumberOfOddEven {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int [] b =new int[a];
		int odd=0,even=0;
		for (int i = 0; i < a; i++) {
			b[i] = scanner.nextInt();
			if(b[i]%2==0) even++;
			else odd++;
		}
		System.out.println(even+" "+odd);
	}
}
