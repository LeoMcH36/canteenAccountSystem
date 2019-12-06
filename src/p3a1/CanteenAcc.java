package p3a1;

/**
 * An object class for a canteen account Contains methods to interact with the object class
 * @author Leo McHugh
 * @version 1.0
 * @since 21/10/2019
 */
public class CanteenAcc {

    private String customerID, name, status;
    private double balance;
    private static double minTopup;
    private static double creditLimit;
    private int transCount;

    /**
     * Constructor to initiate a Canteen Account Object for existing customers.
     *
     * @param newId - String
     * @param newName - String
     * @param newBalance - double
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public CanteenAcc(String newId, String newName, double newBalance) {
        customerID = newId;
        name = newName;
        balance = newBalance;
        status = "valid";
        creditLimit = -5.00;
        minTopup = 2.00;
        transCount = 0;
    }//canteenAcc

    /**
     * Constructor to initiate a Canteen Account Object for a new customer.
     *
     * @param newId - String
     * @param newName - String
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public CanteenAcc(String newId, String newName) {
        customerID = newId;
        name = newName;
        status = "valid";
        balance = 0;
        transCount = 0;
        creditLimit = -5.00;
        minTopup = 2.00;
    }//canteenAcc bankaccount

    /**
     * Method to top up the account's balance.
     *
     * @param depositAmount - double
     * @throws Exception if the top up amount is below the minimum or negative
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public void topUp(double depositAmount) throws Exception {
        if(depositAmount > 0)
        {
        if (depositAmount >= minTopup) {
            this.balance += depositAmount;
            if (balance >= 0.0) {
                status = "Valid";
            } //if
            else {
                status = "credit";
            }//else
        }//if
        else {
            throw new Exception("\nBelow Minimum Topup");
        }//else
        }
        else
        {
            throw new Exception("\nMust be a postive value");
        }

    }//topUp

    /**
     * A method to pay for a meal,taking money from the balance.
     *
     * @param amount - double
     *
     * @throws Exception - when the purchase puts the account into credit and
     * when the cost of the purchase exceeds the credit limit
     */
    public void payForMeal(double amount) throws Exception {
        if(amount > 0) {

            if ((balance - amount) < 0 && (balance - amount) > creditLimit) {

                balance -= amount;
                status = "credit";
                transCount++;
                throw new Exception("\nPurchase successful however you must top up your balance");
            }//if
            else if ((balance - amount) < 0 && (balance - amount) < creditLimit) {

                throw new Exception("\nCost Exceeds Credit Limit");

            }//else if
            else {
                balance -= amount;
                transCount++;
            }//else
        }//if
        else
        {
            throw new Exception("\nMust not be a negative value");
        }
            
        
    }//payForMeal

    /**
     * Method to return the account details.
     *
     * @return String
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public String displayAccountDetails() {
        StringBuilder sb1 = new StringBuilder();

        sb1.append("ID: " + customerID);
        sb1.append("\n");
        sb1.append("name: " + name);
        sb1.append("\n");
        sb1.append("Account Status: " + status);
        sb1.append("\n");
        sb1.append("Account Balance: £" + balance);
        sb1.append("\n");
        sb1.append("Minimum TopUp: £" + minTopup);
        sb1.append("\n");
        //so credit limit is printed as a positive number
        if (creditLimit < 0) {
            sb1.append("Credit Limit: £" + (creditLimit * -1));
        } else {
            sb1.append("Credit Limit: £" + creditLimit);
        }

        sb1.append("\n");
        sb1.append("Amount of transactions: " + transCount);
        return sb1.toString();
    }//displayAccountDetails

    /**
     * Getter method to return the account balance.
     *
     * @return double
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public double getBalance() {
        return balance;
    }//getBalance

    /**
     * Getter method to return the account credit limit
     *
     * @return double
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public double getCreditLimit() {
        return creditLimit;
    }//getCreditLimit

    /**
     * Getter method to return the account's minimum top up requirement.
     *
     * @return double
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public double getMinTopup() {
        return minTopup;
    }//getMinTopup

    /**
     * Getter method to return the account status.
     *
     * @return String
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public String getStatus() {
        return status;
    }//getStatus

    /**
     * Setter method to update the account's credit limit.
     *
     * @param credlim - double
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public void updateCreditLimit(double credlim) {
        //so credit is always negative
        if (credlim > 0) {
            creditLimit = (credlim * -1);
        } else {
            creditLimit = credlim;
        }
    }//updateCreditLimit

    /**
     * Setter method to update the account's credit limit.
     *
     * @param minTop - double
     * @throws Exception if negative value entered
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public void updateMinTopup(double minTop) throws Exception{
        if(minTop >= 0) //to stop negative inputs
        {
           minTopup = minTop; 
        }
        else
        {
           throw new Exception("\nMust be a positive value"); 
        }
        
    }//updatMinTopup
/**
     * Getter method to return the account's statistics.
     *
     * @return String
     * @since 21/10/2019
     * @author Leo McHugh
     */
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amount of transactions: " + transCount);
        sb.append("\n");
        sb.append("Account Balance: £" + balance);
        sb.append("\n");
        sb.append("Account Status: " + status);
        return sb.toString();

    }//getStatistics
}//class
