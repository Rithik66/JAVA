package Javatraining;

import java.util.Scanner;

public class AdvnRelAirport {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		Countr[] ct = new Countr[n];
		CountryBO cb = new CountryBO();
		for(int i=0;i<n;i++) {
			String a = scanner.nextLine();
			ct[i]=cb.createCountry(a);
		}
		int m = scanner.nextInt();
		scanner.nextLine();
		Airport ap[] = new Airport[m];
		AirportBO ao = new AirportBO();
		for(int i=0;i<m;i++) {
			String b = scanner.nextLine();
			ap[i]= ao.createAirport(b, ct);
		}
		String f = scanner.nextLine();
		String a1 = scanner.nextLine();
		String a2 = scanner.nextLine();
		System.out.println(ao.findCountryName(ap, f));
		boolean check=ao.findWhetherAirportsAreInSameCountry(ap, a1, a2);
		if(check) System.out.println("are same");
		else System.out.println("Not same");
	}
}
class Countr{
	private String iataCountryCode,countryName;
	Countr(){}
	Countr(String icc,String cn){
		this.iataCountryCode=icc;
		this.countryName=cn;
	}
	String getIataCountryCode(){
		return this.iataCountryCode;
	}
	String getCountryName() {
		return this.countryName;
	}
	void setIataCountryCode(String icc){
		this.iataCountryCode=icc;
	}
	void setCountryName(String cn) {
		this.countryName=cn;
	}
}
class CountryBO{
	public Countr createCountry(String data) {
		String s[] =data.split(",");
		Countr c=new Countr(s[0],s[1]);
		return c;
	}
}
class Airport{
	private String airportName,country;
	Airport(){}
	Airport(String an,String cn){
		this.airportName=an;
		this.country=cn;
	}
	String getAirportName() {
		return this.airportName;
	}
	void setAirportName(String an) {
		this.airportName=an;
	}
	String getCountryName() {
		return this.country;
	}
	void setCountryName(String cn) {
		this.country=cn;
	}
}
class AirportBO{
	public Airport createAirport(String data,Countr[] countrylist) {
		String[] s = data.split(",");
		Airport a = new Airport(s[0],s[1]);
		return a;
	}
	public String findCountryName(Airport[] airportList,String airportName) {
		for(Airport a:airportList) {
			if(a.getAirportName().equals(airportName))
				return airportName+" belongs to "+a.getCountryName();
		}
		return "";
	}
	public boolean findWhetherAirportsAreInSameCountry(Airport[] airportList,String airportName1,String airportName2){
		String s1="",s2="";
		for(Airport a:airportList) {
			if(a.getAirportName().equals(airportName1)) s1=a.getCountryName();
		}
		for(Airport a:airportList) {
			if(a.getAirportName().equals(airportName2)) s2=a.getCountryName();
		}
		if(s1.equals(s2)) return true;
		return false;
	}
}