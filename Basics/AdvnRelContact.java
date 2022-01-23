package Javatraining;
import java.util.Scanner;
public class AdvnRelContact{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Contact[] cn = new Contact[a];
        Address5[] ad = new Address5[a];
        for(int i=0;i<a;i++){
            cn[i]=new Contact(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.next());
            scanner.nextLine();
            ad[i]=new Address5(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextInt());
        }
        int f = scanner.nextInt();
        for(int i=0;i<a;i++) {
        	System.out.println(cn[i]+" "+ad[i]);
        }
        int count=0;
        for(int i=0;i<a;i++) {
        	if(cn[i].m==f || cn[i].am==f) {
        		System.out.println(cn[i]+" "+ad[i]);
        		count=1;
        		break;
        	}
        }
        if(count==0) System.out.println("No such mobile number");
    }
}
class Contact{
    int m,am,l;
    String e;
    Contact(int m,int am,int l,String e){
        this.m=m;
        this.am=am;
        this.l=l;
        this.e=e;
    }
    public String toString(){
        return this.m+" "+this.am+" "+this.l+" "+this.e;
    }
}
class Address5{
    String adl1,adl2,c,s;
    int p;
    Address5(String adl1,String adl2,String c,String s,int p){
        this.adl1=adl1;
        this.adl2=adl2;
        this.c=c;
        this.s=s;
        this.p=p;
    }
    public String toString(){
        return this.adl1+" "+this.adl2+" "+this.c+" "+this.s+" "+this.p;
    }
}