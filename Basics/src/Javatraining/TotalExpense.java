package Javatraining;
import java.util.Scanner;
public class TotalExpense {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		double d=0;
		if(b<50) d=0;
		else if(50<=b && b<=100) d=a*((double)10/100);
		else if(101<=b && b<=201) d=a*((double)20/100);
		else if(201<=b && b<=400) d=a*((double)30/100);
		else if(401<=b && b<=500) d=a*((double)40/100);
		else if(b>500) d=a*((double)50/100);
		System.out.printf("%.2f",(a-d)*b);
	}
}
