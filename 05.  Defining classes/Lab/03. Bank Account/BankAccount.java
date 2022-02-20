package Google;

public class BankAccount {

    //броим всички сметки, които се отварят за различните инстанции на класа;
    private static int idCounter = 1;
    private int id;
    private double balance;
    //променяме лихв. % за всички сметки със статична променлива
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = idCounter++;
        System.out.println(String.format("Account ID%d created", this.id));
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public double getInterest(int years) {
        return (this.balance * interestRate) * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(String.format("Deposited %.0f to ID%d", amount, this.id));

    }

    public int getId() {
        return this.id;
    }
}



