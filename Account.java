package com.jewelbank.services;

public class Account {
    private int accountID;
    private int customerID;
    private String type;
    private double balance;

    public Account(int accountID, int customerID, String type, double balance) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.type = type;
        this.balance = balance;
    }

    // Getter Methods
    public int getAccountID() {
        return accountID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    // Setter methods
    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountID + ", Balance: " + balance;
    }
}