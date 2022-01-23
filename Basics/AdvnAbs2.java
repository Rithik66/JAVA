package Javatraining;
import java.util.Scanner;
interface Engine{
void changeGear(int a);
void speedUp(int a);
}
class Vehicle implements Engine{
int speed,gear;
public void changeGear(int a){
   System.out.println("gear"+a);
}
public void speedUp(int a){
   System.out.println("speed"+a);
}
}
public class AdvnAbs2{
public static void main(String[]args){
   Scanner scanner = new Scanner(System.in);
   int a = scanner.nextInt();
   int b = scanner.nextInt();
   Engine e = new Vehicle();
   e.changeGear(a);
   e.speedUp(b);
}
}

