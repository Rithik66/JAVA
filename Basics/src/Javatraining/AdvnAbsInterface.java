package Javatraining;
import java.util.Scanner;
interface Stall{
    abstract void display();
}
class GoldStal implements Stall{
    String stallName,ownerName;
    int cost,tvSet;
    GoldStal(String stallName,int cost,String ownerName,int tvSet){
        this.stallName=stallName;
        this.cost=cost;
        this.ownerName=ownerName;
        this.tvSet=tvSet;
    }
    public void display(){
        System.out.println(stallName+" "+cost+" "+ownerName+" "+tvSet);
    }
}
class PremiumStall implements Stall{
    String stallName,ownerName;
    int cost,projector;
    PremiumStall(String stallName,int cost,String ownerName,int projector){
        this.stallName=stallName;
        this.cost=cost;
        this.ownerName=ownerName;
        this.projector=projector;
    }
    public void display(){
        System.out.println(stallName+" "+cost+" "+ownerName+" "+projector);
    }
}
class ExecutiveStall implements Stall{
    String stallName,ownerName;
    int cost,screen;
    ExecutiveStall(String stallName,int cost,String ownerName,int screen){
        this.stallName=stallName;
        this.cost=cost;
        this.ownerName = ownerName;
        this.screen=screen;
    }
    public void display(){
        System.out.println(stallName+" "+cost+" "+ownerName+" "+screen);
    }
}
class AdvnAbsInterface{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String s = scanner.next();
        int a1 = scanner.nextInt();
        String s1 = scanner.next();
        int a2 = scanner.nextInt();
        Stall st=null;
        if(a==1) st = new GoldStal(s,a1,s1,a2);
        else if(a==2) st = new PremiumStall(s,a1,s1,a2);
        else if(a==3) st = new ExecutiveStall(s,a1,s1,a2);
        st.display();
    }
}
