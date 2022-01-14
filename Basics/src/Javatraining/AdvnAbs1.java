package Javatraining;

import java.util.Scanner;

interface Notification{
	void notificationBySms();
	void notificationByEmail();
	void notificationByCourier();
}

class Icici implements Notification{
	@Override
	public void notificationBySms() {
		System.out.println("SMS");
	}
     String s="interface Notification{ void notificationBySms(); void notificationByEmail(); void notificationByCourier(); }";
 public void notificationByEmail(){
     System.out.println("Email");
 }
 public void notificationByCourier(){
     System.out.println("Courier");
 }
}
class Hdfc implements Notification{
 public void notificationBySms(){
     System.out.println("Sms");
 }
 public void notificationByEmail(){
     System.out.println("Email");
 }
 public void notificationByCourier(){
     System.out.println("Courier");
 }
}
public class AdvnAbs1{
 public static void main(String[]args){
     Scanner scanner = new Scanner(System.in);
     int a = scanner.nextInt();
     int b = scanner.nextInt();
     Notification n=null;
     if(a==1){
         n=new Icici();
         if(b==1){
             System.out.print("ICICI - Notification by ");
             n.notificationBySms();
         }
         else if(b==2){
             System.out.print("ICICI - Notification by ");
             n.notificationByEmail();
         }
         else if(b==3){
             System.out.print("ICICI - Notification by ");
             n.notificationByCourier();
         }
         else System.out.println("Invalid Input");
     }
     else if(a==2){
         n=new Hdfc();
         if(b==1){
             System.out.print("HDFC - Notification by ");
             n.notificationBySms();
         }
         else if(b==2){
             System.out.print("HDFC - Notification by ");
             n.notificationByEmail();
         }
         else if(b==3){
             System.out.print("HDFC - Notification by ");
             n.notificationByCourier();
         }
     }
     else System.out.println("Invalid Input");
 }
}
