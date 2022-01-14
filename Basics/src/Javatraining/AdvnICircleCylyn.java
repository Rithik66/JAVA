package Javatraining;

import java.util.Scanner;

public class AdvnICircleCylyn {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		Circle12 c1 = new Circle12(a);
		Cylinder c2 = new Cylinder(a,b);
		c1.display();
		c2.display();
		System.out.printf("%.2f\n",c1.getArea());
		System.out.printf("%.2f\n",c2.getArea());
		System.out.printf("%.2f",c2.getVolume());
	}
}
class Circle12{
	int radius;
	Circle12(int radius){
		this.radius=radius;
	}
	double getArea(){
		double ans=0;
		ans=Math.PI*radius*radius;
		return ans;
	}
	void display() {
		System.out.println("Circle: radius="+(double)radius+" color=red");
	}
}
class Cylinder extends Circle12{
	int height;
	Cylinder(int radius,int height){
		super(radius);
		this.height=height;
	}
	double getArea(){
		double ans=0;
		ans=(2*Math.PI*(1.0)*(1.0))+(2*Math.PI*(1.0)*height);
		return ans;
	}
	double getVolume() {
		double ans=0;
		ans=Math.PI*(1.0)*(1.0)*height;
		return ans;
	}
	void display() {
		System.out.println("Cylinder: radius="+(double)radius+" color=red height="+(double)height);
	}
}