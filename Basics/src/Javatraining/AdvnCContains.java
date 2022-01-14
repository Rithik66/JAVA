package Javatraining;

import java.util.Scanner;
public class AdvnCContains {
	 public static void main(String[]args){
	        Scanner s = new Scanner(System.in);
	        int a = s.nextInt();
	        Check1 m1 = new Check1();
	        User1 m[] = new User1[a];
	        for(int i=0;i<a;i++){
	            m[i]=new User1(s.next(),s.next());
	        }
	        s.nextLine();
	        String name = s.nextLine();
	        m1.display(m,name);
	    }
	}
	class User1{
	    String n,m;
	    User1(String n,String m){
	        this.n=n;this.m=m;
	    }
	}
	class Check1{
	    public void display(User1[] userArray,String name){
	        for(User1 u:userArray){
	        	int count=0;
	        	for(int i=0;i<name.length();i++) {
	        		if(u.n.charAt(i)==name.charAt(i)) count++;
	        	}
	        	if(count==name.length())
	            System.out.println(u.n+" "+u.m);
	        }
	    }
	}