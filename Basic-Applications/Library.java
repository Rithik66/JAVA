/*
Design and Develop a Monolith Console based Library Management system by
understanding various use cases from the Borrower and Administrator point of view.
You are allowed to improvise and add more real-time use relevant cases to to each task
if possible.
------------------------------------------------------------------------------------------
Module A : Authentication and Welcome menu
------------------------------------------------------------------------------------------
    Application must authenticate both Borrower and Administrator taking EmailID and
 password and display a welcome menu based on their role.
------------------------------------------------------------------------------------------
Module B : Book Inventory Management
------------------------------------------------------------------------------------------
    Admin can Add a Book,Modify Book details such as Avaialble Quantity and Delete a
 Book. Admin will add other Admins and Borrowers into the System
    a) Admin can view list of all Book sorted by Name or Available Quantity
    b) Admin can search a Book by name or ISBN
    c) Admin can manage Borrowers fine limit
------------------------------------------------------------------------------------------
Module C : Borrowing Book
------------------------------------------------------------------------------------------
    Borrowers can view a list of all Books available, Select the Book by Name or ISBN and
 checkout . Borrower can borrow maximum of 3 books at a time
    a) Add a book into checkout cart or remove them
    b) Cannot borrow same book twice
    c) Can borrow a book only if a minimum security deposit of rupees 500 is maintained
------------------------------------------------------------------------------------------
Module D : Fine and Regulations
------------------------------------------------------------------------------------------
    Each Borrower has deposited 1500 rupees Initially into the Book Bank as a Caution
 deposit . The Amount will be refunded on closure of account . The Amount will be
 reduced if there is any delay in return or loss of book
    1. Books borrowed more than 15days will carry fine amount of 2Rs perday and
    increases exponentially for every 10 days delay or 80% of book cost whichever is
    lowest. For Simplicity get Return date from user in DD/MM/YYYY format
    2. If book is lost then 50% of actual cost of book is considered as fine
    3. If Member ship card is lost 10 Rs is collected as fine amount
 Fine amount can either by paid by cash or reduced in security deposit
 
 Regulations:
    a) Borrower can extend the tenure up to two times only consecutively for a book.
    b) All three book that can be borrowed parallelly must be different
    c) Borrowers can either extend the tenure, exchange the book, Inform card lost or mark
 a book as lost during every transaction
------------------------------------------------------------------------------------------
Module E : Reports
------------------------------------------------------------------------------------------
    Admin can view below reports
    1. Books with less quantity so that they can refill
    2. Books that are not borrowed so far by any students
    3. Books thats heavily borrowed so that they can check the condition of book
    4. Students who has outstanding not returned book as on given date
    5. Status of current book searched by ISBN number , display the details of student
 who borred that book and when it can be expected to be returned in rack
 
    Students can view:
    1. List of previous fines (if any) and its reason
    2. List of previous books borrows
    
    ------------------------------------------------------------------------------------------
*/



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Admin> admins = new ArrayList<>();
    static ArrayList<Borrower> borrowers = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static String notRet = "";
    static int indexA,indexB,indexBook,indexC,indexF,indexO;
    public static void main(String[] args) {
        adm();
        home();
    }
    public static void home(){
        System.out.println("-----Welcome to our library-----");
        System.out.println("1. Adminstrator");
        System.out.println("2. Borrower");
        System.out.println("3. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:admin();break;
            case 2:borrower();break;
            default: System.out.println("Thank You for visiting our library"); System.exit(1);
        }
    }
    public static void admin() {
        System.out.println("-----Welcome to Admin Login-----");
        System.out.println("Enter username : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter password : ");
        String pass = scanner.nextLine();
        clear();
        if(checkAdmin(name,pass)){
            System.out.println("Welcome "+admins.get(indexA).name);
            trueAdmin();
        }
        else{
            System.out.println("Sorry you are not a authorised admin");
            home();
        }
    }
    public static boolean checkAdmin(String name,String pass){
        for(int i=0;i<admins.size();i++){
            if(admins.get(i).name.equals(name) && admins.get(i).pass.equals(pass)){
                indexA=i;
                return true;
            }
        }
        return false;
    }
    public static void trueAdmin(){
        System.out.println("1. Add an Admin");
        System.out.println("2. Add a Borrower");
        System.out.println("3. Add a Book");
        System.out.println("4. Modify the book");
        System.out.println("5. View Reports");
        System.out.println("6. View All Books");
        System.out.println("7. Search Book");
        System.out.println("8. Manage fines");
        System.out.println("9. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:addAdmin(); break;
            case 2:addBorrower(); break;
            case 3:addBook(); break;
            case 4:modifyBook(); break;
            case 5:viewReports(); break;
            case 6:viewAllBooks();break;
            case 7:search(); break;
            case 8:manageFines();break;
            default: home();
        }
    }
    public static void manageFines(){
        System.out.println("S.No\t\tName\t\tID\t\tFines");
        for(int i=0;i<borrowers.size();i++){
            System.out.println((i+1)+"\t\t"+borrowers.get(i).name+"\t\t"+borrowers.get(i).memCardId+"\t\t"+borrowers.get(i).fines.size());
        }
        System.out.println("Select a S.No to remove (type "+borrowers.size()+1+" to go back)");
        int a = scanner.nextInt()-1;
        if(a<borrowers.size()){
            borrowers.remove(a);
        }
        else trueAdmin();
    }
    public static void search() {
        System.out.println("-----Search Book Portal-----");
        System.out.println("1. Search by name");
        System.out.println("2. Search by ISBN");
        int c = scanner.nextInt();
        clear();
        switch(c){
            case 1:searchBookByName();break;
            case 2:searchBookByISBN();break;
            default :trueAdmin();
        }
    }
    public static void addAdmin(){
        System.out.println("-----Add Admin Portal-----");
        System.out.println("Enter Username");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter Password");
        String pass = scanner.nextLine();
        clear();
        if(checkAdmin(name, pass)){
            System.out.println("Username already exists");
        }
        else{
            admins.add(new Admin(name, pass));
            System.out.println("Admin added sucessfully");
        }
        trueAdmin();
    }
    public static void addBorrower(){
        System.out.println("-----Add Borrower Portal-----");
        System.out.println("Enter Username");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter Password");
        String pass = scanner.nextLine();
        clear();
        if(checkBorrower(name, pass)){
            System.out.println("Username already exists");
        }
        else{
            borrowers.add(new Borrower(name, pass,borrowers.size()+1,1500,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
            System.out.println("Borrower added sucessfully");
        }
        trueAdmin();
    }
    public static void addBook(){
        System.out.println("-----Add Book Portal-----");
        System.out.println("Name of the book ");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Enter the ISBN ");
        String ISBN = scanner.nextLine();
        System.out.println("Enter the price of the book ");
        int price = scanner.nextInt();
        System.out.println("Enter the Quantity of book");
        int quantity = scanner.nextInt();
        if(checkBook(name, ISBN)){
            System.out.println("Same book is already available in the library");
        }
        else{
            books.add(new Book(name, ISBN, price,quantity,0,""));
            System.out.println("Book added successfully");
        }
        trueAdmin();
    }
    public static boolean checkBook(String name,String ISBN){
        for(int i=0;i<books.size();i++){
            if(books.get(i).name.equals(name) && books.get(i).ISBN.equals(ISBN)){
                indexBook=i;
                return true;
            }
        }
        return false;
    }
    public static void modifyBook(){
        System.out.println("-----Modify Book Portal-----");
        System.out.println("1. Change details of a book");
        System.out.println("2. Remove a book");
        System.out.println("3. Exit");
        int a = scanner.nextInt();
        switch(a){
            case 1:changeDetail(); break;
            case 2:deleteBook(); break;
            default: trueAdmin();
        }
        trueAdmin();
    }
    public static void changeDetail(){
        System.out.println("-----Change Details Portal-----");
        System.out.println("Enter the name of the book");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter ISBN");
        String ISBN = scanner.nextLine();
        if(checkBook(name, ISBN)){
            System.out.println("1. Change Name");
            System.out.println("2. Change ISBN");
            System.out.println("3. Change quantity");
            int a = scanner.nextInt();
            switch(a){
                case 1:{
                    scanner.nextLine();
                    System.out.println("Enter new Name");
                    books.get(indexBook).name=scanner.nextLine();
                }
                case 2:{
                    scanner.nextLine();
                    System.out.println("Enter new ISBN");
                    books.get(indexBook).ISBN=scanner.nextLine();
                }
                case 3:{
                    scanner.nextLine();
                    System.out.println("Enter new Quantity");
                    books.get(indexBook).quantity=scanner.nextInt();
                }
            }
        }
        modifyBook();
    }
    public static void deleteBook(){
        System.out.println("-----Delete Book Portal-----");
        System.out.println("Enter the name of the book");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Enter ths ISBN");
        String ISBN = scanner.nextLine();
        if(checkBook(name, ISBN)){
            books.remove(indexBook);
            System.out.println("Book removed successfully");
        }
        else{
            System.out.println("Enter a valid book name or ISBN");
        }
        trueAdmin();
    }
    public static void viewReports(){
        System.out.println("1. Quantity of books");
        System.out.println("2. Books that are not borrowed");
        System.out.println("3. Books that are heavily borrowed");
        System.out.println("4. Students who did not return within limit");
        System.out.println("5. Exit");
        int a = scanner.nextInt();
        switch(a){
            case 1:bookQuant();break;
            case 2:notBorrowed();break;
            case 3:heavilyBorrowed();break;
            case 4:notReturn();break;
            case 5:bookBorrowedDetail();break;
            default: break;
        }
        trueAdmin();
    }
    public static void bookBorrowedDetail(){
        System.out.println("Book\t\tName\t\tMemberId");
        for(int i=0;i<books.size();i++){
            System.out.println(books.get(i).name+"\t\t"+books.get(i).borrowedBy);
        }
        scanner.nextLine();
        enter();
        viewReports();
    }
    public static void bookQuant(){
        System.out.println("Name\t\tISBN\t\tQuantity\t\tStatus");
        for(int i=0;i<books.size();i++){
            String status="No need refill";
            if(books.get(i).quantity<10) status="Need refill";
            System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).quantity+"\t\t"+status);
        }
        scanner.nextLine();
        enter();
        viewReports();
    }
    public static void notBorrowed(){
        System.out.println("Name\t\tISBN\t\tQuantity");
        for(int i=0;i<books.size();i++){
            if(books.get(i).timesBorrowed==0)
            System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).quantity);
        }
        scanner.nextLine();
        enter();
        viewReports();
    }
    public static void heavilyBorrowed() {
        System.out.println("Name\t\tISBN\t\tQuantity\t\tTimesBorrowed");
        for(int i=0;i<books.size();i++){
            if(books.get(i).timesBorrowed>5)
            System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).quantity+"\t\t"+books.get(i).timesBorrowed);
        }
        scanner.nextLine();
        enter();
        viewReports();
    }
    public static void notReturn(){
        System.out.println("Name\t\tBook\t\tISBN");
        System.out.println(notRet);
        scanner.nextLine();
        enter();
        viewReports();
    }
    public static void viewAllBooks(){
        System.out.println("-----View All Book Portal-----");
        sort(books);
        System.out.println("Name\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
        }
        scanner.nextLine();
        enter();
        trueAdmin();
    }
    public static void sort(ArrayList<Book> books){
        for(int i=0;i<books.size()-1;i++){
            for(int j=i+1;j<books.size();j++){
                if(books.get(i).name.compareTo(books.get(j).name)>0){
                    Book temp = books.get(i);
                    books.set(i,books.get(j));
                    books.set(j,temp);
                }
                else if(books.get(i).quantity>books.get(j).quantity){
                    Book temp = books.get(i);
                    books.set(i,books.get(j));
                    books.set(j,temp);
                }
            }
        }
    }
    public static void searchBookByName(){
        System.out.println("-----Search Book Portal-----");
        System.out.println("Enter a word or letter matching to the book Name");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Name\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            if(books.get(i).name.contains(name)){
                System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
            }
        }
        enter();
        clear();
        trueAdmin();
    }
    public static void searchBookByISBN(){
        System.out.println("-----Search Book Portal-----");
        System.out.println("Enter a word or letter matching to the book ISBN");
        scanner.nextLine();
        String ISBN=scanner.nextLine();
        System.out.println("Name\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            if(books.get(i).ISBN.contains(ISBN)){
                System.out.println(books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
            }
        }
        enter();
        clear();
        trueAdmin();
    }
    public static void borrower(){
        System.out.println("-----Welcome to Borrower Login-----");
        System.out.println("Enter username : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter password : ");
        String pass = scanner.nextLine();
        clear();
        if(checkBorrower(name,pass)){
            System.out.println("Welcome "+borrowers.get(indexB).name);
            trueBorrower();
        }
        else{
            System.out.println("Sorry you are not a authorised borrower");
            home();
        }
    }
    public static boolean checkBorrower(String name,String pass){
        for(int i=0;i<borrowers.size();i++){
            if(borrowers.get(i).name.equals(name) && borrowers.get(i).pass.equals(pass)){
                indexB=i;
                return true;
            }
        }
        return false;
    }
    public static void trueBorrower(){
        
        System.out.println("1. View All Books");
        System.out.println("2. Search Book");
        System.out.println("3. Cart");
        System.out.println("4. Return book");
        System.out.println("5. Lost");
        System.out.println("6. Check balance");
        System.out.println("7. Deposit");
        System.out.println("8. View My fines");
        System.out.println("9. View my borrows");
        System.out.println("10. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:viewBooks();break;
            case 2:{
                System.out.println("-----Search Book Portal-----");
                System.out.println("1. Search by name");
                System.out.println("2. Search by ISBN");
                int c = scanner.nextInt();
                clear();
                switch(c){
                    case 1:selectBookByName();break;
                    case 2:selectBookByISBN();break;
                    default :trueBorrower();
                }
            }
            case 3:cart();break;
            case 4:returnBook(); break;
            case 5:lost(); break;
            case 6:{
                System.out.println(borrowers.get(indexB).money);
                scanner.nextLine();
                enter();
                break;
            }
            case 7:{
                System.out.println("Enter amount to deposit");
                int dep = scanner.nextInt();
                borrowers.get(indexB).money+=dep;
                scanner.nextLine();
                enter();
                break;
            }
            case 8:{
                System.out.println("Reason\t\tName\t\tAmount");
                for(int i=0;i<borrowers.get(indexB).fines.size();i++)
                System.out.println(borrowers.get(indexB).fines.get(i));
                break;
            }
            case 9:{
                System.out.println("Name\t\tISBN");
                for(int i=0;i<borrowers.get(indexB).booksBorrowed.size();i++)
                System.out.println(borrowers.get(indexB).booksBorrowed.get(i));
                break;
            }
            default: home();
        }
        trueBorrower();
    }
    public static void lost(){
        System.out.println("1. Lost book ");
        System.out.println("2. Lost Membership card");
        System.out.println("3. Exit");
        int a = scanner.nextInt();
        clear();
        switch(a){
            case 1:lostBook();
            case 2:lostMemCard();
            default :trueBorrower();
        }
        trueBorrower();
    }
    public static void lostBook() {
        System.out.println("Enter the name of the Book");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter ISBN");
        String ISBN = scanner.nextLine();
        if(checkBook(name, ISBN)){
            borrowers.get(indexB).money-=(books.get(indexBook).price/2);
            if(borrowers.get(indexB).money<0) System.out.println("You need to pay "+(0-borrowers.get(indexB).money));
            borrowers.get(indexB).fines.add("lost Book\t\t"+name+"\t\t"+(books.get(indexBook).price/2));
        }
        enter();
        trueBorrower();
    }
    public static void lostMemCard() {
        System.out.println("Did you Lose your MemberShip Card");
        System.out.println("1. yes");
        System.out.println("2. no");
        int a = scanner.nextInt();
        switch(a){
            case 1:{
                borrowers.get(indexB).money-=10;
                if(borrowers.get(indexB).money<0) System.out.println("You need to pay "+(0-borrowers.get(indexB).money));
                borrowers.get(indexB).fines.add("lost Card\t\tMemberCard\t\t10");
                enter();
            }
        }
        trueBorrower();
    }
    public static void returnBook(){
        for(int i=0;i<borrowers.get(indexB).booksBorrowed.size();i++){
            System.out.println(borrowers.get(indexB).booksBorrowed.get(i));
        }
        System.out.println("\nEnter the name of the book returning");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Enter ISBN");
        String ISBN = scanner.nextLine();
        if(checkBookInOrder(name,ISBN)){
            System.out.println("Enter the return date");
            String returnDate = scanner.nextLine();
            borrowers.get(indexB).orderList.get(indexO).dateReturned=returnDate;
            checkFine(name);
            borrowers.get(indexB).orderList.get(indexO).quantity+=1;
        }
        trueBorrower();
    }
    public static void checkFine(String name){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try{
        Date reDate = f.parse(borrowers.get(indexB).orderList.get(indexO).dateReturned);
        Date boDate = f.parse(borrowers.get(indexB).orderList.get(indexO).dateBorrowed);
        long difference=reDate.getTime()-boDate.getTime();
        difference=(difference/(1000*60*60*24))% 365;
        long delay,delay1;
        if(difference>15){
            notRet+=borrowers.get(indexB).name+"\t\t"+borrowers.get(indexB).orderList.get(indexO).name+"\t\t"+borrowers.get(indexB).orderList.get(indexO).ISBN+"\n";
            delay=(difference-15);
            long t=delay/10;
            delay=(long)(delay*(2*Math.pow(2, t)));
            delay1=(long) ((double)borrowers.get(indexB).orderList.get(indexO).price*(0.8));
            long minusCost=0;
            if(delay<delay1){
                minusCost=delay;
                borrowers.get(indexB).money-=minusCost;
                borrowers.get(indexB).fines.add("late return\t\t"+name+"\t\t"+delay);
            }
            else{
                minusCost=delay1;
                borrowers.get(indexB).money-=minusCost;
                borrowers.get(indexB).fines.add("late return\t\t"+name+"\t\t"+delay1);
            }
            borrowers.get(indexB).orderList.get(indexO).price-=minusCost;
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean checkBookInOrder(String name,String ISBN){
        for(int i=0;i<borrowers.get(indexB).orderList.size();i++){
            if(borrowers.get(indexB).orderList.get(i).name.equals(name) && borrowers.get(indexB).orderList.get(i).ISBN.equals(ISBN)){
                indexO=i;
                return true;
            }
        }
        return false;
    }
    public static void cart(){
        System.out.println("-----Inside Cart-----");
        System.out.println("S.No\t\tName\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
                System.out.println((i+1)+"\t\t"+borrowers.get(indexB).cart.get(i).name+"\t\t"+borrowers.get(indexB).cart.get(i).ISBN+"\t\t"+borrowers.get(indexB).cart.get(i).price+"\t\t"+borrowers.get(indexB).cart.get(i).quantity);
        }
        System.out.println("1. Buy Books");
        System.out.println("2. Remove Books");
        int a = scanner.nextInt();
        switch(a){
            case 1:buyBooks(); break;
            case 2:{
                System.out.println("Enter the name of the book");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Enter ISBN");
                String ISBN = scanner.nextLine();
                if(checkBookInCart(name, ISBN)){
                    borrowers.get(indexB).cart.remove(indexC);
                }
                else{
                    System.out.println("No such book found in cart");
                }
            }
        }
        trueBorrower();
    }
    public static void buyBooks() {
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            if(borrowers.get(indexB).booksBorrowed.contains(borrowers.get(indexB).cart.get(i).name+"\t\t"+borrowers.get(indexB).cart.get(i).ISBN)){
                System.out.println(borrowers.get(indexB).cart.get(i).name+" - "+borrowers.get(indexB).cart.get(i).ISBN+" is already borrowed");
                System.out.println("You can not buy same book twice");
                return;
            }
        }
        if(borrowers.get(indexB).money>=500){
            if(borrowers.get(indexB).cart.size()+borrowers.get(indexB).orderList.size()<=3){
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                for(int i=0;i<borrowers.get(indexB).cart.size();i++){
                    findBook(borrowers.get(indexB).cart.get(i).name,borrowers.get(indexB).cart.get(i).ISBN);
                    borrowers.get(indexB).money-=books.get(indexF).price;
                    books.get(indexF).quantity-=1;
                    books.get(indexF).timesBorrowed+=1;
                    books.get(indexF).borrowedBy+=borrowers.get(indexB).name+"\t\t"+borrowers.get(indexB).memCardId+"\n";
                    borrowers.get(indexB).booksBorrowed.add(borrowers.get(indexB).cart.get(i).name+"\t\t"+borrowers.get(indexB).cart.get(i).ISBN);
                    borrowers.get(indexB).orderList.add(
                        new Ordered(borrowers.get(indexB).cart.get(i).name, 
                        borrowers.get(indexB).cart.get(i).ISBN, f.format(date),"",
                        borrowers.get(indexB).cart.get(i).price, borrowers.get(indexB).cart.get(i).quantity));
                }
                borrowers.get(indexB).cart.clear();
            }
            else{
                System.out.println("Buying limit exceeds");
            }
        }
        else System.out.println("You should have minimum security deposit of atleast Rs.500 to borrow");
        trueBorrower();
    }
    public static void findBook(String name,String ISBN){
        for(int i=0;i<books.size();i++){
            if(books.get(i).name.equals(name) && books.get(i).ISBN.equals(ISBN)){
                indexF=i;
                break;
            }
        }
    }
    public static boolean checkBookInCart(String name, String ISBN) {
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            if(borrowers.get(indexB).cart.get(i).name.equals(name) && borrowers.get(indexB).cart.get(i).ISBN.equals(ISBN)){
                indexC=i;
                return true;
            }
        }
        return false;
    }
    public static void selectBookByISBN() {
        System.out.println("-----Search Book Portal-----");
        System.out.println("Enter a word or letter matching to the book ISBN");
        scanner.nextLine();
        String ISBN=scanner.nextLine();
        System.out.println("S.No\t\tName\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            if(books.get(i).ISBN.contains(ISBN)){
                System.out.println((i+1)+"\t\t"+books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
            }
        }
        System.out.println("Select a S.no to add in cart");
        int a = scanner.nextInt()-1;
            if(borrowers.get(indexB).cart.size()<3){
                if(!borrowers.get(indexB).cart.contains(books.get(a)))
                    borrowers.get(indexB).cart.add(books.get(a));
                else System.out.println("You cannot buy same book twice");
            }
            else{
                System.out.println("You can borrow only 3 at a time");
            }
        trueBorrower();
    }
    public static void selectBookByName() {
        System.out.println("-----Search Book Portal-----");
        System.out.println("Enter a word or letter matching to the book Name");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("S.No\t\tName\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            if(books.get(i).name.contains(name)){
                System.out.println((i+1)+"\t\t"+books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
            }
        }
        System.out.println("Select a S.no to add in cart");
        int a = scanner.nextInt()-1;
        if(borrowers.get(indexB).cart.size()<3){
            if(!cartContains(books.get(a).name, books.get(a).ISBN))
                borrowers.get(indexB).cart.add(books.get(a));
            else System.out.println("Cant add same book twice");
        }
        else{
            System.out.println("You can borrow only 3 at a time");
        }
        trueBorrower();
    }
    public static boolean cartContains(String name,String ISBN){
        for(int i=0;i<borrowers.get(indexB).cart.size();i++){
            if(borrowers.get(indexB).cart.get(i).name.equals(name) && borrowers.get(indexB).cart.get(i).ISBN.equals(ISBN))
                return true;
        }
        return false;
    }
    public static void viewBooks(){
        System.out.println("S.No\t\tName\t\tISBN\t\tPrice\t\tQuantity");
        for(int i=0;i<books.size();i++){
            System.out.println((i+1)+"\t\t"+books.get(i).name+"\t\t"+books.get(i).ISBN+"\t\t"+books.get(i).price+"\t\t"+books.get(i).quantity);
        }
        trueBorrower();
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
    public static void adm(){
        admins.add(new Admin("admin","1234"));
    }
}
class Admin{
    String name,pass;
    Admin(String name,String pass){
        this.pass=pass;
        this.name=name;
    }
}
class Borrower{
    String name,pass;
    int memCardId,money;
    ArrayList<String> fines,booksBorrowed;
    ArrayList<Book> cart;
    ArrayList<Ordered> orderList;
    Borrower(String name,String pass,int memCardId,int money,ArrayList<Book> cart,ArrayList<Ordered> orderList,ArrayList<String> fines,ArrayList<String> booksBorrowed){
        this.pass=pass;
        this.name=name;
        this.memCardId=memCardId;
        this.money=money;
        this.cart=new ArrayList<>(cart);
        this.orderList=new ArrayList<>(orderList);
        this.fines=new ArrayList<>(fines);
        this.booksBorrowed=new ArrayList<>(booksBorrowed);
    }
}
class Book{
    String name,ISBN,borrowedBy;
    int price,quantity,timesBorrowed;
    Book(String name,String ISBN,int price,int quantity,int timesBorrowed,String borrowedBy){
        this.ISBN=ISBN;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.timesBorrowed=timesBorrowed;
        this.borrowedBy=borrowedBy;
    }
}
class Ordered{
    String name,ISBN,dateBorrowed,dateReturned;
    int price,quantity;
    Ordered(String name,String ISBN,String dateBorrowed,String dateReturned,int price,int quantity){
        this.name=name;
        this.ISBN=ISBN;
        this.dateBorrowed=dateBorrowed;
        this.dateReturned=dateReturned;
        this.price=price;
        this.quantity=quantity;

    }
}
