package Javatraining;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class AdvnIAccount {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		String n = scanner.nextLine();
		int num = scanner.nextInt();
		int bal = scanner.nextInt();
		scanner.nextLine();
		String[] d1 = scanner.nextLine().split("/");
		String[] d2 = scanner.nextLine().split("/");
		if(a==1) {
			CurrentAccount2 ca = new CurrentAccount2(n,num,bal,Integer.parseInt(d1[2]));
			System.out.println(ca.calculateInterest(Integer.parseInt(d2[2])));
		}
		else {
			SavingsAccount2 ca = new SavingsAccount2(n,num,bal,Integer.parseInt(d1[2]));
			System.out.println(ca.calculateInterest(Integer.parseInt(d2[2])));
		}
	}
}
abstract class Account2{
	String name;
	int number,balance;
	int startDate;
	Account2(String name,int number,int balance,int startDate){
		this.name=name;
		this.number=number;
		this.balance=balance;
		this.startDate=startDate;
	}
	abstract double calculateInterest(int dueDate);
}
class CurrentAccount2 extends Account2{
	CurrentAccount2(String name,int number,int balance,int startDate){
		super(name,number,balance,startDate);
	}
	double calculateInterest(int dueDate) {
		int years = dueDate-startDate;
		return balance*0.12*years;
	}
}
class SavingsAccount2 extends Account2{
	SavingsAccount2(String name,int number,int balance,int startDate){
		super(name,number,balance,startDate);
	}
	double calculateInterest(int dueDate) {
		int years = dueDate-startDate;
		return balance*0.05*years;
	}
}