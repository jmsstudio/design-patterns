package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Conta;

import java.util.Random;

public class InvestimentoArrojado implements IInvestimento {
    @Override
    public double calcula(Conta conta) {
        double taxa;

        int baseValue = new Random().nextInt(10);

        if (baseValue >= 1 && baseValue <= 2) {
            taxa = 0.05;
        } else if (baseValue <= 5) {
            taxa = 0.03;
        } else {
            taxa = 0.6;
        }

        return conta.getSaldo() * taxa;
    }
}
