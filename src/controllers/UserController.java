package controllers;
import model.account.Account;
import model.account.CheckingAccount;
import model.account.SavingsAccount;
import model.user.Customer;
import model.user.Employee;
import model.user.User;

import java.util.Scanner;

public class UserController extends Controller{
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
        System.out.println("Podemos começar? " + YES_OR_NO_QUERY);
        String startResponse = scanner.nextLine();

        if (startResponse.equals(AFFIRMATIVE_OPTION)) {
            System.out.println("Qual o seu nome?");
            String nameResponse = scanner.nextLine();
            System.out.println("Qual a sua idade?");
            String ageResponse = scanner.nextLine();
            int age = Integer.parseInt(ageResponse);
            System.out.println("Voce e funcionario ou cliente? " + USER_TYPE_QUERY);
            String typeResponse = scanner.nextLine();

            if (typeResponse.equals(EMPLOYEE_CODE)) {
                return new Employee(nameResponse, age, "Novato");
            } else if (typeResponse.equals(CUSTOMER_CODE)) {
                return new Customer(nameResponse, age, 1001);
            } else {
                System.out.println("|             Resposta invalida             |");
                waitForEnter();
                System.out.println("|           Vamos tentar novamente? " + YES_OR_NO_QUERY + "      |");
                String tryAgainResponse = scanner.nextLine();
                if (tryAgainResponse.equals(AFFIRMATIVE_OPTION)) {
                    initializeUser();
                } else if (tryAgainResponse.equals(NEGATIVE_OPTION)) {
                    return null;
                } else {
                    invalidAnswer();
                }
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
        System.out.println("Voce quer criar uma conta corrente ou conta poupanca? " + ACCOUNT_TYPE_QUERY);
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
        System.out.println("Dados da conta do segundo usuario " + customer.getName() + ":");
        customer.getAccount().displayAccountNumber();
        customer.getAccount().displayBalance();
        return customer;
    }
}
