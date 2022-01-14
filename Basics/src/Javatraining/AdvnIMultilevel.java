package Javatraining;

import java.util.Scanner;

public class AdvnIMultilevel {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int a = scanner.nextInt();
		if(a==1) {
			scanner.nextLine();
			String n = scanner.nextLine();
			String d = scanner.nextLine();
			String o = scanner.nextLine();
			int c = scanner.nextInt();
			SilverStall ss = new SilverStall(n,d,o,c);
			System.out.println(ss.getCost());
		}
		else if(a==2) {
			scanner.nextLine();
			String n = scanner.nextLine();
			String d = scanner.nextLine();
			String o = scanner.nextLine();
			int c = scanner.nextInt();
			int t = scanner.nextInt();
			GoldStall gs = new GoldStall(n,d,o,c,t);
			System.out.println(gs.getCost());
		}
		else if(a==3) {
			scanner.nextLine();
			String n = scanner.nextLine();
			String d = scanner.nextLine();
			String o = scanner.nextLine();
			int c = scanner.nextInt();
			int t = scanner.nextInt();
			int p = scanner.nextInt();
			PlatinumStall ps = new PlatinumStall(n,d,o,c,t,p);
			System.out.println(ps.getCost());
		}
		else System.out.println("Invalid Input");
	}
}
class SilverStall{
	protected String name,detail,owner;
	protected Integer cost;
	SilverStall(String name,String detail,String owner,int cost){
		this.name=name;
		this.detail=detail;
		this.owner=owner;
		this.cost=cost;
	}
	int getCost() {
		return cost;
	}
}
class GoldStall extends SilverStall{
	static private Integer tvSet;
	GoldStall(String name, String detail, String owner, int cost,int tvSet) {
		super(name, detail, owner, cost);
		this.tvSet=tvSet;
	}
	int getCost() {
		int res=cost+(tvSet*100);
		return res;
	}
	static void setTvSet(int tvSet) {
		GoldStall.tvSet=tvSet;
	}
	static int getTvSet() {
		return tvSet;
	}
}
class PlatinumStall extends SilverStall{
	private int projector;
	PlatinumStall(String name, String detail, String owner, int cost,int tvSet,int projector) {
		super(name, detail, owner, cost);
		GoldStall.setTvSet(tvSet);
		this.projector=projector;
	}
	int getCost() {
		int res=(GoldStall.getTvSet()*100)+(projector*500)+cost;
		return res;
	}
}