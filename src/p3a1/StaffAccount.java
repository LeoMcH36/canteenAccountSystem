package p3a1;

public class StaffAccount extends CanteenAcc {

    private double discountRate;

    public StaffAccount(String newId, String newName, double discountRate) {
        super(newId, newName);
        this.discountRate = discountRate;
    }//StaffAccount

    public void setDiscountRate(double rate) {
        discountRate = rate;
    }//setDiscountRate

    public double getDiscountRate() {
        return discountRate;
    }//getDiscountRate

    @Override
    public void payForMeal(double amount) throws Exception {

        if ("valid".equals(super.getStatus())) //if the account status is valid
        {
            super.payForMeal(amount * discountRate);//use discount rate
        } //if
        else {
            super.payForMeal(amount);//dont use discount rate
        }//else

    }//payForMeal

    @Override
    public String displayAccountDetails() {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Staff Account");
        sb1.append(super.displayAccountDetails() + "\n");
        sb1.append("Discount Rate: " + discountRate);
        sb1.append("\n");
        return sb1.toString();
    }//displayAccountDetails
}
