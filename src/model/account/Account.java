package model.account;

import java.sql.SQLOutput;

public class Account {

    private final int accountNumber;
    private double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposito: R$" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Saque: R$" + amount);
        } else {
            System.out.println("Saldo insuficiente para esta operacao.");
        }
    }
    public void transfer(Account destinationAccount, double amount) {
        if (amount <= balance) {
            withdraw(amount);
            destinationAccount.deposit(amount);
            System.out.println("Transferencia de R$" + amount + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para esta transferencia.");
        }
    }

    public void displayAccountNumber() {System.out.println("Numero da conta: " + accountNumber);}

    public void displayBalance() {
        System.out.println("Saldo: R$" + balance);
    }
}
