package Javatraining;

//import java.util.*;
//public class AdvnColRevrse  {
//	public static void main(String args[]){
//	   List<User123> arraylist = new ArrayList<User123>();
//	   arraylist.add(new User123("john", "123", "j","ja"));
//	   arraylist.add(new User123("ajme", "3123", "j","ja"));
//	   arraylist.add(new User123("james", "123123", "j","ja"));
//
//	   Collections.sort(arraylist,Collections.reverseOrder());
//
//	   for(User123 str: arraylist){
//			System.out.println(str);
//	   }
//	}
//}
//class User123 implements Comparable<Object> {
//    private String name, mobileNumber, username,password;
//
//    public User123(String name, String mobileNumber, String username,String password) {
//        this.mobileNumber = mobileNumber;
//        this.name = name;
//        this.username = username;
//        this.password=password;
//    }
//    public String getStudentName() {
//    	return this.name;
//    }
//    public int compareTo(Object comparestu) {
//        String comparename=((User123)comparestu).getStudentName();
//        return this.name.compareTo(comparename);
//    }
//    public String toString() {
//        return name+" "+mobileNumber+" "+username+" "+password;
//    }
//
//}
import java.util.*;
public class AdvnColRevrse{
	public static void main(String args[]){
	   Scanner scanner = new Scanner(System.in);
	   int a = scanner.nextInt();
	   scanner.nextLine();
	   List<Hall> arr = new ArrayList<>();
	   for(int i=0;i<a;i++){
		   String b=scanner.nextLine();
		   String c=scanner.nextLine();
		   double d = scanner.nextDouble();
		   scanner.nextLine();
		   String e=scanner.nextLine();
	       arr.add(new Hall(b,c,d,e));
	   }
	   Collections.sort(arr);
	   for(Hall h: arr){
			System.out.println(h);
	   }
	}
}
class Hall implements Comparable<Object> {
    String n,cn,on;
    double cpd;
    public Hall(String n,String cn,double cpd,String on) {
        this.n=n;
        this.cn=cn;
        this.cpd=cpd;
        this.on=on;
    }
    public int compareTo(Object o) {
    	Hall h = (Hall)o;
    	double com=compareTo(h);
        return (int) (this.cpd-com);
    }
    public double compareTo(Hall h){
        double cpd=h.cpd;
        return cpd;
    }
    public String toString() {
    	return n+" "+cn+" "+cpd+" "+on;
    }
}
//import java.util.*;
//public class AdvnColRevrse{
//	public static void main(String args[]){
//	    Scanner scanner = new Scanner(System.in);
//	    int a = scanner.nextInt();
//	   List<St> arr = new ArrayList<>();
//	   for(int i=0;i<a;i++){
//	       arr.add(new St(scanner.nextInt(),scanner.next(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
//	   }
//	   Collections.sort(arr);
//	   System.out.printf("%-20s%-20s%-20s\n","RollNo","Name","Average");
//	   for(St st: arr){
//			System.out.println(st);
//	   }
//	}
//}
//class St implements Comparable<Object> {
//    int rollno,m1,m2,m3;
//    String name;
//    double average;
//    public St(int rollno,String name,int m1,int m2,int m3) {
//        this.rollno=rollno;
//        this.name=name;
//        this.m1=m1;
//        this.m2=m2;
//        this.m3=m3;
//        this.average=this.getAverage();
//    }
//    public double getAverage() {
//    	return (this.m1+this.m2+this.m3)/3;
//    }
//    public int compareTo(Object st) {
//        double com=((St)st).getAverage();
//        return (int)(this.average-com);
//    }
//    public String toString() {
//    	System.out.printf("%-20d%-20s%-20.1f",this.rollno,this.name,this.getAverage());
//        return "";
//    }
//
//}
