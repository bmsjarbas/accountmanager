package ie.britoj.accountmanager.domain;

import ie.britoj.accountmanager.domain.entities.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenCreatingAnAccountTest {
    private Account account;

    @Test
    public void theAccountHasAHolder(){
        String holder = "Jarbas";
        Account account = new Account(holder);
        assertThat(account.getHolder()).isEqualTo(holder);
    }

}
