package Javatraining;
import java.util.Scanner;
public class AdvnIGST {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		scanner.nextLine();
		String n = scanner.nextLine();
		String d = scanner.nextLine();
		String t = scanner.nextLine();
		String o = scanner.nextLine();
		double c = scanner.nextFloat();
		if(a==1) {
			int s = scanner.nextInt();
			scanner.nextLine();
			String[] d1 = scanner.nextLine().split("/");
			String[] d2 = scanner.nextLine().split("/");
			Exhibition2 e = new Exhibition2(n,d,t,o,c,s);
			System.out.println((e.calcGST(Integer.parseInt(d1[0]),Integer.parseInt(d2[0]),c)));
		}
		else if(a==2) {
			int s = scanner.nextInt();
			scanner.nextLine();
			String[] d1 = scanner.nextLine().split("/");
			String[] d2 = scanner.nextLine().split("/");
			StageEvent2 e = new StageEvent2(n,d,t,o,c,s);
			System.out.println((e.calcGST(Integer.parseInt(d1[0]),Integer.parseInt(d2[0]),c)));
		}
		else System.out.println("Invalid input");
	}
}
class Event2{
	private String name,detail,type,ownerName;
	double costPerDay;
	Event2(String name,String detail,String type,String ownerName,double costPerDay){
		this.name=name;
		this.detail=detail;
		this.type=type;
		this.ownerName=ownerName;
		this.costPerDay=costPerDay;
	}
}
class Exhibition2 extends Event2{
	static private int noOfStalls;
	Exhibition2(String name,String detail, String type, String ownerName,double costPerDay,int noOfStalls) {
		super(name,detail, type,ownerName,costPerDay);
		this.noOfStalls=noOfStalls;
	}
	double calcGST(int startDate,int endDate,double costPerDay) {
		int days=endDate-startDate;
		double res=(costPerDay*15/100*days)/3;
		return Math.round(res*10)/(double)10;
	}
}
class StageEvent2 extends Event2{
	static private int noOfSeats;
	StageEvent2(String name,String detail, String type, String ownerName,double costPerDay,int noOfSeats) {
		super(name,detail, type,ownerName,costPerDay);
		this.noOfSeats=noOfSeats;
	}
	double calcGST(int startDate,int endDate,double costPerDay) {
		int days=endDate-startDate;
		double res=(double)(costPerDay*0.05*days/3);
		return res;
	}
}