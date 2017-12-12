package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.model.Account;

public class InvestimentoConservador implements IInvestimento {
    @Override
    public double calcula(Account account) {
        return account.getBalance() * 0.8;
    }
}
