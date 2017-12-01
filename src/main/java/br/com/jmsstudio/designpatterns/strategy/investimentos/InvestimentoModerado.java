package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Conta;

import java.util.Random;

public class InvestimentoModerado implements IInvestimento {
    @Override
    public double calcula(Conta conta) {

        double taxa;

        if (new Random().nextBoolean()) {
            taxa = 0.025;
        } else {
            taxa = 0.8;
        }

        return conta.getSaldo() * taxa;
    }
}
