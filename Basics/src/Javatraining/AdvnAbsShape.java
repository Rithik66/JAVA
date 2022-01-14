package Javatraining;
import java.util.*;
abstract class Shap{
    public abstract double calculatePerimeter();
}
class Circle1 extends Shap{
    Float radius;
    Circle1(double radius){
    	this.radius=(float)radius;
    }
	@Override
	public double calculatePerimeter() {
		double ans = 2*3.14*radius;
        return ans;
	}
}
class Rectangle1 extends Shap{
    Float length,breadth;
    Rectangle1(double length,double breadth){
    	this.breadth=(float) breadth;
    	this.length=(float) length;
    }
    @Override
	public double calculatePerimeter() {
		double ans = 2*(length+breadth);
        return ans;
	}
}
class Square extends Shap{
    Float side;
    Square(double side){
    	this.side=(float) side;
    }
    @Override
	public double calculatePerimeter() {
		double ans = 4*side;
        return ans;
	}
}
public class AdvnAbsShape{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Shap sh = null;
        double b = scanner.nextDouble();
        if(a==1){
            sh=new Circle1(b);
        }
        else if(a==2) {
        	double l = scanner.nextDouble();
        	sh=new Rectangle1(l,b);
        }
        else if(a==3) {
        	sh=new Square(b);
        }
        System.out.printf("%.2f",sh.calculatePerimeter());
    }
}
