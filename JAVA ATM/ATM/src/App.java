import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO SBI ATM ");
        System.out.println("Enter : ");
        System.out.println("Username -> ");
        String uname = sc.nextLine();
        System.out.println("Password -> ");
        String pass = sc.nextLine();
        double amt;
        if (Atm.authenticate(uname, pass) == true) {
            int loop=0;
            while (loop!=4) {

                System.out.println("Enter :\n 1 -> Deposite \n 2 -> Withdrwal \n 3 -> Balance Enquiry \n 4 -> Quit ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Deposie ->");
                        System.out.print("Enter the Amount ->");
                        amt=sc.nextDouble();
                        Atm.deposit(uname,amt);
                        break;
                    case 2:
                        System.out.println("Withdrwal ->");
                        System.out.print("Enter the Amount ->");
                        amt=sc.nextDouble();
                        Atm.withdraw(uname, amt);
                        break;
                    case 3:
                    System.out.println("Balace Enquiry ->");
                    double avlbal=Atm.getBalance(uname);
                    if(avlbal==-1){
                        System.out.println("User not found !");
                    }else{
                        System.out.print("Available Balace ->"+ avlbal);
                    }
                    break;
                    case 4:
                        loop=4;
                        System.out.println("Thank you for visiting :)");
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("Invalid Username and Password :)");
        }

        sc.close();
    }
}
