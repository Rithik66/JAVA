package Javatraining;

import java.util.Scanner;
public class AdvnImakePayment {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] s = scanner.nextLine().split(",");
		int a = scanner.nextInt();
		scanner.nextLine();
		TicketBooking tb = new TicketBooking(s[0],s[1],Integer.parseInt(s[2]));
		if(a==1) {
			double am = scanner.nextDouble();
			tb.makePayment(am);
		}
		else if(a==2) {
			double am = scanner.nextDouble();
			String wn = scanner.nextLine();
			tb.makePayment(wn,am);
		}
		else if(a==3) {
			String n = scanner.nextLine();
			double am = scanner.nextDouble();
			scanner.nextLine();
			String ccv = scanner.nextLine();
			String c = scanner.nextLine();
			tb.makePayment(c,ccv,n,am);
		}
		else System.out.println("Invalid Choice");
	}
}
class TicketBooking{
	private String stageEvent,customer;
	private int noOfSeats;
	TicketBooking(String stageEvent,String customer,int noOfSeats){
		this.stageEvent=stageEvent;
		this.customer=customer;
		this.noOfSeats=noOfSeats;
	}
	public void makePayment(Double amount) {
		System.out.println(stageEvent+" "+customer+" "+noOfSeats+" "+amount);
	}
	public void makePayment(String walletNumber,Double amount) {
		System.out.println(stageEvent+" "+customer+" "+noOfSeats+" "+amount+" "+walletNumber);
	}
	public void makePayment(String creditCard,String ccv,String name,Double amount) {
		System.out.println(stageEvent+" "+customer+" "+noOfSeats+" "+name+" "+amount+" "+ccv+" "+creditCard);
	}
}
