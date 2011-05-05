package com.augmentum.training.java;

import java.text.DecimalFormat;
import java.util.UUID;


/**
 * Use <code>BankAccount</code> to manage the account of bank.
 * The class includes three members. They are id,the name of account,
 * the amount of RMB and the amount of dollar. And not only can deposit 
 * and withdraw money in the form of RMB or dollar,  but also query 
 * the balance in the form of RMB or dollar. In addition, the class 
 * of Account gave the method of transferring account.
 *
 * @author mason.xu
 * @version 1.0,  03/10/2011
 * @see java.text.DecimalFormat
 * @see java.util.UUID
 */
public class BankAccount {
   
    private UUID accountId;
    private String accountName;
    private double amountRmb;
    private double amountDollar;
   
    /**
     * Create an account. Both amountRmb and amountDollar
     * are initialized by zero.
     * @param accountName
     */
    public BankAccount(String accountName) {
        this.accountId = UUID.randomUUID();
        this.accountName = accountName;
        this.amountRmb = Const.INITIAL_AMOUNT;
        this.amountDollar = Const.INITIAL_AMOUNT;
    }
  
    /**
     * Create an account. 
     * @param accountName
     * @param amountRmb
     * @param amountDollar
     */
    public BankAccount(String accountName, double amountRmb, double amountDollar) {
        this.accountId = UUID.randomUUID();
        this.accountName = accountName;
        this.amountRmb = amountRmb;
        this.amountDollar = amountDollar;
    }
    
    /**
     * Transfer money from one account to other account.
     * @param BankAccount
     * @param amount
     * @param type
     * @return boolean
     */
    public boolean transferAccount(BankAccount ba, double amount, 
                                   String type) throws AccountException {
       
        if (this.accountId.equals(ba.accountId)) {
            
            //The same account do not transfer.
            throw new AccountException(" The same account can not transfer!");   
        } else {
            /**
             *  No matther what money, transeferring money from A to B,
             *  means that A withdraw money firstly, B deposit money secondly.
             */
            if (Const.RMB_TYPE.equals(type)) {
               this.withdrawRmb(amount);
               ba.depositRmb(amount);
            } else {
               this.withdrawDollar(amount);
               ba.depositDollar(amount);
            }
        }
        
        
        return true;
    }
    
    /**
     * Deposit RMB
     * @param  amount double
     */
    public boolean depositRmb(double amount) {
        String s = formatAmount(amount);
        double d = Double.parseDouble(s);
        this.amountRmb = this.amountRmb + d;
     
        return true;
    }
    
    /**
     * Deposit Dollar
     * @param amount 
     */
    public boolean depositDollar(double amount) {
        String s = formatAmount(amount);
        double d = Double.parseDouble(s);
        this.amountDollar = this.amountDollar + d;
     
        return true;
    }
    
    /**
     * Withdraw RMB
     * @param amount
     * @return
     * @throws AccountException 
     */
    public boolean withdrawRmb(double amount) throws AccountException {
        String s = formatAmount(amount);
        double d = Double.parseDouble(s);
        
        if (this.amountRmb < d) {
            
            //The amount of RMB is not enough for withdrawal.
            float exchangeRate = new Bank().getExchangeRate();
            
            if ((this.amountRmb + (this.amountDollar * exchangeRate)) < d) {
                
                //The total amount of RMB and Dollar is not enough for withdrawal.
                throw new AccountException("The balance is not enough!");
            } else {
                double d1 = d - this.amountRmb;  //get the shortage of RMB
                this.amountDollar = this.amountDollar - (d1 / exchangeRate);
                this.amountRmb = Const.INITIAL_AMOUNT;
                
                return true;
            }
        } else {
            this.amountRmb = this.amountRmb - d;
            return true;
        }        
       
    }
    
    /**
     * Withdraw dollar
     * @param amount
     * @return
     * @throws AccountException 
     */
    public boolean withdrawDollar(double amount) throws AccountException {
        String s = formatAmount(amount);
        double d = Double.parseDouble(s);
        if (this.amountDollar < d) {
            
            //The amount of Dollar is not enough for withdrawal.
            float exchangeRate = new Bank().getExchangeRate();
            
            if (((this.amountRmb / exchangeRate) + this.amountDollar ) < d) {
                
                //The total amount of RMB and Dollar is not enough for withdrawal.
                throw new AccountException("The balance is not enough!");
            } else {
                double d1 = d - this.amountDollar;  //get the shortage of Dollar
                this.amountRmb = this.amountRmb - (d1 * exchangeRate);
                this.amountDollar = Const.INITIAL_AMOUNT;
                
                return true;
            }
        } else {
            this.amountDollar = this.amountDollar - d;
            return true;
        }  
    }
    /**
     * Print the infomation of the Account.
     */
    public void printAccountInfo() {
        System.out.println("--------------------ACCOUNT INFO------------------------");       
        System.out.println("BankAccountID : " + this.accountId);
        System.out.println("BankAccountName : " + this.accountName);
        System.out.println("The Balance of RMB : " + formatAmount(this.amountRmb));
        System.out.println("The Balance of Dollar :" +formatAmount(this.amountDollar));
        System.out.println("---------------------END--------------------------------\n");       
    }
    
    /**
     * Format the amount likes "####.00"
     * @param amount
     * @return
     */
    public String formatAmount(double amount) {
        DecimalFormat df = new DecimalFormat(Const.FORMATTER);
        df.setMaximumFractionDigits(Const.MAX_FRACTION_DIGIT);
        df.setMinimumFractionDigits(Const.MIN_FRACTION_DIGIT);      
        String amountFormated = df.format(amount);
        
        return amountFormated;
    }
    
    
    public UUID getAccountId() {
        return accountId;
    }
    

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    
}
