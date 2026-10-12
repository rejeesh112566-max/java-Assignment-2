package assignment2;


import java.util.Scanner;

// Custom exception 1
class InvalidPinException extends Exception {
    InvalidPinException(String message) {
        super(message);
    }
}

// Custom exception 2
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMTransactionSystem {
    static double balance = 5000;
    static final int correctPin = 1234;

    static void verifyPin(int pin) throws InvalidPinException {
        if (pin != correctPin) {
            throw new InvalidPinException("Invalid PIN!");
        }
    }

    static void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be greater than zero!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    static void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be greater than zero!");
        }

        balance += amount;
        System.out.println("Deposit successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            verifyPin(pin);
            System.out.println("Login successful!");

            int choice;

            do {
                System.out.println("\n--- ATM MENU ---");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                try {
                    switch (choice) {
                        case 1:
                            System.out.println(
                                "Balance: Rs." + balance);
                            break;

                        case 2:
                            System.out.print(
                                "Enter withdrawal amount: ");
                            double w = sc.nextDouble();
                            withdraw(w);
                            break;

                        case 3:
                            System.out.print(
                                "Enter deposit amount: ");
                            double d = sc.nextDouble();
                            deposit(d);
                            break;

                        case 4:
                            System.out.println("Thank you!");
                            break;

                        default:
                            System.out.println(
                                "Invalid menu choice.");
                    }
                } catch (InsufficientBalanceException |
                         IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } while (choice != 4);

        } catch (InvalidPinException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Enter valid numeric input.");
        } finally {
            sc.close();
            System.out.println("ATM session ended.");
        }
    }
}
