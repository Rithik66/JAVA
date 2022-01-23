package Javatraining;

import java.util.Scanner;

public class AdvnIPersStaTempMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n = scanner.nextLine();
		int i = scanner.nextInt();
		int d = scanner.nextInt();
		int h = scanner.nextInt();
		scanner.close();
		Temporary t = new Temporary(n,i,d,h);
		t.display();
	}
}
class Person1{
	static String name;
	Person1(){
		System.out.print("");
	}
	Person1(String name){
		this.name=name;
	}
	void display() {
		System.out.println("Name : "+name);
	}
}
class Staff1 extends Person1{
	static int staffId;
	Staff1(){
		super();
	}
	Staff1(int staffId,String name){
		super(name);
		this.staffId=staffId;
	}
	void display() {
		Person1 p = new Person1();
		p.display();
		System.out.println("Staff1 Id : "+staffId);
	}
}
class Temporary extends Staff1{
	int daysW,hoursW;
	Temporary(String name,int staffId,int daysW,int hoursW){
		super(staffId,name);
		this.daysW=daysW;
		this.hoursW=hoursW;
	}
	void salary(int daysW,int hoursW) {
		int sal = (50*hoursW)*daysW;
		System.out.println("Total Salary : "+sal);
	}
	void display() {
		Staff1 st = new Staff1();
		st.display();
		System.out.println("No. of Days : "+daysW);
		System.out.println("No. of Hours : "+hoursW);
		salary(daysW,hoursW);
	}
}