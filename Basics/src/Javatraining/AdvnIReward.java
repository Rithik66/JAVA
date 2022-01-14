package Javatraining;
import java.util.Scanner;
public class AdvnIReward {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String h = scanner.nextLine();
	String c = scanner.nextLine();
	String p = scanner.nextLine();
	double a = scanner.nextDouble();
	int ch = scanner.nextInt();
	if(ch==1) {
		HPVISACard hp = new HPVISACard(h,c);
		System.out.println(hp.computeRewardPoints(p, a));
	}
	else if(ch==2) {
		VISACard v = new VISACard(h,c);
		System.out.println(v.computeRewardPoints(p, a));
	}
	else {
		System.out.println("Invalid Choice");
	}
	}
}
class VISACard{
	static private String holderName,ccv;
	VISACard(String holderName,String ccv){
		this.ccv=ccv;
		this.holderName=holderName;
	}
	String getCcv() {
		return ccv;
	}
	String holderName() {
		return holderName;
	}
	public Double computeRewardPoints(String purchaseType,Double amount) {
		return amount*0.01;
	}
}
class HPVISACard extends VISACard{
	HPVISACard(String holderName,String ccv){
		super(holderName,ccv);
	}
	public Double computeRewardPoints(String purchaseType,Double amount) {
		if(purchaseType.equals("fuel"))
			return super.computeRewardPoints(purchaseType, amount)+10;
		else
			return super.computeRewardPoints(purchaseType, amount);
	}
}