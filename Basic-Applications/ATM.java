/*
Design and Develop a Monolith Console based ATM Application by understanding various use 
cases from the Customer/User and Administrator point of view. You are allowed to 
improvise and add more real-time use relevant cases to each task if possible. 
------------------------------------------------------------------------------------------
Module A : Authentication and Welcome menu 
------------------------------------------------------------------------------------------

    Application must authenticate both Borrower and Administrator taking UserID and pin 
    and display a welcome menu based on their role. 
    
------------------------------------------------------------------------------------------
Module B : Administrator Login
------------------------------------------------------------------------------------------

    1.Update Amount in ATM -> Update must be checked against maximum threshold value of 
    each denomination. Allowed denominations are 2000,500,200,100.
    
------------------------------------------------------------------------------------------
Module C : Customer Login
------------------------------------------------------------------------------------------

    1.Withdraw Amount ( Amount withdrawal based on availability on ATM Machine.)
    2.Check Balance ( Reflect the account balance.)
    3.Pin change
    4.Download Mini statement (minimum 6 transactions)
    5.Direct Deposit
    6.Amount Transfer
    
------------------------------------------------------------------------------------------

*/


import java.util.Scanner;
public class ATM{
    static Scanner scanner = new Scanner(System.in);
    static int a,index;
    static double ab;
    static int arr[] = {0,0,0,0};
    static UserDetails u[] = new UserDetails[6];
    static String state = "Process\t\tAmount\t\tBalance\n";
    static String ATMBank = "RBI";
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        createUser();
        home();
    }
    public static void home(){
        System.out.println("\tATM MACHINE");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit");
        System.out.print("\nEnter Choice : ");
        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        switch(a){
            case 1:{
                admin();
                break;
            }
            case 2:{
                user();
                break;
            }
            case 3:{
                System.out.println("Thank You For Choosing Our BANK !!!");
                break;
            }
            default:{
                home();
                break;
            }
        }
    }
    public static void admin(){
        System.out.println("\t\tAdmin Login Credentials\n");
        System.out.print("Enter UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter PassWord : ");
        int pass = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if((name.equals("admin") && pass==12345) || (name.equals("manager") && pass==54321)) trueAdmin();
        else{
            System.out.println("Please Check Your Login Credentials");
            home();
        }
    }
    public static void trueAdmin(){
        System.out.println("Welcome Admin !!!\n");
        System.out.println("1. Add Money");
        System.out.println("2. Show Amount");
        System.out.println("3. Show ATM Balance");
        System.out.println("4. Exit");
        System.out.print("\nEnter Choice : ");
        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(a>4 || a<1){
            System.out.println("Enter the choice correctly :( ");
            trueAdmin();
        }
        else if(a==1) add();
        else if(a==2) showA();
        else if(a==3) showM();
        else home();
    }
    public static void add(){
        System.out.println("Enter the Number of Notes \n");
        System.out.println("100 : ");
        arr[0]+=scanner.nextInt();
        System.out.println("200 : ");
        arr[1]+=scanner.nextInt();
        System.out.println("500 : ");
        arr[2]+=scanner.nextInt();
        System.out.println("2000 : ");
        arr[3]+=scanner.nextInt();
        atmbalance();
        System.out.println("Money Added SuccessFully\n");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static void showA(){
        System.out.println("Number of Denominations : ");
        System.out.println("100 --> "+arr[0]);
        System.out.println("200 --> "+arr[1]);
        System.out.println("500 --> "+arr[2]);
        System.out.println("2000 --> "+arr[3]);
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static void showM(){
        System.out.println("Amount in ATM : "+ab);
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueAdmin();
    }
    public static void atmbalance(){
        ab=(100*arr[0])+(200*arr[1])+(500*arr[2])+(2000*arr[3]);
    }
    public static void user(){
        System.out.println("User Login Credentials\n");
        System.out.print("Enter UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Enter PassWord : ");
        int pass = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(check(u,name,pass) && u[index].count<=3) {
            trueUser();
        }
        else{
            u[index].count++;
            System.out.println("Please Check Your Login Credentials");
            if(u[index].count>3){
                System.out.println("Too many pin attempt....account locked....please visit near by Bank");
                System.out.println("Press ENTER to Continue");
                scanner.nextLine();
                String s = scanner.nextLine();
                home();
            }else {
                home();
            }
        }
    }
    public static boolean check(UserDetails[] u,String name,int pass){
        int i=0;
        for(i=0;i<u.length;i++){
            if(u[i].name.equals(name) &&  u[i].pass==pass){
                index=i;
                return true;
            }
        }
        return false;
    }
    public static void trueUser(){
        System.out.println("Welcome "+u[index].name+"\n");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Change pin");
        System.out.println("5. Transaction");
        System.out.println("6. Mini Statement");
        System.out.println("7. Exit");
        System.out.print("\nEnter Choice : ");

        a = scanner.nextInt();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        if(a>7 || a<1){
            System.out.println("Enter the choice correctly :( ");
            trueUser();
        }
        else if(a==1) withdraw();
        else if(a==2) deposit();
        else if(a==3) balance();
        else if(a==4) changePin();
        else if(a==5) transaction();
        else if(a==6) miniStatement();
        else home();
    }
    public static void withdraw() {
        System.out.println("Enter the amount to withdraw : ");
        int a = scanner.nextInt();
        if(a%100>9){
            System.out.println("Please follow the Denomination --> 2000  500  200  100 ");
        } 
        else if(a>u[index].balance) System.out.println("Amount exceeds Account balance");
        else if(a>ab){
            System.out.println("Amount exeeds ATM cash Availability");
        }
        else{
            ab-=a;
            if(!ATMBank.equals(u[index].bank)) {
                u[index].penalty++;
                if(u[index].penalty>5)
                u[index].balance-=20;
            }
            int tt=0,fh=0,th=0,h=0;
            int t=a,temp=0,check=0;
            temp=t/2000;
            if(temp<=arr[3]){
                t=t%2000;
                tt=temp;
                check+=(2000*temp);
            }
            else{
                tt=arr[3];
                check+=(2000*arr[3]);
                int r = temp-arr[3];
                t=(r*2000)+(t%2000);
            }
            temp=t/500;
            if(temp<=arr[2]){
                t=t%500;
                fh=temp;
                check+=(500*temp);
            }
            else{
                fh=arr[2];
                check+=(500*arr[2]);
                int r = temp-arr[2];
                t=(r*500)+(t%500);
            }
            temp=t/200;
            if(temp<=arr[1]){
                t=t%200;
                th=temp;
                check+=(200*temp);
            }
            else{
                th=arr[1];
                check+=(200*arr[1]);
                int r = temp-arr[1];
                t=(r*200)+(t%200);
            }
            temp=t/100;
            if(temp<=arr[0]){
                t=t%100;
                h=temp;
                check+=(100*temp);
            }
            else{
                h=arr[0];
                check+=(100*arr[0]);
                int r = temp-arr[0];
                t=(r*100)+(t%100);
            }
            if(check<a){
                 System.out.println("Sorry for incovineance");
                 System.out.println("Withdraw UnSuccessfull\n");
            }
            else{
                System.out.println("2000 : "+tt);
                arr[3]-=tt;
                System.out.println("500 : "+fh);
                arr[2]-=fh;
                System.out.println("200 : "+th);
                arr[1]-=th;
                System.out.println("100 : "+h);
                arr[0]-=h;
                u[index].balance-=a;
                u[index].state+="WithDraw\t"+a+"\t\t"+u[index].balance+"\n";
                System.out.println("Withdraw Successfull\n");
            }
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void deposit() {
        System.out.println("Enter the Denomination to deposit : ");
        System.out.println("Enter Number of 100s : ");
        int a = scanner.nextInt();
        arr[0]+=a;
        ab+=(a*100);
        u[index].balance+=(a*100);
        System.out.println("Enter Number of 200s : ");
        int b = scanner.nextInt();
        arr[1]+=b;
        ab+=(b*200);
        u[index].balance+=(b*200);
        System.out.println("Enter Number of 500s : ");
        int c = scanner.nextInt();
        arr[2]+=c;
        ab+=(c*500);
        u[index].balance+=(c*500);
        System.out.println("Enter Number of 2000s : ");
        int d = scanner.nextInt();
        arr[3]+=d;
        ab+=(d*2000);
        u[index].balance+=(d*2000);
        System.out.println("Deposit Sucessfull\n");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        int k=(a*100)+(b*200)+(c*500)+(d*2000);
        u[index].state+="Deposit\t\t"+k+"\t\t"+u[index].balance+"\n";
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void balance() {
        System.out.println("The balance in your Account : "+u[index].balance+"\n");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void changePin() {
        int c=0;
        System.out.println("Enter your old Pin : ");
        int a = scanner.nextInt();
        if(u[index].pass==a){
            System.out.println("Enter your new Pin : ");
            int b = scanner.nextInt();
            u[index].pass=b;
            c=1;
        }
        else {
            System.out.println("Pin is wrong");
        }
        if(c==1) System.out.println("Pin Change Sucessfull");
        else System.out.println("Pin Change Failed");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void transaction() {
        System.out.println("IFSC : ");
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println("Account no : ");
        String s1 = scanner.nextLine();
        System.out.println("Enter the amount to transfer : ");
        Double d = scanner.nextDouble();
        if(u[index].ifsc.equals(s) && u[index].acc.equals(s1)){
            System.out.println("Cant transfer money to same account");
        }
        else{
            tranTo(s,s1,d);
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void tranTo(String s,String s1,double d){
        int j=findAccount(u,s1);
        if(j>=0){
            u[index].balance-=d;
            u[j].balance+=d;
            System.out.println("Transaction Successfull");
            u[index].state+="Debited\t\t"+d+"\t\t"+u[index].balance+"\t\tTo Account : "+u[j].acc+"\n";
            u[j].state+="Credited\t"+d+"\t\t"+u[j].balance+"\t\tFrom Account : "+u[index].acc+"\n";
        }
        else System.out.println("Transaction Failed due to wrong account number");
    }
    public static int findAccount(UserDetails[] u,String s){
        int i=0;
        for(i=0;i<u.length;i++){
            if(u[i].acc.equals(s)) return i;
        }
        return -1;
    }
    public static void miniStatement(){
        System.out.println(state);
        String ar[] = u[index].state.split("\n");
        if(ar.length>6){
            int i=ar.length-6;
            for(;i<ar.length;i++){
                System.out.println(ar[i]);
            }
        }
        else{
        System.out.println(u[index].state);
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        trueUser();
    }
    public static void createUser() {
        u[0]=new UserDetails("rithik", 1234, 12000.00,"ra123","1234567","","RBI",0,0);
        u[1]=new UserDetails("raghul", 4321, 15000.00,"ra123","1234565","","RBI",0,0);
        u[2]=new UserDetails("survesh", 1423, 14500.00,"rb123","1234563","","SBI",0,0);
        u[3]=new UserDetails("vishnu", 3241, 11500.00,"rb123","1234561","","SBI",0,0);
        u[4]=new UserDetails("naresh", 2314, 15700.00,"ra123","1234569","","RBI",0,0);
        u[5]=new UserDetails("moune", 2413, 18000.00,"ra123","1234560","","RBI",0,0);
    }
}
class UserDetails{
    String name,ifsc,acc,state,bank;
    int pass,count,penalty;
    double balance;
    UserDetails(String name,int pass,double balance,String ifsc,String acc,String state,String bank,int count,int penalty){
        this.balance=balance;
        this.name=name;
        this.pass=pass;
        this.ifsc=ifsc;
        this.acc=acc;
        this.state=state;
        this.bank=bank;
        this.count=count;
        this.penalty=penalty;
    }
}
