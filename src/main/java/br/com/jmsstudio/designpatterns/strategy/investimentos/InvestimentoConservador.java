package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Conta;

public class InvestimentoConservador implements IInvestimento {
    @Override
    public double calcula(Conta conta) {
        return conta.getSaldo() * 0.8;
    }
}
