package initializer;

import model.account.Account;
import model.account.CheckingAccount;
import model.account.SavingsAccount;
import model.user.Customer;
import model.user.Employee;
import model.user.User;

import java.util.Random;
import java.util.Scanner;

public class UserInitializer extends Initializer{

    private static final Scanner scanner = new Scanner(System.in);

    public static User initialize() {
        User createdUser = initializeUser();
        if (createdUser == null) {
            System.out.println("Nao foi possivel criar o usuario.");
        } else {
            associateAccount(createdUser);
            createdUser.displayAccount();
        }
        return createdUser;
    }
    public static User initializeUser() {
        //Pergunta para iniciar a criacao de usuario
        System.out.println("Ola! Vamos montar a sua conta. Podemos comecar? [y/n]");
        String response = scanner.nextLine().toLowerCase();
        User user = null;

        if (response.equals(AFFIRMATIVE_OPTION)) {
            //Inicia a conta de usuario
            System.out.print("Qual o seu nome?");
            String name = scanner.nextLine();
            System.out.print("Qual a sua idade?");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Voce e cliente ou funcionario? [" + CUSTOMER_OPTION + " / " + EMPLOYEE_OPTION + "]");
            String userType = scanner.nextLine().toLowerCase();

            if (userType.equals(EMPLOYEE_OPTION)) {
                user = new Employee(name, age, INITIAL_EMPLOYEE_POSITION);
                Employee employee = (Employee) user;
                employee.displayInfo();
                employee.displayPosition();
            } else if (userType.equals(CUSTOMER_OPTION)) {
                int randomId = new Random().nextInt(MAX_CUSTOMER_ID - MIN_CUSTOMER_ID + 1) + MIN_CUSTOMER_ID;
                user = new Customer(name, age, randomId);
                Customer customer = (Customer) user;
                customer.displayInfo();
                customer.displayCustomerId();
            } else {
                System.out.println("Tipo de usuario invalido. Encerrando operacao.");
            }
        } else if (response.equals(NEGATIVE_OPTION)) {
            String message = """
                            Operação cancelada.
                            Ate a proxima!
                            """;
            System.out.println(message);
        } else {
            System.out.println("Resposta invalida. Encerrando operacao.");
        }
        return user;
    }

    public static void associateAccount(User user) {
        System.out.println("Pretende criar conta corrente ou conta poupanca? [ " + CHECKING_ACCOUNT + " / " + SAVINGS_ACCOUNT + " ]");
        String accountType = scanner.nextLine().toLowerCase();

        if (accountType.equals(CHECKING_ACCOUNT)) {
            int accountNumber = new Random().nextInt(9000) + 1000;
            CheckingAccount checkingAccount = new CheckingAccount(accountNumber, INITIAL_BALANCE, OVERDRAFT_LIMIT);
            user.setCheckingAccount(checkingAccount);
        } else if (accountType.equals(SAVINGS_ACCOUNT)){
            int accountNumber = new Random().nextInt(9000) + 1000;
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, INITIAL_BALANCE, INTEREST_RATE);
            user.setSavingsAccount(savingsAccount);
        } else {
            System.out.println("Tipo de conta informada invalido.");
        }
        user.displayAccount();
    }
}
