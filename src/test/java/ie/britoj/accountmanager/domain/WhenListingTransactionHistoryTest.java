package ie.britoj.accountmanager.domain;



import ie.britoj.accountmanager.domain.entities.Account;
import ie.britoj.accountmanager.domain.exceptions.AccountWithoutFundsException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenListingTransactionHistoryTest {

    private Account account;

    @Test
    public void AllTransactionAreListed() throws AccountWithoutFundsException {
        givenAnAccountWithInitalFunds(100)
        .andAfterExecuteWithdrawOf(50);
        assertThat(account.getTransactions()).hasSize(2);
        assertThat(account.getTransactions()).anyMatch(tx-> tx.getOperation() == "deposit");
        assertThat(account.getTransactions()).anyMatch(tx-> tx.getOperation() == "withdraw");

    }

    private void andAfterExecuteWithdrawOf(double amount) throws AccountWithoutFundsException {
        account.withdraw(50);
    }

    private WhenListingTransactionHistoryTest givenAnAccountWithInitalFunds(double amount) {
        account = new Account("Jarbas");
        account.deposit(amount);
        return this;
    }
}
