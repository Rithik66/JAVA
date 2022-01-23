package Javatraining;

import java.util.Scanner;

public class Peter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		int c=0;
		int ones=0,zeros=0;
		for (int i = 0; i < s.length(); i++) {
			c=Integer.parseInt(String.valueOf(s.charAt(i)));
			if(c==0) zeros++; 
			if(c==1) ones++;
		}
		System.out.println(zeros+" "+ones);
		if(zeros>ones) System.out.println("Lose");
		else if(ones>zeros) System.out.println("Win");
		else if(zeros==10 && ones==zeros) {
			if(s.charAt(s.length()-1)=='0') System.out.println("Win");
			else System.out.println("Lose");
		}
	}
}
