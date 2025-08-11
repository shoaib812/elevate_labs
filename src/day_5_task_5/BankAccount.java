package day_5_task_5;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(" Account opened with balance : "+ initialBalance);
    }

    public void deposit(double amount) {
        if (amount <=0 ) {
            System.out.println(" Deposit amount must be positive. ");
            return;
        }
        balance += amount;
        transactionHistory.add(" Deposited : "+ amount + " | Balance : "+ balance);
        System.out.println(" Successfully deposited : "+ amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdraw amount must be positive. ");
            return;
        }
        if(amount > balance) {
            System.out.println(" Insufficient balance! ");
            return;
        }
        balance -= amount;
        transactionHistory.add(" Withdraw : "+ amount +" | Balance : "+ balance);
        System.out.println(" Successfully Withdraw : "+ amount);
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for "+ accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}
