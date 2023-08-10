package service;

import model.account.Account;
import model.user.User;

public class AccountService {
    private final User user;
    public AccountService(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void transfer(double amount, User targetUser) {
        Account sourceAccount = user.getAccount();

        if (sourceAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.withdraw(amount);
            targetUser.getAccount().deposit(amount);
            System.out.println("Transferencia de " + user.getName() + " para " + targetUser.getName() + " com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferencia.");
        }
    }

    public void deposit(double amount, User targetUser) {
        Account targetAccount = targetUser.getAccount();
        double initialValue = targetAccount.getBalance();
        targetAccount.deposit(amount);
        double finalValue = targetAccount.getBalance();

        if (finalValue > initialValue) {
            System.out.println("Deposito de " + amount + " realizado na conta de " + targetUser.getName() + " realizado com sucesso.");
        } else {
            System.out.println("Aparentemente o deposito nao foi realizado.");
        }
    }


}
