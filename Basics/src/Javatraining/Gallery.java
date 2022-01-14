package Javatraining;

import java.util.Scanner;
public class Gallery {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a =scanner.nextInt();
		int array[] = new int[a];
		int even=0,odd=0;
		for(int i = 0;i<a;i++) {
			array[i]=scanner.nextInt();
			if(array[i]%2==0) even++;
			else odd++;
		}
		System.out.println(even+" "+odd);
	}
}
