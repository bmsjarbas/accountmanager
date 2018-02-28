package ie.britoj.accountmanager.domain.entities;

import ie.britoj.accountmanager.domain.exceptions.AccountWithoutFundsException;

public class Account {
    private final String holder;
    private double balance;

    public Account(String holder) {
        this.holder = holder;
    }

    public void deposit(double amount) {
        this.balance += amount;
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
    }
}
