package Javatraining;

import java.util.Scanner;

abstract class FundTransfer{
    String accountNumber;
    double balance;
    FundTransfer(String accountNumber,double balance){
    	this.accountNumber=accountNumber;
    	this.balance=balance;
    }
    boolean validate(Double transfer){
		if(this.accountNumber.length()==10 && transfer>0 && transfer<balance) return true;
		return false;
    }
    abstract boolean transfer(Double transfer);
}

class NEFTTransfer extends FundTransfer{
    NEFTTransfer(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	boolean transfer(Double transfer){
    	if(transfer+(transfer*0.02)<balance) {
    		balance=balance-((transfer*0.02)+transfer);
   			return true;
   		}
    	return false;
    }
}
class IMPSTransfer extends FundTransfer{
    IMPSTransfer(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	boolean transfer(Double transfer){
    	if(transfer>10000) {
    		balance=balance-transfer;
   			return true;
   		}
    	return false;
    }
}
class RTGSTransfer extends FundTransfer{
    RTGSTransfer(String accountNumber, double balance) {
		super(accountNumber, balance);
	}
	boolean transfer(Double transfer){
    	if(transfer+(transfer*0.05)<balance) {
    		balance=balance-((transfer*0.05)+transfer);
   			return true;
   		}
    	return false;
    }
}
public class AdvnAbsFundTransfer{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		String ac = scanner.next();
		Double b=scanner.nextDouble();
		Double tran=scanner.nextDouble();
		FundTransfer ft=null;
		if(t==2) {
			ft=new NEFTTransfer(ac, b);
		}
		else if(t==3) {
			ft=new IMPSTransfer(ac, b);
		}
		else if(t==1) {
			ft=new RTGSTransfer(ac, b);
		}
		if(ft.validate(tran)){
			if(ft.transfer(tran)) {
				System.out.println("Transfer occured successfully");
				System.out.println(ft.balance);
			}
			else System.out.println("Transfer could not be made");
		}
		else System.out.println("Account number or transfer seems to be wrong");
	}
}
