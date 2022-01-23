/*
TASK :

------------------------------------------------------------------------------------------
MODULE 1: Admin Login
------------------------------------------------------------------------------------------

1.Admin must be authenticated against valid username and password
2.Add / Remove Merchants
3.View all Products
4.Add Product Category
5.APPROVE MERCHANT

------------------------------------------------------------------------------------------
Module 2: Merchant Login
------------------------------------------------------------------------------------------

1.New merchant self registration ( Submitted for admin approval post registration)
2.Merchant login authentication
3.Add products
4.Review / update products
5.View Frequent / Repeated customer
6.View Most sold product
7.View Sales Report

------------------------------------------------------------------------------------------
Module 3: User Login
------------------------------------------------------------------------------------------

1.New user self registration
2.User login authentication
3.View available products
4.Compare prices from different merchant
5.Add Products to cart
6.Checkout from wallet / COD
7.List all previous orders
8.View Purchase History

------------------------------------------------------------------------------------------
*/



import java.util.ArrayList;
import java.util.Scanner;
class Amazon{
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vendor> v = new ArrayList<>();
    static ArrayList<Customer> c = new ArrayList<>();
    static ArrayList<Product> p = new ArrayList<>();
    static ArrayList<String> signup = new ArrayList<>();
    static ArrayList<Integer> signc = new ArrayList<>();
    static ArrayList<Product> allp = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();
    static ArrayList<String> type = new ArrayList<>();
    static String vali="";
    static int index,index1,indexp,indexc,indexs;
    public static void main(String[]args){
        All.ven();
        All.cus();
        home();
    }
    public static void home(){
        System.out.println("\t\t\tWelcome !!!  \n\tplease select your Designation\n");
        System.out.println("1. Admin");
        System.out.println("2. Vendor");
        System.out.println("3. Customer");
        System.out.println("4. Exit");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                ahome();
                break;
            }
            case 2:{
                vhome();
                break;
            }
            case 3:{
                chome();
                break;
            }
            default:{
                System.out.println("See you again later");
                break;
            }
        }
    }//ADMIN
    public static void ahome(){
        System.out.println("UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        flush();
        if(name.equals("admin") && password.equals("12345")) trueadmin();
        else{
            System.out.println("Please Enter Valid Login Credentials");
            home();
        }
    }
    public static void trueadmin(){
        System.out.println("Welcome !!!\n");
        System.out.println("1. Add Vendor");
        System.out.println("2. Remove Vendor");
        System.out.println("3. Approve");
        System.out.println("4. View Vendor");
        System.out.println("5. Exit");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                vadd();
                trueadmin();
                break;
            }
            case 2:{
                vrem();
                trueadmin();
                break;
            }
            case 3:{
                vcheck();
                trueadmin();
                break;
            }
            case 4:{
                viewVendor();
                trueadmin();
                break;
            }
            default:{
                home();
                break;
            }
        }
    }
    public static void vadd(){
        System.out.println("Enter Vendor name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter password");
        String pass = scanner.nextLine();
        int id = v.size()+1;
        System.out.println("Enter Type");
        scanner.nextLine();
        String type = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        ArrayList<Product> pro = new ArrayList<>();
        v.add(new Vendor(name,pass,id,type,pro));
        System.out.println("Vendor added Successfully ");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        
        String s = scanner.nextLine();
        flush();     
    }
    public static void vrem(){
        System.out.println("Enter Vendor name");
        scanner.nextLine();
        String pn = scanner.nextLine();
        for(int i=0;i<v.size();i++){
            if(v.get(i).name.equals(pn)){
                v.remove(i);
                break;
            }
        }
        System.out.println("Vendor removed Successfully ");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        flush();
    }
    public static void viewVendor() {
        for(int i=0;i<v.size();i++){
            System.out.println(v.get(i).name+"\t"+v.get(i).id+"\t"+v.get(i).password+"\t"+v.get(i).type);
        }
    }
    public static void vcheck(){
        for(int i=0;i<signup.size();i++){
            System.out.println(signup.get(i));
            scanner.nextLine();
            String st = scanner.nextLine();
            if(st.equals("yes")){
                signc.set(i,1);
                System.out.println("Approved");
            }
            else if(st.equals("wait")){
                System.out.println("Waiting");
            }
            else{
                signc.set(i,0);
                System.out.println("Declined");
            }
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        flush();
    }//VENDOR
    public static void vhome(){
        System.out.println("Welcome !!!\n");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Cancel");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                vsignin();
                break;
            }
            case 2:{
                vsignup();
                break;
            }
            case 3:{
                home();
                break;
            }
            default:{
                System.out.println("Wrong choice");
                break;
            }
        }
    }
    public static void vsignin(){
        System.out.println("UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        if(checkVen(name,password)){
            System.out.println("press ENTER to continue !!! ");
            String s = scanner.nextLine();
            flush();
            trueven();
        }
        else{
            vali=name+" "+password+" ";
            if(signup.isEmpty() || signc.isEmpty()){
                System.out.println("Please Enter Valid Login Credentials\n If your are new Vendor please Singup");
                String s=scanner.nextLine();
                flush();
                vhome();
            }
            else if(checkSignUp(vali) && signc.get(index1)==-1){
                System.out.println("Waiting for approval");
                System.out.println("press ENTER to continue !!! ");
                scanner.nextLine();
                String s = scanner.nextLine();
                flush();
                vhome();
            }
            else if(signc.get(index1)==1){
                    signc.remove(index1);
                    signup.remove(index1);
                    index=-1;
                    int ar=v.size()+1;
                    scanner.nextLine();
                    System.out.println("Enter the type of Product you are Selling");
                    String st = scanner.nextLine();
                    ArrayList<Product> pro = new ArrayList<>();
                    v.add(new Vendor(name,password,ar,st,pro));
                    flush();
                    trueven();
            } 
        }
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        flush();
    }
    public static void trueven(){
        System.out.println("Welcome !!!\n");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. View Product Details");
        System.out.println("4. Edit Product Details");
        System.out.println("5. Exit");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                padd();
                trueven();
                break;
            }
            case 2:{
                prem();
                trueven();
                break;
            }
            case 3:{
                System.out.println("Name\ttype\tprice\tquant\tsale\tret\toffers\twarranty\n");
                pview();
                trueven();
                break;
            }
            case 4:{
                editPro();
                trueven();
                break;
            }
            default:{
                home();
                break;
            }
        }
    }
    public static void padd(){
        System.out.println("Enter Product name");
        scanner.nextLine();
        String pn = scanner.nextLine();
        System.out.println("Enter Product type");
        String t = scanner.nextLine();
        if(!type.contains(t)) type.add(t);
        System.out.println("Enter the Price of the Product");
        int pp = scanner.nextInt();
        System.out.println("Enter the Quantity of the Product");
        int q = scanner.nextInt();
        System.out.println("Enter the no of days to return (if no return : -1)");
        int ret = scanner.nextInt();
        System.out.println("Enter the offers");
        int offer = scanner.nextInt();
        System.out.println("Enter the Waranty of the Product");
        int waranty = scanner.nextInt();
        v.get(index).pro.add(new Product(pn, t, pp, q, 0,ret,waranty,offer));
        allp.add(new Product(pn, t, pp, q, 0,ret,waranty,offer));
        System.out.println("Product Added Successfully ");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        flush();
    }
    public static void prem(){
        System.out.println("Enter Product name");
        scanner.nextLine();
        String pn = scanner.nextLine();
        for(int i=0;i<v.get(index).pro.size();i++){
            if(v.get(index).pro.get(i).name.equals(pn)){
                v.get(index).pro.remove(i);
                break;
            }
        }
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.equals(pn)){
                allp.remove(i);
                break;
            }
        }
        System.out.println("Product removed Successfully ");
        System.out.println("press ENTER to continue !!! ");
        scanner.nextLine();
        String s = scanner.nextLine();
        flush();
    }
   public static void pview(){
        for(int i=0;i<v.get(index).pro.size();i++){
            System.out.println(v.get(index).pro.get(i));
        }
        System.out.println("\nPress Enter to continue");
        scanner.nextLine();
        String st = scanner.nextLine();
        flush();
    }
    public static boolean checkVen(String name,String password){
        for(int i=0;i<v.size();i++){
            if(v.get(i).name.equals(name) && v.get(i).password.equals(password)){
                index=i;
                return true;
            }
        }
        return false;
    }
    public static void editPro() {
        System.out.println("Enter the product name : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        if(checkpro(v.get(index).pro,name)) trueedit();
        else{
            System.out.println("Wrong product name ");
            trueven();
        }
        flush();
    }
    public static void trueedit(){
        System.out.println("Choose the detail to edit");
        System.out.println("1. Name of the product");
        System.out.println("2. Type of the product");
        System.out.println("3. Price of the product");
        System.out.println("4. Quantity of the product");
        System.out.println("5. Offers for the product");
        System.out.println("6. return days of the product");
        System.out.println("7. Waranty of the product");
        System.out.println("8. Exit");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                System.out.println("Enter new Name : ");
                scanner.nextLine();
                String n = scanner.nextLine();
                v.get(index).pro.get(indexp).name=n;
                allp.get(indexs).name=n;
                break;
            }
            case 2:{
                System.out.println("Enter new Type : ");
                scanner.nextLine();
                String n = scanner.nextLine();
                v.get(index).pro.get(indexp).type=n;
                allp.get(indexs).type=n;
                break;
            }
            case 3:{
                System.out.println("Enter new Price : ");
                int n = scanner.nextInt();
                v.get(index).pro.get(indexp).price=n;
                allp.get(indexs).price=n;
                break;
            }
            case 4:{
                System.out.println("Enter new Quantity : ");
                int n = scanner.nextInt();
                v.get(index).pro.get(indexp).quant=n;
                allp.get(indexs).quant=n;
                break;
            }
            case 5:{
                System.out.println("Enter new Offer : ");
                int n = scanner.nextInt();
                v.get(index).pro.get(indexp).offer=n;
                allp.get(indexs).offer=n;
                break;
            }
            case 6:{
                System.out.println("Enter new Return : ");
                int n = scanner.nextInt();
                v.get(index).pro.get(indexp).ret=n;
                allp.get(indexs).ret=n;
                break;
            }
            case 7:{
                System.out.println("Enter new Waranty : ");
                int n = scanner.nextInt();
                v.get(index).pro.get(indexp).waranty=n;
                allp.get(indexs).waranty=n;
                break;
            }
            default :{
                System.out.println("enter a valid choice ");
            }
        }
    }
    public static boolean checkpro(ArrayList<Product> pro,String name){
        for(int i=0;i<pro.size();i++){
            if(pro.get(i).name.equals(name)){
                indexp=i;
                return true;
            }
        }
        return false;
    }
    public static void vsignup(){
            System.out.println("UserName : ");
            scanner.nextLine();
            String name = scanner.nextLine();           
            System.out.println("Password : ");
            String password = scanner.nextLine();
            if(checkVen(name,password)) {
                System.out.println("You have signup already");     
                vhome();
            }
            else{
                vali=name+" "+password+" ";
                if(checkSignUp(vali)){                  
                    if(signc.get(index1)==1){ 
                        signc.remove(index1);
                        signup.remove(index1);
                        index=-1;
                        int ar = v.size()+1;
                        System.out.println("Enter the type of Product you are Selling");
                        String st = scanner.nextLine();
                        ArrayList<Product> pro = new ArrayList<>();
                        v.add(new Vendor(name,password,ar,st,pro));
                        flush();
                        vhome();
                    }
                    else if(signc.get(index1)==-1){
                        System.out.println("Waiting for approval");
                        vhome();
                    }
                    else {
                        System.out.println("Sorry u are not authorized");
                        vhome();
                    }
                }
                else{
                    signup.add(vali);
                    signc.add(-1);
                    System.out.println("Waiting for approval");
                    String s=scanner.nextLine();
                    flush();
                    vhome();
                }
            }
    }
    public static boolean checkSignUp(String vali){
        for(int i=0;i<signup.size();i++){
            if(signup.get(i).equals(vali)){
                index1=i;
                return true;
            }
        }
        return false;
    }
    public static void chome() {
        System.out.println("Welcome !!!\n");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Cancel");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                csignin();
                break;
            }
            case 2:{
                csignup();
                break;
            }
            case 3:{
                home();
                break;
            }
            default:{
                System.out.println("Wrong choice");
                break;
            }
        }
    }
    public static void csignin() {
        System.out.println("UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        if(checkcus(name,password)){ 
            System.out.println("press ENTER to continue !!! ");
            String s = scanner.nextLine();
            flush();
            truecus();
        }
        else{
            System.out.println("Wrong login Credentials");
            chome();
        }
    }
    public static void csignup() {
        System.out.println("UserName : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        flush();
        if(checkcus(name,password)){ 
            System.out.println("Already signed in");
            chome();
        }
        else{
            c.add(new Customer(name, password,new ArrayList<>(),0,new ArrayList<>()));
            System.out.println("Account created sucessfully");
            chome();
        }
    }
    public static boolean checkcus(String name,String password) {
        for(int i=0;i<c.size();i++){
            if(c.get(i).name.equals(name) && c.get(i).password.equals(password)){
                indexc=i;
                return true;
            }
        }
        return false;
    }
    public static void truecus() {
        System.out.println("Welcome !!!");
        System.out.println("1. Search products");
        System.out.println("2. Filter product");
        System.out.println("3. View cart");
        System.out.println("4. view OrderList");
        System.out.println("5. Compare Products");
        System.out.println("6. Exit");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                search();
                break;
            }
            case 2:{
                filter();
                break;
            }
            case 3:{
                cart();
                break;
            }
            case 4:{
                order();
                break;
            }
            case 5:{
                compare();
                truecus();
                break;
            }
            default :{
                chome();
                break;
            }
        }
    }
    public static void search(){
        scanner.nextLine();
        System.out.println("Search for the product : ");
        String s = scanner.nextLine();
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.contains(s)){
                System.out.println(allp.get(i).name);
            }
        }
        System.out.println("Select a product");
        String g = scanner.nextLine();
        int check=0;
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.equals(g)){
                indexs=i;
                check=1;
                break;
            }
        }
        if(check==1) proConfirm();
        else{
            System.out.println("No such product found");
        }
        truecus();
    }
    public static void filter(){
        for(int i=0;i<type.size();i++){
            System.out.println((i+1)+" "+type.get(i));
        }
        System.out.println("Select a filter");
        int g = scanner.nextInt();
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).type.equals(type.get(g-1))){
                System.out.println(allp.get(i).name);
            }
        }
        scanner.nextLine();
        System.out.println("Select a product");
        String k = scanner.nextLine();
        int check=0;
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.equals(k)){
                indexs=i;
                check=1;
                break;
            }
        }
        if(check==1) proConfirm();
        else{
            System.out.println("No such product found");
        }
        truecus();
    }
    public static void proConfirm() {
        System.out.println("Name : "+allp.get(indexs).name);
        System.out.println("Price : "+allp.get(indexs).price);
        System.out.println("Price after offer : "+(double)(allp.get(indexs).price-(((double)allp.get(indexs).offer/100)*allp.get(indexs).price)));
        if(allp.get(indexs).ret>0) System.out.println("Return availablity : "+allp.get(indexs).ret+"days");
        else System.out.println("no return");
        System.out.println("Type : "+allp.get(indexs).type);
        if(allp.get(indexs).quant==0) System.out.println("Out of Stock");
        else if(allp.get(indexs).quant<10) System.out.println("Limited Stock");
        else System.out.println("Stock available\n");
        System.out.println("1. Add to cart");
        System.out.println("2. Go back");
        int a = scanner.nextInt();
        switch(a){
            case 1:
            acart();
            break;
            default :
            truecus();
            break;
        }
    }
    public static void acart() {
        c.get(indexc).cart.add(allp.get(indexs));
        System.out.println("Product added to cart");
        truecus();
    }
    public static void cart() {
        System.out.println("Product\tPrice\tOffer");
        for(int i=0;i<c.get(indexc).cart.size();i++){
            System.out.println(c.get(indexc).cart.get(i).name+"\t"+c.get(indexc).cart.get(i).price+"\t"+c.get(indexc).cart.get(i).offer);
        }
        System.out.println("1. Buy now");
        System.out.println("2. remove item");
        System.out.println("3. Go back");
        int a = scanner.nextInt();
        switch(a){
            case 1:{
                buynow();
                break;
            }
            case 2:{
                remitem();
                break;
            }
            default:{
                truecus();
                break;
            }
        }
    }
    public static void buynow() {
        int cost=0;
        for(int i=0;i<c.get(indexc).cart.size();i++){
            System.out.println("Order details");
            System.out.println("Product : "+c.get(indexc).cart.get(i).name);
            System.out.println("Price : "+(c.get(indexc).cart.get(i).price-(((double)c.get(indexc).cart.get(i).offer/100)*c.get(indexc).cart.get(i).price)));
            cost+=c.get(indexc).cart.get(i).price-((double)c.get(indexc).cart.get(i).offer/100)*c.get(indexc).cart.get(i).price;
            changeinvendor(c.get(indexc).cart.get(i).name);
            c.get(indexc).order.add(c.get(indexc).cart.get(i));
        }
        scanner.nextLine();
        System.out.println("Press Enter to confirm the order");
        String s1 = scanner.nextLine();
        if(cost<=c.get(indexc).wallet){
             c.get(indexc).wallet-=cost;
             System.out.println("Order was sucessfull");
             c.get(indexc).cart.clear();
        }
        else{
            System.out.println("Your wallet amount is low");
        }
        truecus();
    }
    public static void changeinvendor(String name) {
        a:for(int i=0;i<v.size();i++){
            for(int j=0;j<v.get(i).pro.size();j++){
                if(v.get(i).pro.get(j).name.equals(name)){
                    v.get(i).pro.get(j).sale+=1; 
                    v.get(i).pro.get(j).quant-=1;
                    break a;
                }
            }
        }
    }
    public static void remitem() {
        System.out.println("Enter the product name to remove");
        scanner.nextLine();
        String s = scanner.nextLine();
        for(int i=0;i<c.get(indexc).cart.size();i++){
            if(c.get(indexc).cart.get(i).name.equals(s)){
                c.get(indexc).cart.remove(i);
                break;
            }
        }
        truecus();
    }
    public static void order() {
        for(int i=0;i<c.get(indexc).order.size();i++){
            System.out.println(c.get(indexc).order.get(i).name);
            System.out.println(c.get(indexc).order.get(i).price);
        }
        System.out.println("\n1. Cancel product");
        System.out.println("2. Return product");
        System.out.println("3. Go back");
        int a = scanner.nextInt();
        flush();
        switch(a){
            case 1:{
                cancel();
                break;
            }
            case 2:{
                returnPro();
                break;
            }
            default:{
                truecus();
                break;
            }
        }
    }
    public static void cancel(){
        System.out.println("Enter the product name to cancel order");
        scanner.nextLine();
        String can = scanner.nextLine();
        for(int i=0;i<c.get(indexc).order.size();i++){
            if(c.get(indexc).order.get(i).name.equals(can)){
                c.get(indexc).order.remove(i);
                break;
            }
        }
        a:for(int i=0;i<v.size();i++){
            for(int j=0;j<v.get(i).pro.size();j++){
                if(v.get(i).pro.get(j).name.equals(can)){
                    v.get(i).pro.get(j).sale-=1; 
                    v.get(i).pro.get(j).quant+=1;
                    break a;
                }
            }
        }
        truecus();
    }
    public static void returnPro() {
        System.out.println("Enter the product name to Return");
        scanner.nextLine();
        String can = scanner.nextLine();
        for(int i=0;i<c.get(indexc).order.size();i++){
            if(c.get(indexc).order.get(i).name.equals(can)){
                c.get(indexc).order.remove(i);
                break;
            }
        }
        a:for(int i=0;i<v.size();i++){
            for(int j=0;j<v.get(i).pro.size();j++){
                if(v.get(i).pro.get(j).name.equals(can)){
                    v.get(i).pro.get(j).sale-=1; 
                    v.get(i).pro.get(j).quant+=1;
                    break a;
                }
            }
        }
        truecus();
    }
    public static void compare() {
        System.out.println("Enter the products name to compare");
        scanner.nextLine();
        System.out.print("1 --> ");
        String cmp1 = scanner.nextLine();
        System.out.print("2 --> ");
        String cmp2 = scanner.nextLine();
        ArrayList<Product> cp = new ArrayList<>();
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.equals(cmp1)){
                cp.add(allp.get(i));
                break;
            }
        }
        for(int i=0;i<allp.size();i++){
            if(allp.get(i).name.equals(cmp2)){
                cp.add(allp.get(i));
                break;
            }
        }
        System.out.print("Name :\t");
        System.out.print(cp.get(0).name+"\t\t");
        System.out.println(cp.get(1).name);
        System.out.print("Price :\t");
        System.out.print(cp.get(0).price+"\t\t");
        System.out.println(cp.get(1).price);
        System.out.print("Stock :\t");
        if(cp.get(0).quant==0) System.out.print("Out of stock \t");
        else if(cp.get(0).quant>10) System.out.print("Stock available\t");
        else System.out.print("Limited stocks\t");
        if(cp.get(1).quant==0) System.out.println("Out of stock ");
        else if(cp.get(1).quant>10) System.out.println("Stock available");
        else System.out.println("Limited stocks");
        System.out.print("Return :\t");
        System.out.print(cp.get(0).ret+"days\t\t");
        System.out.println(cp.get(1).ret+"days");
        System.out.println("Press Enter to go back");
        String s = scanner.nextLine();
    }
    public static void flush() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
class Vendor extends Amazon{
    String name,password,type;
    int id;
    ArrayList<Product> pro;
    Vendor(String name,String password,int id,String type,ArrayList<Product> pro){
        this.name=name;
        this.password=password;
        this.id=id;
        this.type=type;
        this.pro=new ArrayList<>(pro);
    }
}
class Product{
    String name,type;
    int price,quant,sale,waranty,offer,ret;
    Product(String name,String type,int price,int quant,int sale,int ret,int warranty,int offer){
        this.name=name;
        this.type=type;
        this.price=price;
        this.quant=quant;
        this.sale=sale;
        this.offer=offer;
        this.waranty=warranty;
        this.ret=ret;
    }
    public String toString(){
        return name+"\t"+type+"\t"+price+"\t"+quant+"\t"+sale+"\t"+ret+"\t"+offer+"\t"+waranty;
    }
}
class Customer extends Amazon{
    String name,password;
    int wallet;
    ArrayList<Product> cart,order;
    Customer(String name,String password,ArrayList<Product> cart,int wallet,ArrayList<Product> order){
        this.name=name;
        this.password=password;
        this.cart=new ArrayList<>(cart);
        this.wallet=wallet;
        this.order=new ArrayList<>(order);
    }
}
class All extends Amazon{
    public static void ven(){
        v.add(new Vendor("babu","1234",1,"sports",new ArrayList<>()));
        v.add(new Vendor("ramu","1243",2,"accesories",new ArrayList<>()));
        v.add(new Vendor("sedhu","2134",3,"clothing",new ArrayList<>()));
        v.add(new Vendor("achu","2143",4,"cosmetics",new ArrayList<>()));
    }
    public static void cus(){
        c.add(new Customer("rithik","1234",new ArrayList<>(),12000,new ArrayList<>()));
        c.add(new Customer("raghul", "1324",new ArrayList<>(),13000,new ArrayList<>()));
        c.add(new Customer("vishnu", "4132",new ArrayList<>(),14000,new ArrayList<>()));
        c.add(new Customer("moune", "3214",new ArrayList<>(),15000,new ArrayList<>()));
        c.add(new Customer("survesh", "2314",new ArrayList<>(),16000,new ArrayList<>()));
        c.add(new Customer("naresh", "2431",new ArrayList<>(),17000,new ArrayList<>()));
    }
}
