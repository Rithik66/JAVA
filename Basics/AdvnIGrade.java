package Javatraining;

import java.util.Scanner;

public class AdvnIGrade{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String s2 = scanner.nextLine();
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int arr[]=new int[b];
		for(int i=0;i<b;i++){
			arr[i]=scanner.nextInt();
		}
		Student1 st = new Student1(s,s2,a,arr);
		st.display();
	}
}
class Person13{
	String fn,ln;
	Person13(String fn,String ln){
		this.fn=fn;
		this.ln=ln;
	}
	void display() {
		System.out.println("Name: "+ln+" "+fn);
	}
}
class Student1 extends Person13{
	int id;
	int[] arr;
	Student1(String fn,String ln,int id,int arr[]){
		super(fn,ln);
		this.id=id;
		this.arr=arr;
	}
	void display() {
		super.display();
		System.out.println("ID: "+id);
		System.out.println("Grade: "+this.calculate());
	}
	char calculate() {
		int avg = 0,ans=0;
		for(int a :arr) {
			ans+=a;
		}
		avg=ans/arr.length;
		if(avg>=90) return 'O';
		else if(avg>=80)return 'E';
		else if(avg>=70)return 'A';
		else if(avg>=55)return 'P';
		else if(avg>=44)return 'D';
		else return 'T';
	}
}
