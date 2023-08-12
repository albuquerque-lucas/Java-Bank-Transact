package controllers;

import model.operation.Operation;
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
            System.out.println("Abaixo eu vou exibir uma lista de operacoes e seus respectivos codigos para voce digitar no terminal.");
            waitForEnter();
        } else if(startResponse.equals(NEGATIVE_OPTION)) {
            System.out.println("Encerrando operacao.");
        } else {
            invalidAnswer();
        }
    }

    public String chooseOperationType(){
        System.out.println("Escolha o tipo de operacao:");
        System.out.println("t - Transferencia");
        System.out.println("s - Saque");
        System.out.println("d - Deposito");
        System.out.println("saldo - Saldo");
        return scanner.nextLine();
    }
    public void performOperation(String operationCode) {
        switch (operationCode) {
            case "t" -> {
                System.out.println("Transferencia selecionado.");
                waitForEnter();
                System.out.println("Entenda que a titulo deste projeto voce so consegue fazer transferencias para o bot " + secondaryUser.getName());
                waitForEnter();
                System.out.println("Qual valor voce deseja transferir?");
                String inputAmount = scanner.nextLine();
                double amount = Double.parseDouble(inputAmount);
                mainUser.getAccount().transfer(secondaryUser.getAccount(), amount);
                waitForEnter();
            }
            case "s" -> {
                System.out.println("Saque selecionado.");
                waitForEnter();
                System.out.println("Qual valor voce deseja sacar?");
                String inputAmount = scanner.nextLine();
                double amount = Double.parseDouble(inputAmount);
                mainUser.getAccount().withdraw(amount);
                waitForEnter();
            }
            case "d" -> {
                System.out.println("Deposito selecionado.");
                waitForEnter();
                System.out.println("Qual valor voce deseja depositar?");
                String inputAmount = scanner.nextLine();
                double amount = Double.parseDouble(inputAmount);
                System.out.println("Voce deseja depositar para a propria conta ou para a conta do bot " + secondaryUser.getName() + "? [ user / bot ]");
                String response = scanner.nextLine();
                if (response.equals("user")) {
                    mainUser.getAccount().deposit(amount, mainUser.getAccount());
                } else if(response.equals("bot")){
                    mainUser.getAccount().deposit(amount, secondaryUser.getAccount());
                } else {
                    System.out.println("Resposta invalida.");
                }
            }
            case "saldo" -> {
                System.out.println("Saldo selecionado.");
                waitForEnter();
                mainUser.getAccount().displayBalance();
                waitForEnter();
            }
            default -> {
                System.out.println("Opcao invalida.");
                waitForEnter();
            }
        }
    }

    public void newOperationRestart() {
        System.out.println("Deseja realizar outra operacao? " + YES_OR_NO_QUERY);
        String response = scanner.nextLine();
        if (response.equals(AFFIRMATIVE_OPTION)) {
            start();
        } else {
            System.out.println("Encerrando sistema.");
            waitForEnter();
        }
    }
}
