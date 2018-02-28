package ie.britoj.accountmanager.domain.entities;

import ie.britoj.accountmanager.domain.exceptions.AccountWithoutFundsException;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenWithdrawingMoneyFromAccountTest {

    private Account account;

    @Before
    public void SetUp(){
        String jarbas = "Jarbas";
        account = new Account(jarbas);
    }

    @Test
    public void ThenTheAmountIsDeductedFromBalance() throws AccountWithoutFundsException {
        double amount=10;
        givenAccountWithBalance(100);
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(90);
    }

    @Test(expected = AccountWithoutFundsException.class)
    public void AndBalanceIsNotEnoughtAnExceptionIsRaised() throws AccountWithoutFundsException {
        double withdrawAmount = 100;
        givenAccountWithBalance(50);
        account.withdraw(withdrawAmount);
    }

    @Test
    public void AWithdrawTransactionIsCreated() throws AccountWithoutFundsException {
        String operationName = "withdraw";
        double initialAmount = 100;
        givenAccountWithBalance(initialAmount);
        double withdrawAmount = 20;
        double expectedBalance = 80;
        account.withdraw(withdrawAmount);


        assertThat(account.getTransactions()).isNotEmpty();
        assertThat(account.getTransactions()).anyMatch(item-> item.getOperation().equals(operationName) &&
                item.getAmount() == withdrawAmount &&
                item.getBalance() == expectedBalance &&
                Duration.between(item.getDate(), LocalDateTime.now()).toMillis() < 500);
    }

    private void givenAccountWithBalance(double amount){
        account.deposit(amount);
    }
}
