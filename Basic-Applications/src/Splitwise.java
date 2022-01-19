import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Splitwise {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Friends> friends = new ArrayList<>();
    static ArrayList<Integer> came = new ArrayList<>(),Gcame = new ArrayList<>();
    static Map<String,ArrayList<Integer>> group = new HashMap<>();
    static int indexF;
    public static void main(String[]args){
        frnds();
        menu();
    }
    public static void menu() {
        System.out.println("--------------------------");
        System.out.println("Welcome to the APPLICATION");
        System.out.println("--------------------------");
        System.out.println("1. login");
        System.out.println("2. Signup");
        System.out.println("3. exit");
        System.out.println("--------------------------");
        int a = scanner.nextInt();
        clear();
        if(a==1) login();
        else if(a==2) signup();
        else System.exit(1);
    }
    public static void signup() {
        System.out.println("--------------------------");
        System.out.println("Sign-Up Portal");
        System.out.println("--------------------------");
        scanner.nextLine();
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.print("Enter your password : ");
        String password = scanner.nextLine();
        System.out.print("Enter your mobile number : ");
        String number = scanner.nextLine();
        System.out.print("Enter your Email id : ");
        String email = scanner.nextLine();
        System.out.println("--------------------------");
        if(checkFriend(email,password)){
            System.out.println("You already have an account");
        }
        else{
            System.out.println("Account created sucessfully");
            friends.add(new Friends(name,password,number,email,new ArrayList<>(),0,new ArrayList<>()));
        }
        System.out.println("--------------------------");
        enter();
        clear();
        menu();
    }
    public static void login() {
        System.out.println("--------------------------");
        System.out.println("Login Portal");
        System.out.println("--------------------------");
        scanner.nextLine();
        System.out.print("Email Id : ");
        String email = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        System.out.println("--------------------------");
        if(checkFriend(email,password)){
            System.out.println("Logged in successfully");
            enter();
            clear();
            trueLogin();
        }
        else{
            System.out.println("--------------------------");
            System.out.println("Invalid credentials");
            System.out.println("--------------------------");
            enter();
            clear();
            menu();
        }
    }
    public static boolean checkFriend(String email,String password){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).email.equals(email) && friends.get(i).password.equals(password)){
                indexF=i;
                return true;
            }
        }
        return false;
    }
    public static void trueLogin() {
        System.out.println("--------------------------");
        System.out.println("Welcome "+friends.get(indexF).name);
        System.out.println("--------------------------");
        System.out.println("1. Add Expense");
        System.out.println("2. View your Expenses");
        System.out.println("3. Add new Friend");
        System.out.println("4. Amount to be payed");
        System.out.println("5. Amount to be recieved");
        System.out.println("6. Add Money to your wallet");
        System.out.println("7. View Wallet");
        System.out.println("8. Create a Group");
        System.out.println("9. Exit");
        System.out.println("--------------------------");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:addExpense();break;
            case 2:viewExpenses();break;
            case 3:addFriend();break;
            case 4:amountToPay();break;
            case 5:amountToRecieve();break;
            case 6:addMoney();break;
            case 7:viewWallet();break;
            case 8:createGroup();break;
            case 9:viewTransactions();break;
            default:menu();
        }
    }
    public static void viewTransactions() {
        System.out.println("--------------------------");
        System.out.println("Transactions");
        System.out.println("--------------------------");
        for(int i=0;i<friends.get(indexF).trans.size();i++){
            System.out.println(friends.get(indexF).trans.get(i));
        }
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
    }
    public static void createGroup() {
        System.out.println("--------------------------");
        System.out.println("Group - Create");
        System.out.println("--------------------------");
        scanner.nextLine();
        System.out.print("Enter the group name : ");
        String Gname = scanner.nextLine();
        System.out.println("Select your group members\n");
        System.out.println("-------------------------------");
        System.out.println("Name\t|Mobile\t\t|(Y/N)");
        System.out.println("-------------------------------");
        for(int i=0;i<friends.size();i++){
            if(i==indexF) continue;
            System.out.print(friends.get(i).name+"\t|"+friends.get(i).number+"\t|");
            String choice = scanner.nextLine().toUpperCase();
            if(choice.equals("Y") || choice.equals("YES")) Gcame.add(i);
        }
        ArrayList<Integer> Gc = new ArrayList<>(Gcame);
        group.put(Gname,Gc);
        Gcame.clear();
        System.out.println("--------------------------");
        enter();
        clear();
        trueLogin();
    }
    public static void addExpense() {
        System.out.println("--------------------------");
        System.out.println("1. Group");
        System.out.println("2. NonGroup");
        System.out.println("--------------------------");
        int a = scanner.nextInt();
        clear();
        if(a==2){
            came.clear();
            for(int i=0;i<friends.size();i++){
                if(i==indexF) continue;
                came.add(i);
            } 
        }
        else if(a==1){
            if(group.size()>0){
                System.out.println("--------------------------");
                System.out.println("Groups");
                System.out.println("--------------------------");
                for(String key:group.keySet()){
                    System.out.println(key);
                }
                System.out.print("Enter a group name : ");
                scanner.nextLine();
                String name = scanner.nextLine();
                came=new ArrayList<>(group.get(name));
            }
            else {
                System.out.println("Please create a group");
                trueLogin();
            }
        }
        System.out.println("Enter the reason");
        String res = scanner.nextLine();
        System.out.println("Enter the amount");
        double bill = scanner.nextDouble();
        if(bill<=friends.get(indexF).wallet){
            friends.get(indexF).wallet-=bill;
            friends.get(indexF).expenses.add(new Expense(res, bill));
            addAmountToFriends(bill,friends.get(indexF).name,friends.get(indexF).number);
        }
        else{
            System.out.println("Sorry you dont have enough money");
        }
        enter();
        clear();
        trueLogin();
    }
    public static void addAmountToFriends(double bill,String name,String number){
        double div = (bill-(bill/(came.size()+1)))/(came.size()-1);
        for(int i=0;i<came.size();i++){
            friends.get(came.get(i)).pay.add(new Pay(name,div,number));
        }
    }
    public static void viewExpenses() {
        for(int i=0;i<friends.get(indexF).expenses.size();i++){
            System.out.println(friends.get(indexF).expenses.get(i).res+"\t"+friends.get(indexF).expenses.get(i).bill);
        }
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
    }
    public static void addFriend() {
        System.out.println("Enter name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter mobile number");
        String number = scanner.nextLine();
        friends.add(new Friends(name,password,number,new ArrayList<>(),0,new ArrayList<>(),new ArrayList<>()));
        enter();
        clear();
        trueLogin();
    }
    public static void amountToPay(){
        for(int i=0;i<friends.get(indexF).pay.size();i++){
            System.out.println((i+1)+"\t"+friends.get(indexF).pay.get(i).name+"\t"+friends.get(indexF).pay.get(i).number+"\t"+friends.get(indexF).pay.get(i).amount);
        }
        System.out.println("Select a S.NO to pay (type "+(friends.get(indexF).pay.size()+1)+" to go back)");
        int a = scanner.nextInt();
        if(a>=friends.get(indexF).pay.size()+1) trueLogin();
        else{
            if(friends.get(indexF).pay.get(a-1).amount<=friends.get(indexF).wallet){
                friends.get(indexF).wallet-=friends.get(indexF).pay.get(a-1).amount;
                int ind=checkFriend2(friends.get(indexF).pay.get(a-1).name,friends.get(indexF).pay.get(a-1).number);
                friends.get(ind).wallet+=friends.get(indexF).pay.get(a-1).amount;
                friends.get(ind).trans.add("Recived\t"+friends.get(ind).name+"\t"+friends.get(ind).number+"\t"+friends.get(indexF).pay.get(a-1).amount);
                friends.get(indexF).trans.add("Recived\t"+friends.get(indexF).name+"\t"+friends.get(indexF).number+"\t"+friends.get(indexF).pay.get(a-1).amount);
                friends.get(indexF).pay.remove(a-1);
            }
            else{
                System.out.println("Insufficient money in wallet");
            }
        }
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
    }
    public static void amountToRecieve() {
        for(int i=0;i<friends.size();i++){
            if(i==indexF) continue;
            for(int j=0;j<friends.get(i).pay.size();j++){
                if(friends.get(indexF).name.equals(friends.get(i).pay.get(j).name)){
                    System.out.println(friends.get(i).name+"\t"+friends.get(i).pay.get(j).amount);
                }
            }
        }
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
    }
    public static int checkFriend2(String name,String number){
        for(int i=0;i<friends.size();i++){
            if(friends.get(i).name.equals(name) && friends.get(i).number.equals(number)){
                return i;
            }
        }
        return 0;
    }
    public static void addMoney() {
        System.out.println("Enter amount to add");
        double m = scanner.nextDouble();
        friends.get(indexF).wallet+=m;
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
    }
    public static void viewWallet() {
        System.out.println("Balance in wallet : "+friends.get(indexF).wallet);
        scanner.nextLine();
        enter();
        clear();
        trueLogin();
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
        friends.add(new Friends("rithik","1234","9489771170","abc@gmail.com",new ArrayList<>(),1200,new ArrayList<>()));
        friends.add(new Friends("raghul","4321","7824912352","acb@gmail.com",new ArrayList<>(),1500,new ArrayList<>()));
        friends.add(new Friends("vishnu","1243","6385505455","bac@gmail.com",new ArrayList<>(),1450,new ArrayList<>()));
        friends.add(new Friends("survesh","4312","9659452070","bca@gmail.com",new ArrayList<>(),1700,new ArrayList<>()));
        friends.add(new Friends("naresh","2143","9944476007","cab@gmail.com",new ArrayList<>(),1690,new ArrayList<>()));
        friends.add(new Friends("moune","3412","8903453907","cba@gmail.com",new ArrayList<>(),1470,new ArrayList<>()));
    }
}
class Friends{
    String name,number,password,email;
    double wallet;
    ArrayList<Pay> pay;
    ArrayList<Expense> expenses; 
    ArrayList<String> trans;
    Friends(String name,String password,String number,String email,ArrayList<Pay> pay,double wallet,ArrayList<Expense> expenses,ArrayList<String> trans){
        this.name=name;
        this.password=password;
        this.number=number;
        this.wallet=wallet;
        this.email=email;
        this.expenses=new ArrayList<>(expenses);
        this.pay=new ArrayList<>(pay);
    }
}
class Expense{
    String res;
    double bill;
    Expense(String res,double bill){
        this.bill=bill;
        this.res=res;
    }
}
class Pay{
    String name,number;
    double amount;
    Pay(String name,double amount,String number){
        this.name=name;
        this.amount=amount;
        this.number=number;
    }
}