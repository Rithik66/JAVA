package Javatraining;

import java.util.Scanner;

public class AdvnCGetter {
	private String name;
	private double deposit;
	private double costPerDay;
	Scanner scanner = new Scanner(System.in);
	String[] s = scanner.nextLine().split(" ");
	void display() {
		setName();
	}
	void setName() {
		this.name=s[0];
		this.deposit=Double.parseDouble(s[1]);
		this.costPerDay=Double.parseDouble(s[2]);
		getName();
	}
	void getName() {
		System.out.println(this.name);
		System.out.println(this.deposit);
		System.out.println(this.costPerDay);
	}
	public static void main(String[] args) {
		AdvnCGetter g = new AdvnCGetter();
		g.display();
	}
}
