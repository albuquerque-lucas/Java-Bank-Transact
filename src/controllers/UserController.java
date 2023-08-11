package controllers;
import model.account.Account;
import model.account.CheckingAccount;
import model.account.SavingsAccount;
import model.user.Customer;
import model.user.Employee;
import model.user.User;
import service.UserService;

import java.util.Scanner;

public class UserController {
    private static final String AFFIRMATIVE_OPTION = "y";
    private static final String NEGATIVE_OPTION = "n";
    private static final String EMPLOYEE_CODE = "f";
    private static final String CUSTOMER_CODE = "c";
    private static final String SAVINGS_ACCOUNT_CODE = "cp";
    private static final String CHECKING_ACCOUNT_CODE = "cc";
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    public void start() {
        clearScreen();
        System.out.println("=======================================");
        System.out.println("|         Bem vindo ao Sistema        |");
        System.out.println("|    Operações Bancárias Simples      |");
        System.out.println("|    Meu Primeiro Projeto em Java     |");
        System.out.println("=======================================");
        waitForEnter();
    }

    public User initializeUser() {
        System.out.println("Podemos começar? [" + AFFIRMATIVE_OPTION + " / " + NEGATIVE_OPTION + "]");
        String startResponse = scanner.nextLine();

        if (startResponse.equals(AFFIRMATIVE_OPTION)) {
            System.out.println("Qual o seu nome?");
            String nameResponse = scanner.nextLine();
            System.out.println("Qual a sua idade?");
            String ageResponse = scanner.nextLine();
            int age = Integer.parseInt(ageResponse);
            System.out.println("Voce e funcionario ou cliente? [" + EMPLOYEE_CODE + " / " + CUSTOMER_CODE + "]");
            String typeResponse = scanner.nextLine();

            if (typeResponse.equals(EMPLOYEE_CODE)) {
                return new Employee(nameResponse, age, "Novato");
            } else if (typeResponse.equals(CUSTOMER_CODE)) {
                return new Customer(nameResponse, age, 1001);
            } else {
                System.out.println("|             Resposta invalida             |");
                waitForEnter();
                System.out.println("|           Vamos tentar novamente          |");
                initializeUser();
            }
        } else if (startResponse.equals(NEGATIVE_OPTION)) {
            System.out.println("Terminando aplicacao.");
            return null;
        } else {
            invalidAnswer();
            return null;
        }
        return null;
    }

    public void associateAccount(User user) {
        System.out.println("Voce quer criar uma conta corrente ou conta poupanca? [" + CHECKING_ACCOUNT_CODE + "  " + SAVINGS_ACCOUNT_CODE + "]");
        String response = scanner.nextLine();
        if (response.equals(CHECKING_ACCOUNT_CODE)) {
            CheckingAccount checkingAccount = new CheckingAccount(1234, 0.00, 100);
            user.setCheckingAccount(checkingAccount);
        } else if (response.equals(SAVINGS_ACCOUNT_CODE)) {
            SavingsAccount savingsAccount = new SavingsAccount(2345, 0.00, 0.14);
            user.setSavingsAccount(savingsAccount);
        } else {
            invalidAnswer();
        }
        System.out.println("Aqui estao os dados da conta criada para o usuario " + user.getName());
        user.getAccount().displayAccountNumber();
        user.getAccount().displayBalance();
        waitForEnter();
    }

    public User createSecondUser() {
        System.out.println("Agora eu vou criar um segundo usuario generico para que voce possa interagir e fazer as operacoes.");
        waitForEnter();
        Customer customer = new Customer("Fred", 33, 3312);
        CheckingAccount checkingAccount = new CheckingAccount(4321, 0.00, 100);
        customer.setCheckingAccount(checkingAccount);
        System.out.println("Usuario criado.");
        waitForEnter();
        System.out.println("Dados do usuario secundario:");
        customer.displayInfo();
        System.out.println("Dados da conta do segundo usuario " + customer.getName());
        customer.getAccount().displayAccountNumber();
        customer.getAccount().displayBalance();
        return customer;
    }

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
