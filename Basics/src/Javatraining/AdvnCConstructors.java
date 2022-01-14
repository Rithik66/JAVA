package Javatraining;

import java.util.Scanner;

public class AdvnCConstructors {
	static public String name,detail;
	AdvnCConstructors(){
		System.out.println("Using Default Constructor");
	}
	AdvnCConstructors(String name,String detail){
		this();
		System.out.println("Using Parameterized Constructor");
		setName(name,detail);
		System.out.println(getName());
	}
	void setName(String name,String detail) {
		this.name=name;
		this.detail=detail;
	}
	String getName() {
		return name+"\n"+detail;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String detail = scanner.nextLine();
		AdvnCConstructors obj = new AdvnCConstructors(name,detail);
	}
}
