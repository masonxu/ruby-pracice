package com.augmentum.training.java;
/**
 * The class <code>Bank</code> is used for manage <code>Account </code>
 * @author   mason.xu
 * @version 1.0 , 03/10/2011
 */
public class Bank {
    
    private static final float exchangeRate = Const.EXCHANGE_RATE;
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        BankAccount ba1 = new BankAccount("Mason", 100000, 100000);
        BankAccount ba2 = new BankAccount("Xu", 200000, 200000);
      
        System.out.println("Initial states.");
        ba1.printAccountInfo();
        ba2.printAccountInfo();
        System.out.println();
        
        /**
         * TODO Test depositting money.
         */
        ba1.depositRmb(50000);
        ba2.depositDollar(1000);
        System.out.println("After Deposit ");
        ba1.printAccountInfo();
        ba2.printAccountInfo();
        System.out.println();
        
        testWithDraw(ba1, ba2);         
        testTransferToSelf(ba1);
        testTransferToOther(ba1, ba2); 
    }
    
    /**
     * Test withdraw money.
     * @param ba1
     * @param ba2
     */
    public static void testWithDraw(BankAccount ba1, BankAccount ba2) {
        try {
            ba1.withdrawDollar(540000);
            ba2.withdrawRmb(6000);
        } catch (AccountException e) {
            //e.printStackTrace();
            System.out.println("**ERROR: " + e.getMessage());
          
        } 
        ba1.printAccountInfo();
        ba2.printAccountInfo();
        
    }
    
    
    /**
     * Test Transfer To Self.
     * @param ba1
     * @param ba2
     */
    public static void testTransferToSelf(BankAccount ba1) {
        /**
         * TODO Transfer from A to A.
         */
        try {
            ba1.transferAccount(ba1, 10000, Const.RMB_TYPE);
        } catch (AccountException e) {
          //e1.printStackTrace();
            System.out.println("**ERROR: " + e.getMessage());
        } 
    }
    
    /**
     * Test to Transfer RMB from ba1 to ba2 , and the total amount 
     * of RMB and dollar is not enough for tranferring.
     * @param ba1
     * @param ba2
     */
    public static void testTransferToOther(BankAccount ba1,BankAccount ba2) {
        try {
            ba1.transferAccount(ba2, 30000000, Const.RMB_TYPE);
        } catch (AccountException e) {
          //e1.printStackTrace();
            System.out.println("**ERROR: " + e.getMessage());
        }      
    }
    
    
    /**
     *  Get the exchangeRate.
     */
    public float getExchangeRate() {
        return exchangeRate;
    }
    
    
    
}
