package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Account;

public interface IInvestimento {

    double calcula(Account account);

}
