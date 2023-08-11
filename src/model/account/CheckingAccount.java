package model.account;

public class CheckingAccount extends Account{
    private final double overdraftLimit;
    public CheckingAccount(int accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    public double getOverdraftLimit(){
        return overdraftLimit;
    }
    public void displayOverdraftLimit(){
        System.out.println("Seu limite de credito e: R$" + overdraftLimit);
    }
}
