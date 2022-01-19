import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalSystem{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Borrower> borrowers = new ArrayList<>();
    static int indexV,indexB,indexVO;
    public static void main(String[]args){
        home();
    }
    public static void home() {
        System.out.println("Welcome to the APPLICATION");
        System.out.println("1. Admin login");
        System.out.println("2. Borrower login");
        System.out.println("3. exit");
        int a = scanner.nextInt();
        if(a==1) adminHome();
        else if(a==2) borrowerHome();
        else System.exit(1);
    }
    public static void adminHome() {
        scanner.nextLine();
        System.out.println("Email");
        String email = scanner.nextLine();
        System.out.println("Password");
        String password = scanner.nextLine();
        if(email.equals("adminvrs@gmail.com") && password.equals("12345")){
            System.out.println("Logged in successfully");
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
        System.out.println("6. Exit");
        int a = scanner.nextInt();
        switch(a){
            case 1: addVehicle();break;
            case 2: modifyVehicle(); break;
            case 3: viewVehicles(); break;
            case 5: searchVehicle(); break;
            case 6: changeDeposit(); break;
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
        System.out.println("Rent of the Vehicle");
        double cost = scanner.nextDouble();
        vehicles.add(new Vehicle(name,type,platenumber,model,avail,0,"",cost,0));
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
            System.out.println("4. Change Rent");
            System.out.println("5. Change Availability");
            System.out.println("6. Delete Vehicle");
            int a = scanner.nextInt();
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
                double cost = scanner.nextDouble();
                vehicles.get(indexV).cost=cost;
                break;
                case 5:
                System.out.println("( "+vehicles.get(indexV).avail+" )");
                System.out.println("Enter new Availability count");
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
        System.out.println("1. All Vehicles");
        System.out.println("2. To Service");
        System.out.println("3. Sorted by Rent");
        System.out.println("4. Not Rented");
        System.out.println("5. Rented");
        System.out.println("6. Go Back");
        int a = scanner.nextInt();
        switch(a){
            case 1:viewAll();break;
            case 2:viewToService();break;
            case 3:viewSortedRent();break;
            case 4:viewNotRented();break;
            case 5:viewRented();break;
            default:trueAdmin();
        }
        viewVehicles();
    }
    public static void viewAll() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tDriven\tDamage\tCost\tTimes Rented");
        for(int i=0;i<vehicles.size();i++){
            System.out.println((i+1)+"\t"+vehicles.get(i));
        }
    }
    public static void viewToService() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tDriven\tDamage\tCost\tTimes Rented");
        for(int i=0;i<vehicles.size();i++){
            if((vehicles.get(i).driven>1500 && vehicles.get(i).type.equals("bike"))||(vehicles.get(i).driven>3000 && vehicles.get(i).type.equals("car")))
                System.out.println((i+1)+"\t"+vehicles.get(i));
        }
    }
    public static void viewSortedRent(){
        sortbyRent(vehicles);
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tDriven\tDamage\tCost\tTimes Rented");
        for(int i=0;i<vehicles.size();i++){
            System.out.println((i+1)+"\t"+vehicles.get(i));
        }
    }
    public static void sortbyRent(ArrayList<Vehicle> vehicles){
        for(int i=0;i<vehicles.size()-1;i++){
            for(int j=i+1;j<vehicles.size();j++){
                if(vehicles.get(i).cost>vehicles.get(j).cost){
                    Book temp = vehicles.get(i);
                    vehicles.set(i,vehicles.get(j));
                    vehicles.set(j,temp);
                }
            }
        }
    }
    public static void viewNotRented() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tDriven\tDamage\tCost\tTimes Rented");
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).rented==0)
            System.out.println((i+1)+"\t"+vehicles.get(i));
        }
    }
    public static void viewRented(){
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tDriven\tDamage\tCost\tTimes Rented");
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).rented>0)
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
        System.out.println("3. Search using Filter");
        int a = scanner.nextInt();
        switch(a){
            case 1:searchByName();break;
            case 2:searchByAvail();break;
            case 3:searchByFilter();break;
            default: trueAdmin();
        }
    }
    public static void searchByFilter(){
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0;i<vehicles.size();i++){
            if(!temp.contains(vehicles.get(i).type)){
                System.out.println(vehicles.get(i).type);
                temp.add(vehicles.get(i).type);
            }
        }
        System.out.println("Enter a filter");
        scanner.nextLine();
        String w = scanner.nextLine();
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).type.equals(w)){
                System.out.println(vehicles.get(i));
            }
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
                else if(vehicles.get(i).avail>vehicles.get(j).avail){
                    Book temp = vehicles.get(i);
                    vehicles.set(i,vehicles.get(j));
                    vehicles.set(j,temp);
                }
            }
        }
    }
    public static void changeDeposit() {
        for(int i=0;i<borrowers.size();i++){
            System.out.println(borrowers.get(i));
        }
        System.out.println("Select a borrower id");
        int a = scanner.nextInt();
        System.out.println("Enter a amount to deposit");
        borrowers.get(a-1).deposit+=scanner.nextDouble();
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
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Password");
        String pass = scanner.nextLine();
        if(checkBorrower(name,pass)){
             System.out.println("Login sucessfully");
             trueBorrower();
        }
        else System.out.println("Enter valid details");
        borrowerHome();
    }
    public static void signUp() {
        scanner.nextLine();
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
        borrowerHome();
    }
    public static boolean checkBorrower(String name,String pass) {
        for(int i=0;i<borrowers.size();i++){
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
        System.out.println("3. Add Money to wallet");
        System.out.println("4. View Wallet");
        System.out.println("5. Return");
        System.out.println("6. View Previous Rents");
        System.out.println("7. Exit");
        int a = scanner.nextInt();
        switch(a){
            case 1:{
                viewVehiclesBor();
                System.out.println("Enter S.No to add to WishList");
                int c = scanner.nextInt();
                if(!checkinCart(vehicles.get(c-1).platenumber)){
                    borrowers.get(indexB).cart.add(vehicles.get(c-1));
                }
                else{
                    System.out.println("Cant add same vehicle twice");
                }
                break;
            }
            case 2:viewCart(); break;
            case 3:addMoney();break;
            case 4:viewWallet(); break;
            case 5:returnCar(); break;
            case 6:viewRents(); break;
            default:borrowerHome();
        }
        trueBorrower();
    }
    public static void viewRents() {
        for(int i=0;i<borrowers.get(indexB).rents.size();i++){
            System.out.println(borrowers.get(indexB).rents.get(i));
        }
    }
    public static boolean checkinCart(String platenumber){
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            if(borrowers.get(indexB).cart.get(i).platenumber.equals(platenumber)){
                return true;
            }
        }
        return false;
    }
    public static void addMoney() {
        System.out.println("Enter the amount to add");
        double amount = scanner.nextDouble();
        borrowers.get(indexB).wallet+=amount;
    }
    public static void viewWallet() {
        System.out.println("Amount in wallet");
        System.out.println(borrowers.get(indexB).wallet);
    }
    public static void viewVehiclesBor() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tCost");
        for(int i=0;i<vehicles.size();i++){
            if((vehicles.get(i).type.equals("bike") && vehicles.get(i).driven<1500) || (vehicles.get(i).type.equals("car") && vehicles.get(i).driven<3000))
            System.out.println((i+1)+"\t"+vehicles.get(i).display());
        }
    }
    public static void viewCart() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tCost");
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            System.out.println((i+1)+"\t"+borrowers.get(indexB).cart.get(i).display());
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
            if((borrowers.get(indexB).deposit>=10000 && borrowers.get(indexB).cart.get(0).type.equals("car")) || (borrowers.get(indexB).deposit>=3000 && borrowers.get(indexB).cart.get(0).type.equals("bike"))){
                if(borrowers.get(indexB).wallet>=borrowers.get(indexB).cart.get(0).cost){
                    borrowers.get(indexB).order.add(borrowers.get(indexB).cart.get(0));
                    System.out.println("Thank you for buying");
                    findVehicle(borrowers.get(indexB).cart.get(0).platenumber);
                    String r = borrowers.get(indexB).cart.get(0).name+"\t"+borrowers.get(indexB).cart.get(0).model+"\t"+borrowers.get(indexB).cart.get(0).cost;
                    borrowers.get(indexB).rents.add(r);
                    vehicles.get(indexV).avail--;
                    vehicles.get(indexV).rented++;
                    borrowers.get(indexB).wallet-=borrowers.get(indexB).cart.get(0).cost;
                    borrowers.get(indexB).cart.clear();
                }
                else System.out.println("Sorry you dont have enough money in wallet");
            }
            else{
                System.out.println("You dont have enough security deposit, Please contact admin");
            }
        }
    }
    public static void findVehicle(String platenumber){
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(indexV).platenumber.equals(platenumber)){
                indexV=i;
                break;
            }
        }
    }
    public static void findVehicleInCart(String platenumber){
        for(int i=0;i<vehicles.size();i++){
            if(borrowers.get(indexB).cart.get(i).platenumber.equals(platenumber)){
                indexVO=i;
                break;
            }
        }
    }
    public static void remCar() {
        System.out.println("S.No\tName\tType\tPlatenumber\tModel\tAvail\tCost");
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            System.out.println((i+1)+"\t"+borrowers.get(indexB).cart.get(i).display());
        }
        System.out.println("Enter platenumber of the vehicle");
        scanner.nextLine();
        String platenumber = scanner.nextLine();
        findVehicleInCart(platenumber);
        borrowers.get(indexB).cart.remove(indexV);
    }
    public static void returnCar() {
        System.out.println("Enter the platenumber");
        scanner.nextLine();
        String platenumber=scanner.nextLine();
        findVehicleInOrder(platenumber);
        System.out.println("Enter the damage");
        borrowers.get(indexB).order.get(indexVO).damage=scanner.nextLine();
        if(borrowers.get(indexB).order.get(indexVO).damage.equals("LOW")){
            double fine=(borrowers.get(indexB).order.get(indexVO).cost*0.2);
            System.out.println("Fine for the damage : "+fine);
            if(borrowers.get(indexB).deposit<fine){
                System.out.println("Pay the fine amount in person");
            }else borrowers.get(indexB).deposit-=fine;
        }
        else if(borrowers.get(indexB).order.get(indexVO).damage.equals("MEDIUM")){
            double fine=(borrowers.get(indexB).order.get(indexVO).cost*0.5);
            System.out.println("Fine for the damage : "+fine);
            if(borrowers.get(indexB).deposit<fine){
                System.out.println("Pay the fine amount in person");
            }else borrowers.get(indexB).deposit-=fine;
        }
        else if(borrowers.get(indexB).order.get(indexVO).damage.equals("HIGH")){
            double fine=(borrowers.get(indexB).order.get(indexVO).cost*0.75);
            System.out.println("Fine for the damage : "+fine);
            if(borrowers.get(indexB).deposit<fine){
                System.out.println("Pay the fine amount in person");
            }else borrowers.get(indexB).deposit-=fine;
        }
        System.out.println("Enter the number of kms driven");
        int driven = scanner.nextInt();
        findVehicle(borrowers.get(indexB).order.get(indexVO).platenumber);
        vehicles.get(indexV).driven+=driven;
        if(driven>500){
            double fine=(borrowers.get(indexB).order.get(indexVO).cost*0.15);
            System.out.println("Fine : "+fine);
            if(borrowers.get(indexB).deposit<fine){
                System.out.println("Pay the fine amount in person");
            }else borrowers.get(indexB).deposit-=fine;
        }
        vehicles.get(indexV).avail+=1;
    }
    public static void findVehicleInOrder(String platenumber){
        for(int i=0;i<vehicles.size();i++){
            if(borrowers.get(indexB).order.get(i).platenumber.equals(platenumber)){
                indexV=i;
                break;
            }
        }
    }
}
class Vehicle{
    String name,type,platenumber,model,damage;
    int avail,driven,rented;
    double cost;
    Vehicle(String name,String type,String platenumber,String model,int avail,int driven,String damage,double cost,int rented){
        this.name=name;
        this.type=type;
        this.platenumber=platenumber;
        this.model=model;
        this.avail=avail;
        this.cost=cost;
        this.driven=driven;
        this.damage=damage;
        this.rented=rented;
    }
    public String toString(){
        return name+"\t"+type+"\t"+platenumber+"\t"+model+"\t"+avail+"\t"+driven+"\t"+damage+"\t"+cost+"\t"+rented;
    }
    public String display(){
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
    public String toString(){
        return name+"\t"+pass+"\t"+number+"\t"+Id+"\t"+wallet+"\t"+deposit;
    }
}