public class BankAccount {
    private int id;
    private double balance;

    private static int accountsCounter = 1;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = accountsCounter++;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return this.balance * BankAccount.interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountsCounter() {
        return accountsCounter;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public BankAccount setId(int id) {
        this.id = id;
        return this;
    }

    public BankAccount setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public static void setAccountsCounter(int accountsCounter) {
        BankAccount.accountsCounter = accountsCounter;
    }
}
