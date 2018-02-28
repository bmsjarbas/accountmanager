package ie.britoj.accountmanager.domain.entities;

import ie.britoj.accountmanager.domain.exceptions.AccountWithoutFundsException;
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

    private void givenAccountWithBalance(double amount){
        account.deposit(amount);
    }
}
