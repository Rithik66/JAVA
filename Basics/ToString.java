package Javatraining;

import java.util.Scanner;

public class ToString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Client[] cl = new Client[n];
		Country1[] cnt = new Country1[n];
		for(int i=0;i<n;i++) {
			cl[i]=new Client();
			cl[i].setClientId(scanner.nextInt());
			scanner.nextLine();
			cl[i].setClientName(scanner.nextLine());
			cl[i].setPhoneNumber(scanner.nextLine());
			cl[i].setEmail(scanner.nextLine());
			cl[i].setPassport(scanner.nextLine());
			cnt[i]=new Country1();
			cnt[i].setIATACountryCode(scanner.nextLine());
			cnt[i].setCountryName(scanner.nextLine());
		}
		System.out.printf("\n%-25s %-25s %-25s %-25s %-25s %-25s %s","clientId","clientName","phoneNumber","email","passport","iataCountryCode","countryname");
		int count=0;
		label:for(int i=0;i<100;i++) {
			int j = scanner.nextInt();
			ClientBO bo = new ClientBO();
			String b;
			if(j==3) {
				if(count==0) {
					bo.viewDetails(cl,cnt);
				}
				break label;
			}
			else if(j==2) {
				count++;
				scanner.nextLine();
				b=scanner.nextLine();
				bo.printClientDetails(cl,cnt,b);
			}
		}
	}
}
class Client{
	private int clientId;
	private String clientName,phoneNumber,email,passport;
	private Country1 country;
	void setClientId(int ci) {
		clientId=ci;
	}
	void setClientName(String cn) {
		clientName=cn;
	}
	void setPhoneNumber(String pn) {
		phoneNumber=pn;
	}
	void setEmail(String e) {
		email=e;
	}
	void setPassport(String p) {
		passport=p;
	}
	String getCountryName() {
		return country.getCountryName();
	}
	public String toString() {
		System.out.printf("%-25d %-25s %-25s %-25s %-25s",clientId,clientName,phoneNumber,email,passport);
		return "";
	}
}
class Country1{
	private String iataCountryCode,countryname;
	void setIATACountryCode(String icc) {
		this.iataCountryCode=icc;
	}
	void setCountryName(String cnm) {
		this.countryname=cnm;
	}
	String getCountryName() {
		return countryname;
	}
	public String toString() {
		System.out.printf(" %-25s %s\n",iataCountryCode,countryname);
		return "";
	}
}
class ClientBO{
	void viewDetails(Client[] clientList,Country1[] cnt) {
		for(int i=0;i<clientList.length;i++) {
		System.out.print(clientList[i]);
		System.out.print(cnt[i]);
		}
	}
	void printClientDetails(Client[] clientList,Country1[] cnt,String countryName) {
		for(int i=0;i<clientList.length;i++)
			if(cnt[i].getCountryName().equals(countryName)){
			System.out.print(clientList[i]);
			System.out.print(cnt[i]);
			}
	}
}