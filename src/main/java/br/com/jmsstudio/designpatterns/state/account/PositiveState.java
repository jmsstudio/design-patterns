package br.com.jmsstudio.designpatterns.state.account;

import br.com.jmsstudio.model.Account;

public class PositiveState implements AccountState {
    public static final double DEPOSIT_RATE = 0.02;

    @Override
    public void processDeposit(Account account, double value) {
        double valueToBeDeposited = value - (value * DEPOSIT_RATE);

        account.setBalance(account.getBalance() + valueToBeDeposited);
    }

    @Override
    public void processWithdraw(Account account, double value) {
        account.setBalance(account.getBalance() - value);

        if (account.getBalance() < 0) {
            account.setCurrentState(new NegativeState());
        }
    }
}
