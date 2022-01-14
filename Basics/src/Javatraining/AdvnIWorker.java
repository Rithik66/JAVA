package Javatraining;

import java.util.Scanner;

public class AdvnIWorker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c=scanner.nextInt();
		scanner.nextLine();
		String n=scanner.nextLine();
		int s=scanner.nextInt();
		ManagerSal ms =new ManagerSal();
		ms.set(c, s, n);
		ms.display();
		ms.calcHRA();
		ms.calcDA();
		ms.calcCA();
		ms.calcGross();
	}
}
class WorkerDetail{
	int code,salary;
	String name;
	float hra=0;
	void set(int code,int salary,String name){
		this.code=code;
		this.salary=salary;
		this.name=name;
	}
	void display(){
		System.out.println("Code :"+this.code+"\nName : "+this.name+"\nSalary "+this.salary);
	}
	void calcHRA(){
		hra=(float)salary*60/100;
		System.out.println("HRA : "+hra);
	}
}
class OfficerSal extends WorkerDetail{
	float da=0;
	void calcDA(){
		da = (float)salary*98/100;
		System.out.println("DA :"+da);
	}
}
class ManagerSal extends OfficerSal{
	float ca,g;
	void calcCA(){
		ca = (float)salary*20/100;
		System.out.println("City Allowance :"+ca);
	}
	void calcGross(){
		g=salary+da+hra+ca;
		System.out.println("Gross Salary :"+g);
	}
}