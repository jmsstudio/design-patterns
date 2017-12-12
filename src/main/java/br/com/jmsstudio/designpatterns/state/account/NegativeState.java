package br.com.jmsstudio.designpatterns.state.account;

import br.com.jmsstudio.model.Account;

public class NegativeState implements AccountState {

    public static final double DEPOSIT_RATE = 0.05;

    @Override
    public void processDeposit(Account account, double value) {
        double valueToBeDeposited = value - (value * DEPOSIT_RATE);

        account.setBalance(account.getBalance() + valueToBeDeposited);

        if (account.getBalance() > 0) {
            account.setCurrentState(new PositiveState());
        }
    }

    @Override
    public void processWithdraw(Account account, double value) {
        throw new RuntimeException("The account with negative balance cannot process a withdrawal");
    }
}
