import java.util.*;
public class Zobus{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Customers> customers = new ArrayList<>();
    static ArrayList<String> acb = new ArrayList<>();
    static ArrayList<String> n_acb = new ArrayList<>();
    static int check=1;
    static String seaterAC[][] = new String[4][3];
    static String sleeperUpperAC[][] = new String[3][2];
    static String sleeperLowerAC[][] = new String[3][2];

    static String seaterNAC[][] = new String[4][3];
    static String sleeperUpperNAC[][] = new String[3][2];
    static String sleeperLowerNAC[][] = new String[3][2];
    static int mainIndex;
    static int s_ac,sl_ac,s_n_ac,sl_n_ac;
    static String bus;
    static ArrayList<String> gen= new ArrayList<>();
    static int slFAC,slFNAC,sFAC,sFNAC;
    public static void main(String[]args){
        cus();
        set();
        home();
	}
    private static void set() {
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                seaterAC[i][j]="";
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                seaterNAC[i][j]="";
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                sleeperUpperAC[i][j]="";
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                sleeperLowerAC[i][j]="";
            }
        }for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                sleeperUpperNAC[i][j]="";
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                sleeperLowerNAC[i][j]="";
            }
        }
    }
    public static void home(){
        System.out.println("-----Welcome to ZOBUS-----");
        System.out.println("Routes available : Chennai to Bangaluru");
        System.out.println("Press 'Enter' to Continue to login page");
        String enter = scanner.nextLine();
        System.out.println("Enter your choice : ");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
        int c = scanner.nextInt();
        switch(c){
            case 1: customerLogin(); break;
            case 2: customerSignUp(); break;
            default:{
                System.out.println("Please enter Correct Choice");
                home();
            }
        }
    }
    public static void customerLogin(){
        scanner.nextLine();
        System.out.println("Welcome to LOGIN");
        System.out.print("Enter your UserName : ");
        String name=scanner.nextLine();
        System.out.print("Enter your password : ");
        String pass = scanner.nextLine();
        if(checkCred(name,pass)){
            System.out.println("Welcome "+name);
            trueCus();
        }
        else{
            System.out.println("Enter a valid Login username or password");
            home();
        }
    }
    public static void trueCus(){
        if(check==1){check++;trueCus();}
        showAvail();
        System.out.println("Enter your choice");
        System.out.println("1. Book seats");
        System.out.println("2. Exit to Home");
        int c = scanner.nextInt();
        if(c==2) home();
        System.out.println("Enter the number of passengers");
        int a = scanner.nextInt();
        if(!checkAvail(a)){
            System.out.println("Number of seats is Exceeding the available seats");
        }else{
            System.out.println("Select a Bus");
            System.out.println();
            System.out.println("1. AC Seater");
            System.out.println("2. AC Sleeper");
            System.out.println("3. Non-AC Seater");
            System.out.println("4. Non-AC Sleeper");
            int bus = scanner.nextInt();
            scanner.nextLine();
            gen.clear();
            for(int i=0;i<a;i++){
                System.out.println("Enter passenger "+(i+1)+" name :");
                String name = scanner.nextLine();
                System.out.println("Enter passenger "+(i+1)+" gender :");
                String gender = scanner.nextLine();
                gen.add(gender+"1");
            }
            System.out.println(gen);
            switch(bus) {
                case 1: seater_AC();break;
                case 2: sleeper_AC();break;
                case 3: seaterNon_AC();break;
                case 4: sleeperNon_AC();break;
            }
            fare_calculation();
            trueCus();
        }
    }
    private static void sleeperNon_AC(){
        int sleeperFare=600;
        int seats=0;
        ArrayList<String> temp_gen= new ArrayList<>(gen);
        String tempUpperNAC[][] = new String[3][2];
        String tempLowerNAC[][] = new String[3][2];
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                tempLowerNAC[i][j]=sleeperLowerNAC[i][j];
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                tempUpperNAC[i][j]=sleeperUpperNAC[i][j];
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                String g=checkrow(tempUpperNAC,i,2);
                if(g.equals("")){
                    for(int k=0;k<temp_gen.size();k++){
                        tempUpperNAC[i][j]=temp_gen.get(k);
                        temp_gen.remove(k);
                    }
                }
                if(g.equals("M")){
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("M1")) {
                            temp_gen.remove(k);
                            tempUpperNAC[i][j]="M1";
                            seats++;
                        }
                    }
                }else{
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("F1")) {
                            temp_gen.remove(k);
                            tempUpperNAC[i][j]="F1";
                            seats++;
                        }
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                String g=checkrow(tempLowerNAC,i,2);
                if(g.equals("")){
                    for(int k=0;k<temp_gen.size();k++){
                        tempUpperNAC[i][j]=temp_gen.get(k);
                        temp_gen.remove(k);
                    }
                }
                if(g.equals("M")){
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("M1")) {
                            temp_gen.remove(k);
                            tempLowerNAC[i][j]="M1";
                            seats++;
                        }
                    }
                }else{
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("F1")) {
                            temp_gen.remove(k);
                            tempLowerNAC[i][j]="F1";
                            seats++;
                        }
                    }
                }
            }
        }
        slFNAC=sleeperFare*seats;
    }
    private static void seaterNon_AC() {
        int seaterFare=450;
        int seats=0;
        ArrayList<String> temp_gen= new ArrayList<>(gen);
        //System.out.println(temp_gen);
        String tempNAC[][] = new String[4][3];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                tempNAC[i][j]=seaterNAC[i][j];
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                String g=checkrow(tempNAC,i,3);
                if(tempNAC[i][j]==""){
                    if(g.equals("")){
                        for(int k=0;k<temp_gen.size();){
                            //System.out.println(temp_gen);
                            tempNAC[i][j]=temp_gen.get(k);
                            temp_gen.remove(k);
                            break;
                        }
                    }
                    else if(g.equals("M")){
                        for(int k=0;k<temp_gen.size();k++){
                            if(temp_gen.get(k).equals("M1")){
                                temp_gen.remove(k);
                                tempNAC[i][j]="M1";
                                j++;
                                seats++;
                                break;
                            }
                        }
                    }else{
                        for(int k=0;k<temp_gen.size();k++){
                            if(temp_gen.get(k).equals("F1")){
                                temp_gen.remove(k);
                                tempNAC[i][j]="F1";
                                j++;
                                seats++;
                                break;
                            }
                        }
                    }
            }
            }
            sFAC=seaterFare*gen.size();
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(!tempNAC[i][j].equals(""))System.out.print(tempNAC[i][j]);
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println("Do you confirm");
        String con = scanner.nextLine();
        if(con.equalsIgnoreCase("Yes")){
            for(int l=0;l<4;l++){
                for(int h=0;h<3;h++){
                    if(tempNAC[l][h].length()==2) tempNAC[l][h]=tempNAC[l][h].substring(0,1);
                }
            }
            fare_calculation();
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    seaterNAC[i][j]=tempNAC[i][j];
                }
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(!tempNAC[i][j].equals(""))System.out.print(tempNAC[i][j]);
                    else System.out.print("- ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Cancel successfully !!");
        }
    }
    private static void sleeper_AC(){
        int sleeperFare=700;
        int seats=0;
        ArrayList<String> temp_gen= new ArrayList<>(gen);
        String tempUpperAC[][] = new String[3][2];
        String tempLowerAC[][] = new String[3][2];
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                tempLowerAC[i][j]=sleeperLowerAC[i][j];
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                tempUpperAC[i][j]=sleeperUpperAC[i][j];
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                String g=checkrow(tempUpperAC,i,2);
                if(g.equals("")){
                    for(int k=0;k<temp_gen.size();k++){
                        tempUpperAC[i][j]=temp_gen.get(k);
                        temp_gen.remove(k);
                        k=k+1;
                    }
                }
                if(g.equals("M")){
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("M1")){
                            temp_gen.remove(k);
                            tempUpperAC[i][j]="M1";
                            seats++;
                        }
                    }
                }else{
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("F1")){
                            temp_gen.remove(k);
                            tempUpperAC[i][j]="F1";
                            seats++;
                        }
                    }
                }
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                String g=checkrow(tempLowerAC,i,2);
                if(g.equals("")){
                    System.out.println("Sorry seats are not available");
                    home();
                }
                if(g.equals("M")){
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("M1")){
                            temp_gen.remove(k);
                            tempLowerAC[i][j]="M1";
                            seats++;
                        }
                    }
                }else{
                    for(int k=0;k<temp_gen.size();k++){
                        if(temp_gen.get(k).equals("F1")){
                            temp_gen.remove(k);
                            tempLowerAC[i][j]="F1";
                            seats++;
                        }
                    }
                }
            }
        }
        slFAC=sleeperFare*seats;
    }
    private static void seater_AC() {
        int seaterFare=550;
        int seats=0;
        ArrayList<String> temp_gen= new ArrayList<>(gen);
        //System.out.println(temp_gen);
        String tempAC[][] = new String[4][3];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                tempAC[i][j]=seaterAC[i][j];
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                String g=checkrow(tempAC,i,3);
                if(tempAC[i][j]==""){
                    if(g.equals("")){
                        for(int k=0;k<temp_gen.size();){
                            //System.out.println(temp_gen);
                            tempAC[i][j]=temp_gen.get(k);
                            temp_gen.remove(k);
                            break;
                        }
                    }
                    else if(g.equals("M")){
                        for(int k=0;k<temp_gen.size();k++){
                            if(temp_gen.get(k).equals("M1")){
                                temp_gen.remove(k);
                                tempAC[i][j]="M1";
                                j++;
                                seats++;
                                break;
                            }
                        }
                    }else{
                        for(int k=0;k<temp_gen.size();k++){
                            if(temp_gen.get(k).equals("F1")){
                                temp_gen.remove(k);
                                tempAC[i][j]="F1";
                                j++;
                                seats++;
                                break;
                            }
                        }
                    }
            }
            }
            sFAC=seaterFare*gen.size();
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(!tempAC[i][j].equals(""))System.out.print(tempAC[i][j]);
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println("Do you confirm");
        String con = scanner.nextLine();
        if(con.equalsIgnoreCase("Yes")){
            for(int l=0;l<4;l++){
                for(int h=0;h<3;h++){
                    if(tempAC[l][h].length()==2) tempAC[l][h]=tempAC[l][h].substring(0,1);
                }
            }
            fare_calculation();
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    seaterAC[i][j]=tempAC[i][j];
                }
            }
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(!tempAC[i][j].equals(""))System.out.print(tempAC[i][j]);
                    else System.out.print("- ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Cancel successfully !!");
        }
    }
    private static String checkrow(String[][] tempUpperNAC,int i,int limit) {
        for(int j=0;j<limit;j++){
            if(tempUpperNAC[i][j].equals("M")) return "M";
            if(tempUpperNAC[i][j].equals("F")) return "F";
        }
        return "";
    }
    public static void fare_calculation(){
        System.out.println(sFAC+sFNAC+slFAC+slFNAC);
    }
    private static boolean checkAvail(int a){
        if(s_ac>=a || s_n_ac>=a || sl_ac>=a || sl_n_ac>=a) return true;
        return false;
    }
    public static void showAvail(){
        s_ac=0;s_n_ac=0;sl_ac=0;sl_n_ac=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(seaterAC[i][j].equals("")) s_ac++;
                if(seaterNAC[i][j].equals("")) s_n_ac++;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(sleeperLowerAC[i][j].equals("")) sl_ac++;
                if(sleeperLowerNAC[i][j].equals("")) sl_n_ac++;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(sleeperUpperAC[i][j].equals("")) sl_ac++;
                if(sleeperUpperNAC[i][j].equals("")) sl_n_ac++;
            }
        }
        System.out.println("AC Sleeper - "+sl_ac);
        System.out.println("AC Seater - "+s_ac);
        System.out.println("Non-AC Sleeper - "+sl_n_ac);
        System.out.println("Non-AC Seater - "+s_n_ac);
    }
    public static void customerSignUp(){
        scanner.nextLine();
        System.out.println("Welcome to SignUp");
        System.out.print("Enter your UserName : ");
        String name=scanner.nextLine();
        System.out.print("Enter your password : ");
        String pass = scanner.nextLine();
        if(checkCred(name,pass)){
            System.out.println("Please change your username");
        }
        else{
            System.out.print("Enter your Age : ");
            int age=scanner.nextInt();
            scanner.nextLine();
            System.out.print("\nEnter your Gender : ");
            String gender = scanner.nextLine();

            customers.add(new Customers(name, pass, age,gender,""));

            System.out.println("Thank you registering !, Please Login");
            System.out.println("press 'Enter' to continue");
            String enter=scanner.nextLine();
            home();
        }
    }
    public static boolean checkCred(String name,String pass){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).name.equals(name) && customers.get(i).pass.equals(pass)){
                mainIndex=i;
                return true;
            }
        }
        return false;
    }
    public static void cus(){
        customers.add(new Customers("aaa","111",25,"F",""));
        customers.add(new Customers("bbb","222",22,"F",""));
        customers.add(new Customers("ccc","333",61,"F",""));
        customers.add(new Customers("ddd","444",36,"F",""));
    }
}
class Customers{
	String name,pass,gender,seat;
    int age;
    Customers(String name,String pass,int age,String gender,String seat){
        this.name=name;
        this.pass=pass;
        this.age=age;
        this.seat=seat;
        this.gender=gender;
    }
}