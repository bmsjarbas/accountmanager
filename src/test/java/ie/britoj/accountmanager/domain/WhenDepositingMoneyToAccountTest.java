package ie.britoj.accountmanager.domain;
import ie.britoj.accountmanager.domain.entities.Account;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenDepositingMoneyToAccountTest {

    private Account account;

    @Before
    public void setUp(){
        String holder = "Jarbas";
        account = new Account(holder);
    }

    @Test
    public void ThenBalanceIsIncreased(){
        double amount = 10.00;
        account.deposit(amount);
        assertThat(account.getBalance()).isEqualTo(amount);
    }

    @Test
    public void ADepositTransactionIsCreated(){

        String operationName = "deposit";
        double initialAmount = 20.00;
        account.deposit(20);
        double expectedBalance = initialAmount;

        assertThat(account.getTransactions()).isNotEmpty();

        assertThat(account.getTransactions()).allMatch(item-> item.getOperation().equals(operationName) &&
                item.getAmount() == initialAmount &&
                item.getBalance() == expectedBalance &&
                Duration.between(item.getDate(), LocalDateTime.now()).toMillis() < 500);
    }

}