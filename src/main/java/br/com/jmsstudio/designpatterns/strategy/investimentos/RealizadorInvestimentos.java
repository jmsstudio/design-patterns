package br.com.jmsstudio.designpatterns.strategy.investimentos;

public class RealizadorInvestimentos {

    public void realizarInvestimento(IInvestimento investimento, Conta conta) {
        double resultado = investimento.calcula(conta);

        conta.deposita(resultado);
        System.out.println("Novo saldo da conta: " + conta.getSaldo());
    }
}
