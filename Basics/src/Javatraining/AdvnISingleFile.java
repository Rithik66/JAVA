package Javatraining;

import java.util.Scanner;

public class AdvnISingleFile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		String s = scanner.nextLine();
		int y = scanner.nextInt();
		Person p = new Person(s,y);
		if(a==1) {
			scanner.nextLine();
			String d = scanner.nextLine();
			int per = scanner.nextInt();
			Student stu = new Student(d,per);
			System.out.print(p+""+stu+""+stu.eligibility());
		}
		else if(a==2) {
			scanner.nextLine();
			String sub = scanner.nextLine();
			int per = scanner.nextInt();
			int salary = scanner.nextInt();;
			Staff st = new Staff(salary);
			TeachingStaff stu = new TeachingStaff(sub,per);
			System.out.print(p+""+st+""+stu);
		}
		else if(a==3) {
			scanner.nextLine();
			String sub = scanner.nextLine();
			int per = scanner.nextInt();
			int salary = scanner.nextInt();;
			Staff st = new Staff(salary);
			NonTeachingStaff stu = new NonTeachingStaff(sub,per);
			System.out.print(p+""+st+""+stu);
		}
	}
}
class Person{
	static String name;
	static int birthYear;
	Person(String name,int birthYear){
		this.name=name;
		this.birthYear=birthYear;
	}
	public String toString() {
		return "Name : "+name+"\n"+"BirthYear : "+birthYear+"\n";
	}
}
class Staff extends Person{
	static int salary;
	Staff(int salary) {
		super(name, birthYear);
		this.salary=salary;
	}
	public String toString() {
		return "Old Salary : "+(double)salary;
	}
}
class Student extends Person{
	String department;
	int percentage;
	Student(String department,int percentage) {
		super(name, birthYear);
		this.department=department;
		this.percentage=percentage;
	}
	public String toString() {
		return "Department : "+department;
	}
	String eligibility() {
		if(percentage>=75) return "\nEligible : "+"Yes";
		else return "\nEligiblity : "+"No";
	}
}
class TeachingStaff extends Staff{
	String subject;
	int result;
	TeachingStaff(String subject, int result) {
		super(salary);
		this.subject=subject;
		this.result=result;
	}
	double salary() {
		double sal=result/10;
		double res=(salary*sal)/100;
		return salary+res;
	}
	public String toString() {
		return "\nSubject : "+subject+"\n"+"New Salary : "+salary();
	}
}
class NonTeachingStaff extends Staff{
	String lab;
	int experience;
	NonTeachingStaff(String lab, int experience) {
		super(salary);
		this.lab=lab;
		this.experience=experience;
	}
	double salary() {
		double res=(salary*experience)/100;
		return salary+res;
	}
	public String toString() {
		return "\nLab : "+lab+"\n"+"New Salary : "+salary();
	}
}