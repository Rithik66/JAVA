package Javatraining;
import java.util.*;
class Employee1{
    String name,emp_id,department;
    int salary;
    Bank_details bank_details;
    Employee1(String name,String emp_id,String department,int salary){
        this.name=name;
        this.emp_id=emp_id;
        this.department=department;
        this.salary=salary;
    }
    public String toString(){
        return name+" "+emp_id+" "+department+" "+salary;
    }
}
class Bank_details{
    String bank_name,accNo,branch;
    Employee1 emp;
    Bank_details(String bank_name,String accNo,String branch){
        this.bank_name=bank_name;
        this.accNo=accNo;
        this.branch=branch;
    }
    public String toString(){
        return bank_name+" "+accNo+" "+branch;
    }
}
public class OneToOneBiDirectional {
	public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Employee1[] e = new Employee1[a];
        Bank_details[] bd = new Bank_details[a];
        for(int i=0;i<a;i++){
            e[i] = new Employee1(scanner.next(),scanner.next(),scanner.next(),scanner.nextInt());
            bd[i]= new Bank_details(scanner.next(),scanner.next(),scanner.next());
        }
        String g = scanner.next();
        int count=-1;
        for(int i=0;i<a;i++){
        	System.out.println(e[i]+" "+bd[i]);
        	if(e[i].emp_id.equals(g)) count=i;
        }
        if(count>=0) System.out.println(e[count]+" "+bd[count]);
        else System.out.println("No contact with Employee id "+g+" found");
    }
}
