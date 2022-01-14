package Javatraining;

import java.util.Scanner;

public class AdvnCEquality {
	String name,contactNumber,ownerName;
	double costPerDay;
	AdvnCEquality(String name,String contactNumber,double costPerDay,String ownerName){
		this.contactNumber=contactNumber;
		this.name=name;
		this.costPerDay=costPerDay;
		this.ownerName = ownerName;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj instanceof AdvnCEquality) {
		AdvnCEquality o = (AdvnCEquality)obj;
		return (o.contactNumber.equals(contactNumber) && o.costPerDay==this.costPerDay && o.name.equals(this.name) && o.ownerName.equals(this.ownerName));
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String contactNumber = scanner.nextLine();
		double costPerDay = scanner.nextDouble();
		scanner.nextLine();
		String ownerName = scanner.nextLine();
		String name1 = scanner.nextLine();
		String contactNumber1 = scanner.nextLine();
		double costPerDay1 = scanner.nextDouble();
		scanner.nextLine();
		String ownerName1 = scanner.nextLine();
		AdvnCEquality obj1 = new AdvnCEquality(name,contactNumber,costPerDay,ownerName);
		AdvnCEquality obj2 = new AdvnCEquality(name1,contactNumber1,costPerDay1,ownerName1);
		if(obj1.equals(obj2)) System.out.println("Equal");
		else System.out.println("Not Equal");
	}
}
