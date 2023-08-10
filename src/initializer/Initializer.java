package initializer;

import java.util.Scanner;

public class Initializer {
    protected static final String AFFIRMATIVE_OPTION = "y";
    protected static final String NEGATIVE_OPTION = "n";
    protected static final String EMPLOYEE_OPTION = "f";
    protected static final String CUSTOMER_OPTION = "c";
    protected static final String CHECKING_ACCOUNT = "cc";
    protected static final String SAVINGS_ACCOUNT = "cp";
    protected static final String INITIAL_EMPLOYEE_POSITION = "Novato";
    protected static final int MIN_CUSTOMER_ID = 1001;
    protected static final int MAX_CUSTOMER_ID = 9999;
    protected static final int INITIAL_BALANCE = 0;
    protected static final int OVERDRAFT_LIMIT = 100;
    protected static final double INTEREST_RATE = 0.14;

    protected static final Scanner scanner = new Scanner(System.in);
}
