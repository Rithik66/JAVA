package Javatraining;

import java.util.Scanner;

public class AdvnCConverter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Converter c = new Converter(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
		c.check();
	}
}
abstract class Conv{
	abstract void check();
}
class Converter{
	String from,to,number;
	Converter(String s,String k,String number){
		this.from=s;this.to=k;this.number=number;
	}
	void check(){
		String ans="";
		if(this.from.equals("B")) System.out.println(binary(this.number,this.to));
		else if(this.from.equals("D")) System.out.println(decimal(this.number,this.to));
		else if(this.from.equals("H")) System.out.println(hex(this.number,this.to));
		else if(this.from.equals("O")) System.out.println(octal(this.number,this.to));
	}
	static String binary(String s,String l){
		String ans="";
		if(l.equals("D")) ans=String.valueOf(Integer.parseInt(s,2));
		else if(l.equals("H")) {
			ans=String.valueOf(Integer.toHexString(Integer.parseInt(s,2)));
		}
		else if(l.equals("O")) {
			ans=String.valueOf(Integer.toOctalString(Integer.parseInt(s,2)));
		}
		return ans;
	}
	static String decimal(String s,String l) {
		String ans="";
		if(l.equals("B")) ans=Integer.toBinaryString(Integer.parseInt(s));
		else if(l.equals("H")) ans=Integer.toHexString(Integer.parseInt(s));
		else if(l.equals("O")) ans=Integer.toOctalString(Integer.parseInt(s));
		return ans;
	}
	static String hex(String s,String l) {
		String ans="";
		if(l.equals("D")) ans=String.valueOf(Integer.parseInt(s,16));
		else if(l.equals("B")) {
			ans=String.valueOf(Integer.toBinaryString(Integer.parseInt(s,16)));
		}
		else if(l.equals("O")) {
			ans=String.valueOf(Integer.toOctalString(Integer.parseInt(s,16)));
		}
		return ans;
	}
	static String octal(String s,String l) {
		String ans="";
		if(l.equals("D")) ans=String.valueOf(Integer.parseInt(s,8));
		else if(l.equals("B")) {
			ans=String.valueOf(Integer.toBinaryString(Integer.parseInt(s,8)));
		}
		else if(l.equals("H")) {
			ans=String.valueOf(Integer.toHexString(Integer.parseInt(s,8)));
		}
		return ans;
	}
}