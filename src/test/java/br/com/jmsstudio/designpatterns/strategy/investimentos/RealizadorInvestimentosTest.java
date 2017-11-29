package br.com.jmsstudio.designpatterns.strategy.investimentos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealizadorInvestimentosTest {

    @Test
    public void calculaInvestimentoConservador() {

        double saldoInicial = 500;

        Conta conta = new Conta(saldoInicial);

        IInvestimento investimento = new InvestimentoConservador();

        new RealizadorInvestimentos().realizarInvestimento(investimento, conta);

        assertEquals(saldoInicial + saldoInicial * 0.8, conta.getSaldo(), 0.0);
    }

    @Test
    public void calculaInvestimentoModerado() {

        double saldoInicial = 500;

        Conta conta = new Conta(saldoInicial);

        IInvestimento investimento = new InvestimentoModerado();

        new RealizadorInvestimentos().realizarInvestimento(investimento, conta);


        double possibilidade1 = saldoInicial + saldoInicial * 0.025;
        double possibilidade2 = saldoInicial + saldoInicial * 0.8;

        assertTrue(conta.getSaldo() == possibilidade1 || conta.getSaldo() == possibilidade2);
    }
}
