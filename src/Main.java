import controllers.OperationController;
import controllers.UserController;
import model.user.User;
public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.start();
        User mainUser = userController.initializeUser();
        mainUser.displayInfo();
        userController.associateAccount(mainUser);
        User secondaryUser = userController.createSecondUser();
        OperationController operationController = new OperationController(mainUser, secondaryUser);
        operationController.start();
        String operation = operationController.chooseOperationType();
        operationController.performOperation(operation);
    }


}
