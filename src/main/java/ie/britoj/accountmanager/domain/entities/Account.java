package ie.britoj.accountmanager.domain.entities;

public class Account {
    private double balance;

    public Account() {
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return this.balance;
    }
}
