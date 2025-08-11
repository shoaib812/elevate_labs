package day_5_task_5;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter account holder name : ");
        String name = sc.nextLine();

        System.out.print(" Enter initial balance : ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);

        while (true) {
            System.out.println("\n --- Bank Menu ---");
            System.out.println(" 1. Deposit ");
            System.out.println(" 2. Withdraw ");
            System.out.println(" 3. Check Balance ");
            System.out.println(" 4. Transaction History ");
            System.out.println(" 5. Exit ");
            System.out.println(" Choose an option ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Enter amount to deposit : ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println(" Enter amount to withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println(" Current Balance : "+ account.getBalance());
                    break;

                case 4:
                    account.printTransactionHistory();
                    break;

                case 5:
                    System.out.println(" Thank you for using our banking system!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid option! Try again. ");
            }
        }
    }
}
