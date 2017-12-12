package br.com.jmsstudio.designpatterns.state.account;

import br.com.jmsstudio.model.Account;

public interface AccountState {

    void processDeposit(Account account, double value);

    void processWithdraw(Account account, double value);
}
