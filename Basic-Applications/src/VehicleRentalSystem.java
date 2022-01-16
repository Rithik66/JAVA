public class VehicleRentalSystem {
    public static void main(String[]args){
        home();
    }
    public static void home() {
        System.out.println("Welcome to the APPLICATION");
        System.out.println("1. Admin login");
        System.out.println("2. Borrower login");
        System.out.println("2. exit");
        int a = scanner.nextInt();
        if(a==1) home();
        else System.exit(1);
    }
    public static void AdminHome() {
        scanner.nextLine();
        System.out.println("Enter your name ");
        String name = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if(checkFriend(name,password)){
            System.out.println("Logged in successfully");
            enter();
            clear();
            trueLogin();
        }
        else{
            System.out.println("Invalid credentials");
            menu();
        }
    }
}
