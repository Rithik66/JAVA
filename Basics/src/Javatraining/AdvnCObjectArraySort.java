package Javatraining;

import java.util.Scanner;

public class AdvnCObjectArraySort {
	public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        Check2 m1 = new Check2();
        User2 m[] = new User2[a];
        for(int i=0;i<a;i++){
        	s.nextLine();
        	String st1 = s.nextLine();
        	String st2 = s.nextLine();
        	String st3 = s.nextLine();
            m[i]=new User2(st1,st2,st3,s.nextInt());
        }
        m1.swap(m);
        m1.displayAll(m);
    }
}
class User2{
    String n,m,u;
    int p;
    User2(){}
    User2(String n,String m,String u,int p){
        this.n=n;this.m=m;this.u=u;this.p=p;
    }
}
class Check2{
    public void swap(User2[] userArray){
    	User2 temp = new User2();
    	for (int i = 0; i < userArray.length-1; i++) {
			for(int j=i+1;j<userArray.length;j++) {
				if(userArray[i].p < userArray[j].p){
					temp=userArray[j];
					userArray[j]=userArray[i];
					userArray[i]=temp;
				}
				else if(userArray[i].p==userArray[j].p && userArray[i].n.compareTo(userArray[j].n)>0){
					temp=userArray[j];
					userArray[j]=userArray[i];
					userArray[i]=temp;
				}
				else if(userArray[i].n.equals(userArray[j].n) && userArray[i].m.compareTo(userArray[j].m)>0){
					temp=userArray[j];
					userArray[j]=userArray[i];
					userArray[i]=temp;
				}
			}
    	}
    }
    public void displayAll(User2[] userArray){
        for(User2 u:userArray){
            System.out.println(u.n+"\n"+u.m+"\n"+u.u+"\n"+u.p);
        }
    }
}