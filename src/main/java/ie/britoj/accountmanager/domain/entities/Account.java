package ie.britoj.accountmanager.domain.entities;

import ie.britoj.accountmanager.domain.exceptions.AccountWithoutFundsException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String holder;
    private double balance;
    private List<Transaction> transactions;

    public Account(String holder){
        transactions = new ArrayList<>();
        this.holder = holder;
    }

    public void deposit(double amount) {
        this.balance += amount;
        Transaction depositTransaction = buildTransaction("deposit", amount, balance);
        transactions.add(depositTransaction);
    }

    public double getBalance() {
        return this.balance;
    }

    public String getHolder() {
        return holder;
    }

    public void withdraw(double amount) throws AccountWithoutFundsException {
        double tempBalance = balance - amount;
        if(tempBalance < 0){
            throw new AccountWithoutFundsException();
        }
        balance = tempBalance;
        Transaction withdrawTransaction = buildTransaction("withdraw", amount, balance);
        transactions.add(withdrawTransaction);
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    private Transaction buildTransaction(String operation, double amount, double balance){
        LocalDateTime date = LocalDateTime.now();
        return new Transaction(operation, amount, balance, date);
    }
}
