package model.user;

public class Customer extends User{
    private String[] options;
    private int customerId;

    public Customer(String name, int age, int customerId) {
        super(name, age);
        this.customerId = customerId;
        this.options = new String[]{"Option A", "Option B", "Option C"};
    }

    public void displayCustomerId() {
        System.out.println("Customer ID: " + customerId);
    }

    public void displayOptions() {
        System.out.println("Lista de opcoes do usuario:");
        for (String option : options) {
            System.out.println(option);
        }
    }
}
