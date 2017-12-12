package br.com.jmsstudio.designpatterns.state.account;

import br.com.jmsstudio.model.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountStateTest {

    @Test
    public void shouldProcessWithdrawalCorrectlyWhenAccountBalanceIsPositive() {
        double initialValue = 500;
        Account account = new Account(initialValue);

        account.withdraw(300);

        assertEquals(200, account.getBalance(), 0.0);
    }

    @Test
    public void shouldProcessDepositCorrectlyWhenAccountBalanceIsPositive() {
        double initialValue = 500;
        Account account = new Account(initialValue);

        double depositValue = 300;

        account.deposit(depositValue);

        assertEquals(initialValue + depositValue - (depositValue * PositiveState.DEPOSIT_RATE), account.getBalance(), 0.0);
    }

    @Test
    public void shouldProcessDepositCorrectlyWhenAccountBalanceIsNegative() {
        double initialValue = -500;
        Account account = new Account(initialValue);

        double depositValue = 300;

        account.deposit(depositValue);

        assertEquals(initialValue + depositValue - (depositValue * NegativeState.DEPOSIT_RATE), account.getBalance(), 0.0);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrownErrorWhenTryingToProcessWithdrawalOfAnAccountWithNegativeBalance() {
        double initialValue = -500;
        Account account = new Account(initialValue);

        account.withdraw(300);
    }


}
