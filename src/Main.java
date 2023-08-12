import controllers.OperationController;
import controllers.UserController;
import model.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();
        userController.start();
        User mainUser = userController.initializeUser();
        mainUser.displayInfo();
        userController.associateAccount(mainUser);
        User secondaryUser = userController.createSecondUser();
        OperationController operationController = new OperationController(mainUser, secondaryUser);
        boolean continueOperations = true;
        while (continueOperations) {
            operationController.start();
            String operation = operationController.chooseOperationType();
            operationController.performOperation(operation);

            System.out.println("Deseja realizar outra operacao? (y/n)");
            String response = scanner.nextLine();
            continueOperations = response.equalsIgnoreCase("y");
        }
    }


}
