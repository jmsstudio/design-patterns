package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.model.Account;

import java.util.Random;

public class InvestimentoArrojado implements IInvestimento {
    @Override
    public double calcula(Account account) {
        double taxa;

        int baseValue = new Random().nextInt(10);

        if (baseValue >= 1 && baseValue <= 2) {
            taxa = 0.05;
        } else if (baseValue <= 5) {
            taxa = 0.03;
        } else {
            taxa = 0.6;
        }

        return account.getBalance() * taxa;
    }
}
