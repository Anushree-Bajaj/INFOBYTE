import java.util.Scanner;

public class ATM {
    private static final int PIN = 1234;
    private static final double INITIAL_BALANCE = 1000.00;
    private static double balance;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        balance = INITIAL_BALANCE;
        System.out.println("Welcome to the ATM!");
        int attempts = 3;

        while (attempts > 0){
            System.out.print("Enter your PIN: ");
            int userPin = scanner.nextInt();

            if (userPin == PIN) {
                break;
            } else {
                System.out.println("Incorrect PIN. Try again.");
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("Too many failed attempts. Exiting the ATM...");
            return;
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    transactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void transactionHistory() {
        // Add your implementation for transaction history
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew %.2f. Your new balance is %.2f.\n", amount, balance);
        }
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.printf("Deposited %.2f. Your new balance is %.2f.\n", amount, balance);
    }

    private static void transfer() {
        System.out.print("Enter the recipient's account number: ");
        int recipient = scanner.nextInt();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Transferred %.2f to account number %d. Your new balance is %.2f.\n", amount, recipient, balance);
        }
    }
}