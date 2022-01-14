package Javatraining;

import java.util.Scanner;

public class Event {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		if(Integer.parseInt(a)>10) {
			int start,end;
			char c;
			c=a.charAt(0);
			start=Integer.parseInt(String.valueOf(c));
			c=a.charAt(a.length()-1);
			end=Integer.parseInt(String.valueOf(c));
			int ans=Math.abs(start-end);
			System.out.println(ans);
		}
		else System.out.println("Invalid Input");
	}
}
