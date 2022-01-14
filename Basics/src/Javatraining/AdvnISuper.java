package Javatraining;

import java.util.Scanner;

public class AdvnISuper {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		String[] s = scanner.nextLine().split(",");
		if(a==1) {
			Event1.set(s[1]);
			Exhibition e = new Exhibition(s[0],s[2],s[3],Integer.parseInt(s[4]));
			new Exhibition();
		}
		else if(a==2) {
			Event1.set(s[1]);
			StageEvent e = new StageEvent(s[0],s[2],s[3],Integer.parseInt(s[4]));
			new StageEvent();
		}
		else System.out.println("Invalid input");
	}
}
class Event1{
	static private String name,detail,type,organiserName;
	Event1(String name,String type,String organiserName){
		this.name=name;
		this.type=type;
		this.organiserName=organiserName;
	}
	Event1(){
		System.out.print(this.name+" "+this.detail+" "+this.type+" "+this.organiserName+" ");
	}
	static void set(String d) {
		detail=d;
	}
	static String get() {
		return detail;
	}
}
class Exhibition extends Event1{
	static private int noOfStalls;
	Exhibition(String name, String type, String organiserName,int noOfStalls) {
		super(name, type, organiserName);
		this.noOfStalls=noOfStalls;
	}
	Exhibition(){
		super();
		System.out.print(this.noOfStalls);
	}
}
class StageEvent extends Event1{
	static private int noOfSeats;
	StageEvent(String name, String type, String organiserName,int noOfSeats) {
		super(name, type, organiserName);
		this.noOfSeats=noOfSeats;
	}
	StageEvent(){
		super();
		System.out.print(this.noOfSeats);
	}
}