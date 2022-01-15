import java.util.ArrayList;
import java.util.Scanner;

public class Splitwise {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Friends> friends = new ArrayList<>();
    static int indexF;
    public static void main(String[]args){
        frnds();
        home();
    }
    public static void home() {
        System.out.println("Enter your name ");
        String name = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if(checkFriend(name,password)){
            System.out.println("Logged in successfully");
            trueLogin();
        }
        else{
            System.out.println("Invalid credentials");
            home();
         }
    }
    public static boolean checkFriend(String name,String password){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).name.equals(name) && friends.get(i).password.equals(password)){
                indexF=i;
                return true;
            }
        }
        return false;
    }
    public static void trueLogin() {
        System.out.println("1. Add Expense");
        System.out.println("2. Add new Friend");
        System.out.println("3. Amount to be payed");
        System.out.println("3. Amount to be recieved");
        int a = scanner.nextInt();
        switch(a){
            case 1:addExpense();break;
            case 2:addFriend();break;
            case 3:amountToPay();break;
            case 4:amountToRecieve();break;
            case 5:System.exit(1);
        }
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void enter() {
        System.out.println("Press ENTER to continue");
        String s = scanner.nextLine();
        s+=s;
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