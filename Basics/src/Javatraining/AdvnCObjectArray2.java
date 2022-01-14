package Javatraining;

import java.util.Scanner;
public class AdvnCObjectArray2{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        Check m1 = new Check();
        User12 m[] = new User12[a];
        for(int i=0;i<a;i++){
            m[i]=new User12(s.next(),s.next(),s.next(),s.next());
        }
        s.nextLine();
        String name = s.nextLine();
        m1.displayAll(m);
        Boolean bl=m1.deleteUser(m,name);
        if(bl) System.out.println("User deleted successfully");
        else System.out.println("No user found with the given name");
    }
}
class User12{
    String n,m,u,p;
    User12(String n,String m,String u,String p){
        this.n=n;this.m=m;this.u=u;this.p=p;
    }
}
class Check{
    public void displayAll(User12[] userArray){
        for(User12 u:userArray){
            System.out.println(u.n+" "+u.m+" "+u.u+" "+u.p);
        }
    }
    public Boolean deleteUser(User12[] userArrray,String name){
    int flag=0;
        for(User12 u:userArrray){
            if(u.n.equals(name)) flag=1;
        }
        if(flag==0) return false;
        else return true;
    }
}