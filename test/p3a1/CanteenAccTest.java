/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @info J-Unit test for Canteen Account Contains tests for methods in the
 * CanteenAcc object class
 * @author Leo McHugh
 * @version 1.0
 * @since 26/10/2019
 */
public class CanteenAccTest {

    public CanteenAccTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of topUp method, of class CanteenAcc. For depositing an amount
     * greater than the minimum top up value.
     */
    @Test
    public void testTopUp1()  {
        System.out.println("topUp1");
        double depositAmount = 10.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try
        {
          instance.topUp(depositAmount);  
        }
        catch(Exception ex)
        {
            
        }
        double expResult = 60;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of topUp method, of class CanteenAcc. For depositing an amount less
     * than the minimum top up value.
     */
    @Test
    public void testTopUp2()  {
        System.out.println("topUp2");
        double depositAmount = -9.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try {
            instance.topUp(depositAmount);
        } catch (Exception ex) {

        }
        double expResult = 50;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of payForMeal method, of class CanteenAcc.
     * When paying for a meal and not going into credit.
     *
     */
    @Test
    public void testPayForMeal1() {
        System.out.println("payForMeal1");
        double amount = 10.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try {
            instance.payForMeal(amount);
        } catch (Exception ex) {

        }
        double expResult = 40;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    @Test
    /**
     * Test of payForMeal method, of class CanteenAcc. 
     * When paying for a meal and going into credit.
     */
    public void testPayForMeal2()  {
        System.out.println("payForMeal2");
        double amount = 51.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try {
            instance.payForMeal(amount);
        } catch (Exception ex) {

        }
        double expResult = -1;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    @Test
    /**
     * Test of payForMeal method, of class CanteenAcc. 
     * When attempting to pay for a meal that would exceed credit limit.
     */
    public void testPayForMeal3() {
        System.out.println("payForMeal3");
        double amount = 100.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try {
            instance.payForMeal(amount);
        } catch (Exception ex) {

        }
        double expResult = 50;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    @Test
    /**
     * Test of payForMeal method, of class CanteenAcc. 
     * When attempting to pay for a meal and entering a negative value.
     */
    public void testPayForMeal4()  {
        System.out.println("payForMeal4");
        double amount = -10.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try {
            instance.payForMeal(amount);
        } catch (Exception ex) {

        }
        double expResult = 50;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of displayAccountDetails method, of class CanteenAcc. 
     * For retrieving the full details of an account.
     */
    @Test
    public void testDisplayAccountDetails() {
        System.out.println("displayAccountDetails");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        String expResult = "ID: 120\nname: Jane Smith\nAccount Status: valid\nAccount Balance: £50.0\nMinimum TopUp: £2.0\nCredit Limit: £5.0\nAmount of transactions: 0";
        String result = instance.displayAccountDetails();
        assertEquals(expResult, result);

    }

    /**
     * Test of getBalance method, of class CanteenAcc. 
     * For retrieving the balance of a existing Account
     */
    @Test
    public void testGetBalance1() {
        System.out.println("getBalance1");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        double expResult = 50.00;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getBalance method, of class CanteenAcc. 
     * For retrieving the balance of a new Account
     */
    @Test
    public void testGetBalance2() {
        System.out.println("getBalance2");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith");
        double expResult = 0.00;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getCreditLimit method, of class CanteenAcc. 
     * For retrieving the credit limit of an account
     */
    @Test
    public void testGetCreditLimit() {
        System.out.println("getCreditLimit");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        double expResult = -5.00;
        double result = instance.getCreditLimit();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getMinTopup method, of class CanteenAcc. 
     * For retrieving the minimum top up of an account.
     */
    @Test
    public void testGetMinTopup() {
        System.out.println("getMinTopup");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        double expResult = 2.0;
        double result = instance.getMinTopup();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getStatus method, of class CanteenAcc.
     * for retrieving the status of an account that is valid
     */
    @Test
    public void testGetStatus1() {
        System.out.println("getStatus1");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        String expResult = "valid";
        String result = instance.getStatus();
        assertEquals(expResult, result);
 
    }

     /**
     * Test of getStatus method, of class CanteenAcc.
     * for retrieving the status of an account that is in credit.
     */
    @Test
    public void testGetStatus2() {
        System.out.println("getStatus2");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        String expResult = "credit";
        double amount = 51;
        try {
            instance.payForMeal(amount);
        } catch (Exception ex) {

        }
        String result = instance.getStatus();
        assertEquals(expResult, result);

    }

    /**
     * Test of updateCreditLimit method, of class CanteenAcc.
     * for updating the credit limit of an account.
     */
    @Test
    public void testUpdateCreditLimit() {
        System.out.println("updateCreditLimit");
        double credlim = -6;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        instance.updateCreditLimit(credlim);
        double result = instance.getCreditLimit();
        assertEquals(credlim, result, 0.0);

    }

    /**
     * Test of updateMinTopup method, of class CanteenAcc.
     * to update the minimum top up of an account.
     */
    @Test
    public void testUpdateMinTopup1() {
        System.out.println("updateMinTopup1");
        double minTop = 3.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try
        {
        instance.updateMinTopup(minTop);
        }
        catch(Exception ex)
        {
           
        }
        double result = instance.getMinTopup();
        assertEquals(minTop, result, 0.0);

    }
     /**
     * Test of updateMinTopup method, of class CanteenAcc.
     * to try update the minimum top up of an account with a negative value.
     */
    @Test
    public void testUpdateMinTopup2() {
        System.out.println("updateMinTopup2");
        double minTop = -3.0;
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        try
        {
        instance.updateMinTopup(minTop);
        }
        catch(Exception ex)
        {
           
        }
        double result = instance.getMinTopup();
        assertEquals(2.0, result, 0.0);

    }

    /**
     * Test of getStatistics method, of class CanteenAcc.
     * For the retrieval of the Accounts Statistics.
     */
    @Test
    public void testGetStatistics() {
        System.out.println("getStatistics");
        CanteenAcc instance = new CanteenAcc("120", "Jane Smith", 50.00);
        String expResult = "Amount of transactions: 0\nAccount Balance: £50.0\nAccount Status: valid";
        System.out.println(instance.getStatistics());
        String result = instance.getStatistics();
        assertEquals(expResult, result);

    }

}
