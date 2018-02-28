package ie.britoj.accountmanager.domain.entities;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class WhenDepositingMoneyToAccountTest {

    private Account account;

    @Before
    public void setUp(){
        account = new Account();
    }

    @Test
    public void Then_Balance_Is_Increased(){
        double amount = 10.00;
        account.deposit(amount);
        assertThat(account.getBalance()).isEqualTo(amount);
    }

}