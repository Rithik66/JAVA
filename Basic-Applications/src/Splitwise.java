import java.util.ArrayList;
import java.util.Scanner;

public class Splitwise {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Friends> friends = new ArrayList<>();
    public static void main(String[]args){
        frnds();
        home();
    }
    public static void home() {
        System.out.println("Enter your name ");
        String name = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        
    }
    public static void frnds() {
        friends.add(new Friends("rithik","1234","9489771170",0));
        friends.add(new Friends("raghul","4321","7824912352",0));
        friends.add(new Friends("vishnu","1243","6385505455",0));
        friends.add(new Friends("survesh","4312","9659452070",0));
        friends.add(new Friends("naresh","2143","9944476007",0));
        friends.add(new Friends("moune","3412","8903453907",0));
    }
}
class Friends{
    String name,number,password;
    double amount;
    Friends(String name,String password,String number,double amount){
        this.name=name;
        this.password=password;
        this.number=number;
        this.amount=amount;
    }
}