package ie.britoj.accountmanager.domain.entities;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenWithdrawingMoneyFromAccountTest {

    private Account account;

    @Before
    public void SetUp(){
        String jarbas = "Jarbas";
        account = new Account(jarbas);
    }

    @Test
    public void ThenTheAmountIsDeductedFromBalance(){
        double amount=10;
        givenAccountWithBalance(100);
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(90);
    }

    private void givenAccountWithBalance(double amount){
        account.deposit(amount);
    }
}
