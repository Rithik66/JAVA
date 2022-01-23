package Javatraining;

import java.util.Scanner;

public class AdvnIPatient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		String n = scanner.nextLine();
		String a = scanner.nextLine();
		String g = scanner.nextLine();
		String ad = scanner.nextLine();
		String m = scanner.nextLine();
		String rn = scanner.nextLine();
		double cf = scanner.nextDouble();
		double tf = scanner.nextDouble();
		scanner.nextLine();
		String da = scanner.nextLine();
		String dd = scanner.nextLine();
		int nd = scanner.nextInt();
		double rr = scanner.nextDouble();
		scanner.nextLine();
		String dob = scanner.nextLine();
		Bill bb = new Bill(id,n,a,g,ad,m,rn,cf,tf,da,dd,nd,rr,dob);
		bb.displayData();
		bb.calculateTotalBillAmount();
	}
}
class Patient{
	String id,n,a,g,ad,m;
	Patient(String id,String n,String a,String g,String ad,String m){
		this.id=id;
		this.n=n;
		this.a=a;
		this.g=g;
		this.ad=ad;
		this.m=m;
	}
	void displayData() {
		System.out.println("PID: "+id+"\nName: "+n+"\nAge: "+a+"\nGender: "+g+"\nAddress: "+ad+"\nMobile Number: "+m);
	}
}
class In_Patient extends Patient{
	String rn,da,dd;
	double cf,tf,rr;
	int nd;
	In_Patient(String id, String n, String a, String g, String ad, String m,String rn,double cf,double tf,String da,String dd,int nd,double rr) {
		super(id, n, a, g, ad, m);
		this.rn=rn;
		this.cf=cf;
		this.tf=tf;
		this.da=da;
		this.dd=dd;
		this.nd=nd;
		this.rr=rr;
	}
	void displayData() {
		super.displayData();
		System.out.println("Room Number: "+rn+"\nConsulation Fee: "+cf+"\nTest Fee: "+tf+"\nDOA: "+da+"\nDischarge Date: "+dd+"\nNumber of Days: "+nd+"\nRoom Rent: "+rr);
	}
}
class Bill extends In_Patient{
	String dob;
	double total;
	Bill(String id, String n, String a, String g, String ad, String m, String rn, double cf, double tf, String da,String dd, int nd, double rr,String dob) {
		super(id, n, a, g, ad, m, rn, cf, tf, da, dd, nd, rr);
		this.dob=dob;
	}
	void displayData() {
		super.displayData();
		System.out.println("Date of bill: "+dob);
	}
	void calculateTotalBillAmount() {
		total=(nd*rr)+tf+cf;
		System.out.println("Total amount: "+total);
	}
}
