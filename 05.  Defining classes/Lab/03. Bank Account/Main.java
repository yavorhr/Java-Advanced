package Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    BankAccount currentBankAccount = bankAccounts.get(id);
                    currentBankAccount.deposit(Double.parseDouble(tokens[2]));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double newInterest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(newInterest);
            } else {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    System.out.printf("%.2f%n", bankAccount.getInterest(Integer.parseInt(tokens[2])));
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scanner.nextLine();
        }
    }
}










