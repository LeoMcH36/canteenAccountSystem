package p3a1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCanteenAccMenu {

    public static void main(String[] args) {

        String[] menuOptions = {"1. Top up money", "2. Pay for meal", "3. Account Status", "4. Account Balance", "5. Display Full Account details",
            "6. Update Credit Limit", "7. Update minimum top up", "8. Exit"};

        Menu myMenu = new Menu("Canteen Account", menuOptions);

        CanteenAcc cAcc1 = new CanteenAcc("120", "Jane Smith", 50.00);
        
        int option = 0;
        do {
            try { 

                Scanner kb = new Scanner(System.in);
                option = myMenu.getChoice();
                switch (option) {
                    case 1:
                        System.out.println("Top up Account");
                        double deposit;

                        System.out.println("Please enter how much you would like to deposit in £ ");
                        deposit = kb.nextDouble();
                        try {
                            cAcc1.topUp(deposit);
                             System.out.println("Account Balance Successfully Topped Up");
                        }//try
                        catch (Exception ex) {
                            System.out.println(ex.toString());
                        }//catch
                       
                        break;
                    case 2:
                        System.out.println("Pay for meal");

                        double amount;
                        System.out.println("Please enter the cost of the meal in £ ");
                        amount = kb.nextDouble();
                        try {
                            cAcc1.payForMeal(amount);
                            System.out.println("Payment Successful");
                        } //try
                        catch (Exception ex) {
                            System.out.println(ex.toString());
                        }//catch
                        break;
                    case 3:
                         System.out.println("Account Status:");
                        System.out.println(cAcc1.getStatus());

                        break;
                    case 4:
                         System.out.println("Account Balance:");
                        System.out.println("£" + cAcc1.getBalance());
                        break;
                    case 5:
                        System.out.println("Account Details");
                        System.out.println("****************");
                        System.out.println(cAcc1.displayAccountDetails());
                        break;
                    case 6:
                        System.out.println("Update credit limit:");
                        double creditLimit;
                        System.out.println("Please enter the updated credit limit in £ ");

                        creditLimit = kb.nextDouble();

                        cAcc1.updateCreditLimit(creditLimit);

                        System.out.println("Updated Credit Limit: £" + cAcc1.getCreditLimit() * -1); //to display as a positive number

                        break;
                    case 7:
                        System.out.println("Update Minimum top up:");
                        double minTopup;
                        System.out.println("Please enter the updated minimum top up £ ");
                        minTopup = kb.nextDouble();
                        try {
                            cAcc1.updateMinTopup(minTopup);
                            System.out.println("Updated Minimum top up: £" + cAcc1.getMinTopup());
                        } //try
                        catch (Exception ex) {
                            System.out.println(ex.toString());
                        }//catch
                        
                        break;
                    case 8:
                        System.out.println("Program ended");
                        break;
                    default:
                        System.out.println("Invalid option");
                }//switch

            } //try for non integer inputs
            catch (InputMismatchException ex) {
                System.out.println("Invalid input ");
            }//catch
        } while (option != 8); //do while
    }//main
}//class
