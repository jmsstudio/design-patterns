package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.model.Account;

public class RealizadorInvestimentos {

    public void realizarInvestimento(IInvestimento investimento, Account account) {
        double resultado = investimento.calcula(account);

        account.deposit(resultado);
        System.out.println("Novo saldo da account: " + account.getBalance());
    }
}
