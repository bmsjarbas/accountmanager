package ie.britoj.accountmanager.domain.entities;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

}