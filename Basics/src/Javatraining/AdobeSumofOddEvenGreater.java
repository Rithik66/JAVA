package Javatraining;

import java.util.Scanner;

public class AdobeSumofOddEvenGreater {
	public static void main(String[] args) throws java.lang.Exception {
		int result = OddEvenSum(num);
	}
	static int OddEvenSum(int num) throws java.lang.Exception{
		String s = String.valueOf(num);
		int even=0,odd=0;
		for(int i=0;i<s.length();i++) {
			int k=Integer.parseInt(String.valueOf(s.charAt(i)));
			if(k%2==0) even+=k;
			else if(k%2!=0) odd+=k;
		}
		System.out.println(Math.max(even, odd));
		return Math.max(even, odd);
	}
	static {
		System.out.print("Input: ");
		}
	static Scanner scanner = new Scanner(System.in);
	static int num = scanner.nextInt();
}
