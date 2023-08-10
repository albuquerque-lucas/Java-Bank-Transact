package initializer;

import model.user.User;
import service.AccountService;

public class OperationInitializer extends Initializer{
    private final AccountService accountService;

    public OperationInitializer(AccountService accountService) {
        this.accountService = accountService;
    }
    public void initialize() {
        System.out.println("Primeiramente, vamos depositar um dinheiro na sua conta.");
        User user = accountService.getUser();
        accountService.deposit(1000, user);
    }
}
