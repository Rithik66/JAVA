import java.util.ArrayList;
import java.util.Scanner;

public class Railway{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> u= new ArrayList<>();
    static ArrayList<Booked> bo = new ArrayList<>();
    static int indexU,t=1;
    static int[][] seats = new int[10][7];
    static int[][] waitList = new int[5][7];
    static String[] r = {"COIMBATORE","TIRUPUR","ERODE","SALEM","KATPADI","PERAMBUR","CHENNAI"};
    public static void main(String[] args) {
        home();
    }
    public static void home(){
        System.out.println("Welcome to IRCTC !!\n");
        System.out.println("1. UserLogin");
        System.out.println("2. UserSignUp");
        System.out.println("3. Check route");
        System.out.println("4. Check seats");
        System.out.println("5. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:
            uL();
            break;
            case 2:
            uS();
            break;
            case 3:
            cR();
            break;
            case 4:
            cS();
            break;
        }
    }
    public static void cR(){
        System.out.print(r[0]);
        for(int i=1;i<r.length;i++){
            System.out.print(" ---> "+r[i]);        
        }
        System.out.println();
        scanner.nextLine();
        enter();
        clear();
        home();
    }
    public static void cS(){
        for(int i=0;i<10;i++){
            for(int j=0;j<7;j++){
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<5;i++){
            for(int j=0;j<7;j++){
                System.out.print(waitList[i][j]);
            }
            System.out.println();
        }
        scanner.nextLine();
        enter();
        clear();
        home();
    }
    public static void uS() {
        System.out.println("--------SignUp Portal--------\n");
        System.out.print("Enter userName : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.print("Enter passWord : ");
        String pass=scanner.nextLine();
        System.out.print("ReEnter passWord : ");
        String repass = scanner.nextLine();
        clear();
        if(repass.equals(pass)){
            u.add(new User(name,pass,"","",0,new ArrayList<>()));
            System.out.println("New Account was created sucessfully\n");
        }
        else{
            System.out.println("password does not match\n");
        }
        home();
    }
    public static boolean checkUser(String name,String pass){
        for (int i=0;i<u.size();i++) {
            if(u.get(i).name.equals(name) && u.get(i).pass.equals(pass)){
                indexU=i;
                return true;
            }
        }
        return false;
    }
    public static void uL() {
        System.out.println("--------LogIn Portal--------\n");
        System.out.print("Enter userName : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.print("Enter passWord : ");
        String pass=scanner.nextLine();
        clear();
        if(checkUser(name,pass)){
            System.out.println("Logged in successFully\n");
            trueUser();
        }
        else{
            System.out.println("Invalid login details\n");
            home();
        }
    }
    public static void trueUser() {
        System.out.println("Welcome "+u.get(indexU).name+"\n");
        System.out.println("1. Book Tickets");
        System.out.println("2. Cancel Tickets");
        System.out.println("3. ViewMyTickets");
        System.out.println("4. Check Availabilty");
        System.out.println("5. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:
            bookT();
            break;
            case 2:
            canT();
            break;
            case 3:
            viewT();
            break;
            case 4:
            checkAvai();
            break;
            case 5:
            home();
            break;
        }
    }
    public static void bookT() {
        System.out.println("1. COIMBATORE\n2. TIRUPUR\n3. ERODE\n4. SALEM\n5. KATPADI\n6. PERAMBUR\n7. CHENNAI");
        System.out.println("Enter Boarding point(For example 1 for Coimbatore) : ");
        int a = scanner.nextInt();//1
        System.out.println("Enter departure point : ");
        int b=scanner.nextInt();//5
        System.out.println();
        if(b<a) System.out.println("invalid information");
        else{
            u.get(indexU).boarding=r[a-1];//r[1-1(0)]
            u.get(indexU).departure=r[b-1];//r[5-1(4)]
            checkB(a-1,b-1);
        }
        System.out.println();
        scanner.nextLine();
        enter();
        clear();
        trueUser();
    }
    public static void checkB(int s,int e){
        int check=0;
        for(int i=0;i<10;i++){
            int sum=0;
            for(int j=s;j<=e;j++){
                sum+=seats[i][j];
            }
            if(sum==0){
                for(int j=s;j<=e;j++){
                    seats[i][j]=1;               //(0)  1111000    (1)  0000000
                }
                check=1;
            }
            if(check==1){
                u.get(indexU).seat=(i+1);
                u.get(indexU).booked.add(new Booked(u.get(indexU).name, u.get(indexU).pass,u.get(indexU).boarding, u.get(indexU).departure, u.get(indexU).seat,t++));
                System.out.println("Alloted Seat : "+(i+1));
                break;
            }
        }
        if(check==0){
            for(int i=0;i<5;i++){
                int sum=0;
                for(int j=s;j<=e;j++){
                    sum+=waitList[i][j];
                }
                if(sum==0){
                    for(int j=s;j<=e;j++){         //(0) 0011111   (11)
                        waitList[i][j]=1;
                    }
                    check=2;
                }
                if(check==2){
                    u.get(indexU).seat=(i+1)+10;
                    u.get(indexU).booked.add(new Booked(u.get(indexU).name, u.get(indexU).pass,
                    u.get(indexU).boarding, u.get(indexU).departure, u.get(indexU).seat,t++));
                    System.out.print("Added to waiting List "+(i+1));
                    break;
                }
            }
        }
        if(check==0){
            System.out.print("Sorry No seats available");
        }
    }
    public static void canT(){
        System.out.println("------");
        for(int i=0;i<u.get(indexU).booked.size();i++){
            System.out.println("Ticket no : "+(i+1));
            System.out.println("Boarding point : "+u.get(indexU).booked.get(i).boarding);
            System.out.println("departure point : "+u.get(indexU).booked.get(i).departure);
            System.out.println("seat ---> "+u.get(indexU).booked.get(i).seat+"\n------");
        }
        System.out.print("\nEnter the Ticket number to cancel : ");
        int a = scanner.nextInt();
        int s=0,e=0,ticn=0;
        for (int i=0;i<u.get(indexU).booked.size();i++) {
            if((i+1)==a){
                s=indexOf(u.get(indexU).booked.get(i).boarding);
                e=indexOf(u.get(indexU).booked.get(i).departure);
                a=u.get(indexU).booked.get(i).seat;
                u.get(indexU).booked.remove(i);
                ticn=i;
                break;
            }
        }
        remS(a-1,s,e);
        movW(a-1,s,e,ticn);
        trueUser();
    }
    public static void movW(int a,int s,int e,int ticn){
        int i1=a,i2=0,count=0,maxC=0,maxS=0,maxE=0,st=0;
        for(int j=0;j<7;j++){
            if(seats[i1][j]==1){
                if(count>maxC){
                    maxC=count;
                    if(j-1>maxE)maxE=j-1;
                    maxS=st;
                }
                count=0;
            }
            else if(seats[i1][j]==0){
                if(count==0)
                st=j;
                count++;
            }
        }
        label1:for(int i=0;i<u.size();i++){
            for(int j=0;j<u.get(i).booked.size();j++){
                if(u.get(i).booked.get(j).seat>10 ){
                    String cs=r[maxS],ce=r[maxE];
                    if(u.get(i).booked.get(j).boarding.equals(cs) && u.get(i).booked.get(j).departure.equals(ce)){
                        for(int k=maxS;k<=maxE;k++){
                            seats[a][k]=waitList[u.get(i).booked.get(j).seat-11][k];
                            waitList[u.get(i).booked.get(j).seat-11][k]=0;
                        }
                        i2=u.get(i).booked.get(j).seat-11;
                        u.get(i).booked.get(j).seat=+1;
                        break label1;
                    }
                }
            }
        }
    }
    public static void remS(int a,int s,int e){
        int i=a;
        for(int j=s;j<=e;j++){
            seats[i][j]=0;
        }
    }
    public static int indexOf(String s){
        for(int i=0;i<r.length;i++){
            if(r[i].equals(s)) return i;
        }
        return 0;
    }
    public static void viewT() {
        System.out.println("Name : "+u.get(indexU).name);
        System.out.println("------");
        for(int i=0;i<u.get(indexU).booked.size();i++){
            System.out.println("Ticket no : "+u.get(indexU).booked.get(i).tic);
            System.out.println("Boarding point : "+u.get(indexU).booked.get(i).boarding);
            System.out.println("departure point : "+u.get(indexU).booked.get(i).departure);
            System.out.println("seat ---> "+u.get(indexU).booked.get(i).seat+"\n------");
        }
        scanner.nextLine();
        System.out.println();
        enter();
        clear();
        trueUser();
    }
    public static void checkAvai(){
        System.out.println("Enter the Boarding point : ");
        int a = scanner.nextInt();
        System.out.println("Enter the Departure point");
        int b = scanner.nextInt();
        int check=0;
        System.out.print("\n Available seats ---> ");
        for(int i=0;i<10;i++){
            int sum=0;
            for(int j=a;j<=b;j++){
                sum+=seats[i][j];
            }
            if(sum==0){
                check=1;
                System.out.print((i+1)+" ");
            }
        }
        if(check==0) System.out.println("No seats are available");
        scanner.nextLine();
        enter();
        clear();
        trueUser();
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void enter(){
        System.out.println("Press ENTER to continue");
        String s = scanner.nextLine();
        s+=s;
    }
}
class Booked{
    String name,pass,boarding,departure;
    int seat,tic;
    Booked(String name,String pass,String boarding,String departure,int seat,int tic){
        this.name=name;
        this.pass=pass;
        this.boarding=boarding;
        this.departure=departure;
        this.seat=seat;
        this.tic=tic;
    }
}
class User{
    String name,pass,boarding,departure;
    int seat;
    ArrayList<Booked> booked;
    User(String name,String pass,String boarding,String departure,int seat,ArrayList<Booked> booked){
        this.name=name;
        this.pass=pass;
        this.boarding=boarding;
        this.departure=departure;
        this.seat=seat;
        this.booked=new ArrayList<>(booked);
    }
}