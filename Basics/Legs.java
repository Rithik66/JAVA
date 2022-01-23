package Javatraining;
import java.util.Scanner;
public class Legs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		if((a*2)+(b*2)==c)
			System.out.println("yes");
		else
			System.out.println("no");
	}
}