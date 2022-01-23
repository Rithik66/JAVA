package Javatraining;

import java.util.Scanner;

public class AdvnCMatcher {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n1 = scanner.nextLine();
		String u1 = scanner.nextLine();
		String p1 = scanner.nextLine();
		String m1 = scanner.nextLine();
		String n2 = scanner.nextLine();
		String u2 = scanner.nextLine();
		String p2 = scanner.nextLine();
		String m2 = scanner.nextLine();
		User input1 = new User(n1,u1,p1,m1);
		User input2 = new User(n2,u2,p2,m2);
		if(input1.equals(input2)) System.out.println("User 1 and User 2 are equal");
		else System.out.println("User 1 and User 2 are not equal");
	}
}
class User{
	String name,username,password,mobileNumber;
	User(String name,String username,String password,String mobileNumber){
		this.name=name;
		this.username=username;
		this.password=password;
		this.mobileNumber=mobileNumber;
	}
	
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null)return false;
		if(o instanceof User) {
			User ob = (User)o;
			return ob.name.equals(name) && ob.username.equals(username) && ob.password.equals(password) && ob.mobileNumber.equals(mobileNumber);
		}
		return false;
	}
}
