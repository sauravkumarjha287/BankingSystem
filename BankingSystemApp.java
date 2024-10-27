package com.jewelbank.services;

import java.util.*;

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingServiceImpl bankingService = new BankingServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("          ->->->Welcome to Jewel Bank<-<-<-");

        do {
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. List all Accounts of a Customer");
            System.out.println("7. List all Transactions of an Account");
            System.out.println("8. List all Beneficiaries of a Customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();

                    bankingService.addCustomer(new Customer(customerID, name, address, contact));
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println("** Customer Added Successfully **");
                    break;

                case 2:
                    System.out.print("Enter Account ID: ");
                    int accountID = scanner.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int accCustomerID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Account Type (Saving/Current): ");
                    String accountType = scanner.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();

                    bankingService.addAccount(new Account(accountID, accCustomerID, accountType, balance));
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println("** Account Added Successfully **");
                    break;

                case 3:
                    System.out.print("Enter Beneficiary ID: ");
                    int beneficiaryID = scanner.nextInt();
                    System.out.print("Enter Customer ID: ");
                    int benCustomerID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Beneficiary Name: ");
                    String beneficiaryName = scanner.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();
                    System.out.print("Enter Bank Details: ");
                    String bankDetails = scanner.nextLine();

                    bankingService.addBeneficiary(new Beneficiary(beneficiaryID, benCustomerID, beneficiaryName, accountNumber, bankDetails));
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println("** Beneficiary Added Successfully **");
                    break;

                case 4:
                    System.out.print("Enter Transaction ID: ");
                    int transactionID = scanner.nextInt();
                    System.out.print("Enter Account ID: ");
                    int transAccountID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Type (Deposit/Withdrawal): ");
                    String transactionType = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();

                    bankingService.addTransaction(new Transaction(transactionID, transAccountID, transactionType, amount));
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println("** Transaction Added Successfully **");
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int searchCustomerId = scanner.nextInt();
                    Customer foundCustomer = bankingService.findCustomerById(searchCustomerId);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println(foundCustomer != null ? foundCustomer : "Customer not found.");
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    int custId = scanner.nextInt();
                    List<Account> accounts = bankingService.getAccountsByCustomerId(custId);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    if (!accounts.isEmpty()) {
                        for (Account acc : accounts) {
                            System.out.println(acc);
                        }
                    } else {
                        System.out.println("No accounts found for this customer.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Account ID: ");
                    int accId = scanner.nextInt();
                    List<Transaction> transactions = bankingService.getTransactionsByAccountId(accId);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    if (!transactions.isEmpty()) {
                        for (Transaction trans : transactions) {
                            System.out.println(trans);
                        }
                    } else {
                        System.out.println("No transactions found for this account.");
                    }
                    break;

                case 8:
                    System.out.print("Enter Customer ID: ");
                    int benCustomerId2 = scanner.nextInt();
                    List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(benCustomerId2);
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    if (!beneficiaries.isEmpty()) {
                        for (Beneficiary ben : beneficiaries) {
                            System.out.println(ben);
                        }
                    } else {
                        System.out.println("No beneficiaries found for this customer.");
                    }
                    break;

                case 9:
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    System.out.println("      Thank you for interacting with Jewel Bank");
                    System.out.println("                   Visit Again");
                    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while (choice != 9) ;
        scanner.close();
    }
}
