package br.com.jmsstudio.designpatterns.strategy.investimentos;

import br.com.jmsstudio.model.Account;

public class RealizadorInvestimentos {

    public void realizarInvestimento(IInvestimento investimento, Account account) {
        double resultado = investimento.calcula(account);

        account.deposita(resultado);
        System.out.println("Novo saldo da account: " + account.getSaldo());
    }
}
