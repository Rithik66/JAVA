package Javatraining;

import java.util.*;
class Personb{
    private String name,mobile,email,city;
    Personb(){}
    Personb(String n,String m,String e,String c){
        name=n;
        mobile=m;
        email=e;
        city=c;
    }
    public void personDisplay(){
        System.out.println(name+" "+mobile+" "+email+" "+city);
    }
}
class Employee{
    private int id,salary;
    private String dept;
    Employee(String n,String m,String e,String c,int i,String d,int s){
        Personb p = new Personb(n,m,e,c);
        id=i;
        dept=d;
        salary=s;
    }
    public void employeeDisplay(Personb p){
        p.personDisplay();
        System.out.println(id+" "+salary+" "+dept);
    }
}
class Main{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String mobile = scanner.nextLine();
        String email = scanner.nextLine();
        String city = scanner.nextLine();
        int id = scanner.nextInt();
        scanner.nextLine();
        String dept = scanner.nextLine();
        int salary = scanner.nextInt();
        Employee emp = new Employee(name,mobile,email,city,id,dept,salary);
        Personb p = new Personb();
        emp.employeeDisplay(p);
    }
}