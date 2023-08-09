package model.user;

import model.account.Account;
import model.account.CheckingAccount;
import model.account.SavingsAccount;

public class User {
    private String name;
    private int age;

    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public void displayAccount() {
        if (savingsAccount != null) {
            System.out.println("Informacoes de conta:");
            savingsAccount.displayAccountNumber();
            savingsAccount.displayBalance();
            savingsAccount.displayInterestRate();
        } else if (checkingAccount != null) {
            System.out.println("Informacoes de conta:");
            checkingAccount.displayAccountNumber();
            checkingAccount.displayBalance();
            checkingAccount.displayOverdraftLimit();
        } else {
            System.out.println("Nao ha informacoes sobre conta.");
        }

    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }
}
