package Javatraining;
import java.util.Scanner;
public class AdvnIArea {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int c=scanner.nextInt();
		if(c==1) {
			int r=scanner.nextInt();
			Circle cr = new Circle(r);
		}
		else if(c==2) {
			int l=scanner.nextInt();
			int b=scanner.nextInt();
			Rectangle r = new Rectangle(l,b);
		}
		else if(c==3) {
			int b=scanner.nextInt();
			int h=scanner.nextInt();
			Triangle t = new Triangle(b,h);
		}
		else System.out.println("Invalid Input");
	}
}
class Shape{
	 static double a;
	 public void computeArea() {
		 a=0;
	 }
}
class Circle extends Shape{
	static double r;
	Circle(double r){
		this.r=r;
		computeArea();
		System.out.printf("%.2f",a);
	}
	public void computeArea() {
		a=(double)(r*r*3.14);
	}
}
class Rectangle extends Shape{
	Rectangle(double l,double b){
		this.l=l;
		this.b=b;
		computeArea();
		System.out.printf("%.2f",a);
	}
	static double l,b;
	public void computeArea() {
		a=l*b;
	}
}
class Triangle extends Shape{
	static double bs,h;
	Triangle(double bs,double h){
		this.bs=bs;
		this.h=h;
		computeArea();
		System.out.printf("%.2f",a);
	}
	public void computeArea() {
		a=(double)0.5*bs*h;
	}
}