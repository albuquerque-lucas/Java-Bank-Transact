package controllers;

import model.user.User;

import java.util.Scanner;

public class OperationController extends Controller{
    private final User mainUser;
    private final User secondaryUser;
    public OperationController(User mainUser, User secondaryUser) {
        this.mainUser = mainUser;
        this.secondaryUser = secondaryUser;
    }
    public void start() {
        clearScreen();
        System.out.println("Podemos iniciar as operacoes? " + YES_OR_NO_QUERY);
        String startResponse = scanner.nextLine();
        if (startResponse.equals(AFFIRMATIVE_OPTION)) {

        } else if(startResponse.equals(NEGATIVE_OPTION)) {

        } else {
            invalidAnswer();
        }
    }
}
