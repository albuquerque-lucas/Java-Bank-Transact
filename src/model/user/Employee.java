package model.user;

public class Employee extends User{
    private String[] options;
    private String position;

    public Employee(String name, int age, String position) {
        super(name, age);
        this.position = position;
        this.options = new String[]{"Option 1", "Option 2", "Option 3"};
    }

    public void displayPosition() {
        System.out.println("Cargo: " + position);
    }

    public void displayOptions() {
        System.out.println("Lista de opcoes do usuario:");
        for (String option : options) {
            System.out.println(option);
        }
    }
}
