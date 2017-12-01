package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Conta;

public interface IInvestimento {

    double calcula(Conta conta);

}
