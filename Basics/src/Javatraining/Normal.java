package Javatraining;

import java.util.Scanner;

public class Normal {
 public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	int c = scanner.nextInt();
	int d = scanner.nextInt();
	double total = a+b+c+d;
	System.out.printf("Total expenses :Rs.%.2f\n",total);
	double be = ((double)a/total)*100;
	System.out.printf("Branding expenses percentage :%.2f%%\n",be);
	double te = ((double)b/total)*100;
	System.out.printf("Travel expenses percentage :%.2f%%\n",te);
	double fe = ((double)c/total)*100;
	System.out.printf("Food expenses percentage :%.2f%%\n",fe);
	double le = ((double)d/total)*100;
	System.out.printf("Logistics expenses percentage :%.2f%%\n",le);
 	}
}
