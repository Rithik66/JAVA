import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalSystem {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Borrower> borrowers = new ArrayList<>();
    static int indexV,indexB;
    public static void main(String[]args){
        home();
    }
    public static void home() {
        System.out.println("Welcome to the APPLICATION");
        System.out.println("1. Admin login");
        System.out.println("2. Borrower login");
        System.out.println("3. exit");
        int a = scanner.nextInt();
        if(a==1) AdminHome();
        else if(a==2) BorrowerHome();
        else System.exit(1);
    }
    public static void adminHome() {
        scanner.nextLine();
        System.out.println("Enter your name ");
        String email = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if(name.equals("adminvrs@gmail.com") && password.equals("12345")){
            System.out.println("Logged in successfully");
            enter();
            clear();
            trueAdmin();
        }
        else{
            System.out.println("Invalid credentials");
            home();
        }
    }
    public static void trueAdmin() {
        System.out.println("1. Add a Vehicle");
        System.out.println("2. Modify a Vehicle");
        System.out.println("3. View Vehicles");
        System.out.println("4. Search Vehicle");
        System.out.println("5. Change SecurityDeposit");
        int a = scanner.nextInt();
        switch(a){
            case 1: addVehicle();break;
            case 2: modifyVehicle(); break;
            case 3: viewVehicles(); break;
            case 4: searchVehicle(); break;
            case 5: changeDeposit(); break;
            default : home();
        }
        trueAdmin();
    }
    public static void addVehicle() {
        scanner.nextLine();
        System.out.println("Name of the vehicle");
        String name=scanner.nextLine();
        System.out.println("Type of the vehicle");
        String type=scanner.nextLine();
        System.out.println("Model of the vehicle");
        String model=scanner.nextLine();
        System.out.println("PlateNumber of the vehicle");
        String platenumber=scanner.nextLine();
        System.out.println("Availablity of the vehicle");
        int avail = scanner.nextInt();
        System.out.println("Cost of the Vehicle");
        double cost = scanner.nextDouble();
        vehicles.add(new Vehicle(name,type,platenumber,model,driven,avail,cost));
        System.out.println("Vehicle added successfully");
    }
    public static void modifyVehicle() {
        scanner.nextLine();
        System.out.println("Enter the platenumber");
        String platenumber=scanner.nextLine();
        if(checkVehicle(platenumber)){
            System.out.println("1. Change Name");
            System.out.println("2. Change Type");
            System.out.println("3. Change Model");
            System.out.println("4. Change Cost");
            System.out.println("5. Change Availability");
            System.out.println("6. Delete Vehicle");
            switch(a){
                case 1:
                System.out.println("( "+vehicles.get(indexV).name+" )");
                System.out.println("Enter new Name");
                scanner.nextLine();
                String name = scanner.nextLine();
                vehicles.get(indexV).name=name;
                break;
                case 2:
                System.out.println("( "+vehicles.get(indexV).type+" )");
                System.out.println("Enter new Type");
                scanner.nextLine();
                String type = scanner.nextLine();
                vehicles.get(indexV).type=type;
                break;
                case 3:
                System.out.println("( "+vehicles.get(indexV).model+" )");
                System.out.println("Enter new Model");
                scanner.nextLine();
                String model = scanner.nextLine();
                vehicles.get(indexV).model=model;
                break;
                case 4:
                System.out.println("( "+vehicles.get(indexV).cost+" )");
                System.out.println("Enter new Cost");
                scanner.nextLine();
                String cost = scanner.nextLine();
                vehicles.get(indexV).cost=cost;
                break;
                case 5:
                System.out.println("( "+vehicles.get(indexV).avail+" )");
                System.out.println("Enter new Availability count");
                scanner.nextLine();
                int avail = scanner.nextInt();
                vehicles.get(indexV).avail=avail;
                break;
                case 6:
                vehicles.remove(indexV);
            }
        }
        else System.out.println("No vehicle found");
    }
    public static void viewVehicles() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tCost");
        for(int i=0;i<vehicles.size();i++){
            System.out.println((i+1)+"\t"+vehicles.get(i));
        }
    }
    public static boolean checkVehicle(String platenumber) {
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).platenumber.equals(platenumber)){
                indexV=i;
                return true;
            }
        }
        return false;
    }
    public static void searchVehicle(){
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Available count");
        int a = scanner.nextInt();
        switch(a){
            case 1:searchByName();break;
            case 2:searchByAvail();break;
            default: trueAdmin();
        }
    }
    public static void searchByName(){
        sort(vehicles);
        System.out.println("Enter a word or letter to search");
        scanner.nextLine();
        String w = scanner.nextLine();
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).name.contains(w)){
                System.out.println(vehicles.get(i));
            }
        }
    }
    public static void searchByAvail(){
        sort(vehicles);
        System.out.println("Enter a word or letter to search");
        int a = scanner.nextInt();
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).avail>=a){
                System.out.println(vehicles.get(i));
            }
        }
    }
    public static void sort(ArrayList<Vehicle> vehicles){
        for(int i=0;i<vehicles.size()-1;i++){
            for(int j=i+1;j<vehicles.size();j++){
                if(vehicles.get(i).name.compareTo(vehicles.get(j).name)>0){
                    Book temp = vehicles.get(i);
                    vehicles.set(i,vehicles.get(j));
                    vehicles.set(j,temp);
                }
                else if(vehicles.get(i).quantity>vehicles.get(j).quantity){
                    Book temp = vehicles.get(i);
                    vehicles.set(i,vehicles.get(j));
                    vehicles.set(j,temp);
                }
            }
        }
    }
    public static void changeDeposit() {
        
    }
    public static void borrowerHome(){
        System.out.println("1. SignIn");
        System.out.println("2. SignUp");
        System.out.println("3. Exit");
        int a = scanner.nextInt();
        if(a==1) signIn();
        else if(a==2) signUp();
        else home();
    }
    public static void signIn() {
        System.out.println("Username");
        String name = scanner.nextLine();
        System.out.println("Password");
        String pass = scanner.nextLine();
        if(checkBorrower(name,pass)) System.out.println("Login sucessfully");
        else System.out.println("Enter valid details");
        trueBorrower();
    }
    public static void signUp() {
        System.out.println("Username");
        String name = scanner.nextLine();
        System.out.println("Password");
        String pass = scanner.nextLine();
        if(checkBorrower(name,pass)) System.out.println("You already have an account");
        else{
            System.out.println("Mobile Number");
            String number = scanner.nextLine();
            borrowers.add(new Borrower(name,pass,number,borrowers.size()+1,0,30000,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
            System.out.println("Account added sucessfully");
        }
        trueBorrower();
    }
    public static boolean checkBorrower(String name,String pass) {
        for(int i=0;i<vehicles.size();i++){
            if(borrowers.get(i).name.equals(name) && borrowers.get(i).pass.equals(pass)){
                indexB=i;
                return true;
            }
        }
        return false;
    }
    public static void trueBorrower(){
        System.out.println("1. View Vehicles");
        System.out.println("2. View WishList");
        System.out.println("3. Exit");
        int a = scanner.nextInt();
        switch(a){
            case 1:{
                viewVehicles();
                System.out.println("Enter S.No to add to WishList");
                int c = scanner.nextInt();
                borrowers.get(indexB).cart.add(vehicles.get(c-1));
                break;
            }
            case 2:viewCart(); break;
            default:borrowerHome();
        }
        trueBorrower();
    }
    public static void viewCart() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tCost");
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            System.out.println((i+1)+"\t"+borrowers.get(indexB).cart.get(i));
        }
        System.out.println("1. Buy Now");
        System.out.println("2. Remove a Car");
        System.out.println("3. Go Back");
        int a = scanner.nextInt();
        if(a==1) buyNow();
        else if(a==2) remCar();
        else trueBorrower();
        viewCart();
    }
    public static void buyNow() {
        if(borrowers.get(indexB).cart.size()>1){
            System.out.println("you can rent only one vehicle at a time");
        }
        else{
            if(borrowers.get(indexB).deposit>=30000){
                borrowers.get(indexB).order.add(borrowers.get(indexB).cart.get(0));
                System.out.println("Thank you for buying");
            }
        }
    }
    public static void remCar() {
        
    }
}
class Vehicle{
    String name,type,platenumber,model;
    int avail,driven;
    double cost;
    Vehicle(String name,String type,String platenumber,String model,int avail,int driven,double cost){
        this.name=name;
        this.type=type;
        this.platenumber=platenumber;
        this.model=model;
        this.avail=avail;
        this.cost=cost;
        this.driven=driven;
    }
    public String toString(){
        return name+"\t"+type+"\t"+platenumber+"\t"+model+"\t"+avail+"\t"+cost;
    }
}
class Borrower{
    String name,pass,number;
    int Id;
    double wallet,deposit;
    ArrayList<Vehicle> cart,order;
    ArrayList<String> rents;
    Borrower(String name,String pass,String number,int Id,double wallet,double deposit,ArrayList<Vehicle> cart,ArrayList<Vehicle> order,ArrayList<String> rents){
        this.name=name;
        this.pass=pass;
        this.number=number;
        this.Id=Id;
        this.wallet=wallet;
        this.deposit=deposit;
        this.cart=new ArrayList<>(cart);
        this.order=new ArrayList<>(order);
        this.rents=new ArrayList<>(rents);
    }
}