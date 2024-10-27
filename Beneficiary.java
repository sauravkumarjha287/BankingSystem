package com.jewelbank.services;

public class Beneficiary {
    private int beneficiaryID;
    private int customerID;
    private String name;
    private String accountNumber;
    private String bankDetails;

    public Beneficiary(int beneficiaryID, int customerID, String name, String accountNumber, String bankDetails) {
        this.beneficiaryID = beneficiaryID;
        this.customerID = customerID;
        this.name = name;
        this.accountNumber = accountNumber;
        this.bankDetails = bankDetails;
    }

    // Getter Methods
    public int getBeneficiaryID() {
        return beneficiaryID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public String toString() {
        return "Beneficiary ID: " + beneficiaryID + ", Name: " + name;
    }
}
