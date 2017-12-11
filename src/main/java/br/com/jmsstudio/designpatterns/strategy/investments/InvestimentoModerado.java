package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.model.Account;

import java.util.Random;

public class InvestimentoModerado implements IInvestimento {
    @Override
    public double calcula(Account account) {

        double taxa;

        if (new Random().nextBoolean()) {
            taxa = 0.025;
        } else {
            taxa = 0.8;
        }

        return account.getSaldo() * taxa;
    }
}
