import initializer.OperationInitializer;
import initializer.UserInitializer;
import model.user.User;
import service.AccountService;

public class Main {
    public static void main(String[] args) {
        User userOne = UserInitializer.initialize();
        User userTwo = UserInitializer.initialize();
        System.out.println("Por padrão, você estará selecionado como usuário 1:");
        userOne.displayInfo();
        System.out.println("Numero da conta: ");
        userOne.getAccount().displayAccountNumber();
        AccountService accountService = new AccountService(userOne);
        OperationInitializer operationInitializer = new OperationInitializer(accountService);
        operationInitializer.initialize();


    }
}
