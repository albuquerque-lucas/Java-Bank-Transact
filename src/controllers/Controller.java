package controllers;

import java.util.Scanner;

public class Controller {
    protected static final String AFFIRMATIVE_OPTION = "y";
    protected static final String NEGATIVE_OPTION = "n";
    protected static String YES_OR_NO_QUERY = "[ " + AFFIRMATIVE_OPTION + " / " + NEGATIVE_OPTION + " ]";
    protected static final String EMPLOYEE_CODE = "f";
    protected static final String CUSTOMER_CODE = "c";
    protected static String USER_TYPE_QUERY = "[ " + EMPLOYEE_CODE + " / " + CUSTOMER_CODE + " ]";
    protected static final String SAVINGS_ACCOUNT_CODE = "cp";
    protected static final String CHECKING_ACCOUNT_CODE = "cc";

    protected static final String ACCOUNT_TYPE_QUERY = "[ " + CHECKING_ACCOUNT_CODE + " / " + SAVINGS_ACCOUNT_CODE + " ]";
    protected final Scanner scanner = new Scanner(System.in);
    public void waitForEnter() {
        System.out.print("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void invalidAnswer() {
        System.out.println("|           Resposta invalida          |");
        System.out.println("|         Encerrando o sistema        |");
    }
}
