package Javatraining;

import java.util.Scanner;

public class AdvnIBank {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		
		String[] s = scanner.nextLine().split(" ");
		if(a==1) {
			SavingsAccount sa = new SavingsAccount(s[0],s[1],s[2],s[3]);
			sa.display();
		}
		else if(a==2) {
			CurrentAccount ca = new CurrentAccount(s[0],s[1],s[2],s[3]);
			ca.display();
		}
	}
}
class Account{
	static String accName,accNo,bankName;
	protected void display() {
		System.out.println(accName+"\n"+accNo+"\n"+bankName);
	}
}
class SavingsAccount extends Account{
	String orgName;
	SavingsAccount(String accName,String accNo,String bankName,String orgName){
		this.accName=accName;
		this.accNo=accNo;
		this.bankName=bankName;
		this.orgName=orgName;
	}
	public void display() {
		Account account = new Account();
		account.display();
		System.out.println(this.orgName);
	}
}
class CurrentAccount extends Account{
	String tinNumber;
	CurrentAccount(String accName,String accNo,String bankName,String tinNumber){
		this.accName=accName;
		this.accNo=accNo;
		this.bankName=bankName;
		this.tinNumber=tinNumber;
	}
	public void display() {
		Account account = new Account();
		account.display();
		System.out.println(this.tinNumber);
	}
}

