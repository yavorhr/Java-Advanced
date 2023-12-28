import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Create" -> {
                    BankAccount bankAccount = createBankAccount(bankAccounts);
                    System.out.printf("Account ID%d created\n", bankAccount.getId());
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(tokens[1]);
                    double balance = Double.parseDouble(tokens[2]);

                    if (doesAccountExist(bankAccounts, id)) {
                        BankAccount bankAccount = bankAccounts.get(id);
                        bankAccount.setBalance(balance);
                        bankAccounts.put(id, bankAccount);
                        System.out.printf("Deposited %.2f to ID%d\n", balance, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (doesAccountExist(bankAccounts, id)) {
                        double calculatedInterest = bankAccounts.get(id).getInterest(years);
                        System.out.printf("%.2f\n", calculatedInterest);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> {
                    double balance = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(balance);
                }
            }

            input = scanner.nextLine();
        }
        System.out.println();
    }

    private static BankAccount createBankAccount(Map<Integer, BankAccount> bankAccounts) {
        BankAccount bankAccount = new BankAccount();
        bankAccounts.put(bankAccount.getId(), bankAccount);
        return bankAccount;
    }

    private static boolean doesAccountExist(Map<Integer, BankAccount> bankAccounts, int id) {
        return bankAccounts.containsKey(id);
    }

    private static boolean doesAccountExist(BankAccount bankAccount) {
        return bankAccount != null;
    }

    private static BankAccount getBankAccount(List<BankAccount> bankAccountsList, int id) {
        return bankAccountsList.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}

