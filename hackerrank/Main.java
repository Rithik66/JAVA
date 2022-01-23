package hackerrank;

import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		//Loop2 class
		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();
		for(int i=1;i<=q;i++){
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int n = scanner.nextInt();
		Loop2 obj = new Loop2();
		obj.loop2(a, b, n);
		System.out.println("");
		}
		scanner.close();
		//Dataypes class
		Datatypes obj1 = new Datatypes();
		obj1.dataTypes();
	}
}
