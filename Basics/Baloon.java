package Javatraining;
import java.util.Scanner;
public class Baloon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		char c1;
		int a=0,b=0,min=0;
		for (int i=0;i<s1.length();i++) {
			c1=s1.charAt(i);
			if(c1=='a') a++;
			else b++;
		}
		if(b>a) min=a;
		else min=b;
		System.out.println(min);
	}
}
