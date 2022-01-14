package Javatraining;
import java.util.*;
public class OneToOneRelation{
	private int id;
    private String name,dept,mobile;
    private Address address;
    OneToOneRelation(int i,String n,String d,String m,String a,String c,String s){
        id=i;
        name=n;
        dept=d;
        mobile=m;
        get();
        address=new Address(a,c,s);
    }
    void get(){
        System.out.print(id+" "+name+" "+dept+" "+mobile+" ");
    }
}
class Address{
    String addressLine1,city,state;
    int pincode;
    Address(String a,String c,String s){
        addressLine1=a;
        city=c;
        state=s;
        get();
    }
    void get(){
        System.out.print(addressLine1+" "+city+" "+state);
    }
}
class Main1{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        String dept = scanner.nextLine();
        String mobile=scanner.nextLine();
        String addressLine1 = scanner.nextLine();
        String city = scanner.nextLine();
        String state = scanner.nextLine();
        OneToOneRelation stu = new OneToOneRelation(id,name,dept,mobile,addressLine1,city,state);
    }
}
