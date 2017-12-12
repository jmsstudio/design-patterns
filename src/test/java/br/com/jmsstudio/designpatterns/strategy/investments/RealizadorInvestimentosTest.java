package br.com.jmsstudio.designpatterns.strategy.investments;

import br.com.jmsstudio.designpatterns.state.account.PositiveState;
import br.com.jmsstudio.model.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealizadorInvestimentosTest {

    @Test
    public void calculaInvestimentoConservador() {

        double saldoInicial = 500;

        Account account = new Account(saldoInicial);

        IInvestimento investimento = new InvestimentoConservador();

        new RealizadorInvestimentos().realizarInvestimento(investimento, account);

        assertEquals(saldoInicial + ((saldoInicial * 0.8) - (saldoInicial * 0.8) * PositiveState.DEPOSIT_RATE), account.getBalance(), 0.0);
    }

    @Test
    public void calculaInvestimentoModerado() {

        double saldoInicial = 500;

        Account account = new Account(saldoInicial);

        IInvestimento investimento = new InvestimentoModerado();

        new RealizadorInvestimentos().realizarInvestimento(investimento, account);


        double possibilidade1 = saldoInicial + (saldoInicial * 0.025 - saldoInicial * 0.025 * PositiveState.DEPOSIT_RATE);
        double possibilidade2 = saldoInicial + (saldoInicial * 0.8 - saldoInicial * 0.8 * PositiveState.DEPOSIT_RATE);

        assertTrue(account.getBalance() == possibilidade1 || account.getBalance() == possibilidade2);
    }
}
