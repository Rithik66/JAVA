package Javatraining;

import java.util.Scanner;
public class AdvnCToString {
	static String addressLine1,addressLine2,city,state;
	static int pincode;
	AdvnCToString(String addressLine1,String addressLine2,String city,String state,int pincode){
		setAddress(addressLine1,addressLine2,city,state,pincode);
	}
	String getAddress() {
		return this.addressLine1+"\n"+this.addressLine2+"\n"+this.city+"\n"+this.state+"\n"+this.pincode;
	}
	void setAddress(String addressLine1,String addressLine2,String city,String state,int pincode) {
		this.addressLine1=addressLine1;
		this.addressLine2=addressLine2;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
	}
	public String toString() {
		return getAddress();
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String addressLine1=scanner.nextLine();
		String addressLine2=scanner.nextLine();
		String city=scanner.nextLine();
		String state=scanner.nextLine();
		int pincode=scanner.nextInt();
		AdvnCToString obj = new AdvnCToString(addressLine1,addressLine2, city, state, pincode);
		System.out.println(obj);
	}
}
