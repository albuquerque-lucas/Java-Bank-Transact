package model.operation;

import model.user.User;

public class Operation {
    private final User user;

    public Operation(User user){
        this.user = user;
    }

    public void withdraw(double amount) {
        double userBalance = user.getAccount().getBalance();
        if (amount < userBalance) {
            System.out.println("Saldo insuficiente.");
        } else {
            user.getAccount().withdraw(amount);
        }
    }

}
