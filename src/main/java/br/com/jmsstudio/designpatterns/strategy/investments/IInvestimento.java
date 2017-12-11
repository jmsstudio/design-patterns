package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.model.Account;

public interface IInvestimento {

    double calcula(Account account);

}
