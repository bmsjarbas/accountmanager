package ie.britoj.accountmanager.domain.valueObjects;

import java.time.LocalDateTime;

public class Transaction {
    private final String operation;
    private final double amount;
    private final double balance;
    private final LocalDateTime date;

    public Transaction(String operation, double amount, double balance, LocalDateTime date) {
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
