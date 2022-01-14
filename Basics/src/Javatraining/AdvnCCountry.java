package Javatraining;
import java.util.Scanner;
public class AdvnCCountry {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String n=scanner.nextLine();
		String cc=scanner.nextLine();
		String isd=scanner.nextLine();
		Country obj = new Country(n,cc,isd);
		obj.set();
	}
}
class Country {
	String name,countryCode,isdCode;
	Country(String name,String countryCode,String isdCode){
		this.name=name;
		this.countryCode=countryCode;
		this.isdCode=isdCode;
	}
	void set() {
		System.out.println("Country Name : "+name);
		System.out.println("Country Code : "+countryCode);
		System.out.println("ISD Code : "+isdCode);
	}
}