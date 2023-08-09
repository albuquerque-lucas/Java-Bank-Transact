package model.account;

public class SavingsAccount extends Account{
    private final double interestRate;

    public SavingsAccount(int accountNumber, double initialBalance, double interestRate){
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void displayInterestRate() {
        System.out.println("Taxa de juros: " + interestRate + "%");
    }
}
