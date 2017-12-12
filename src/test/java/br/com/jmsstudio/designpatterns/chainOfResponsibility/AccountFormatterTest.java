package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.format.Format;
import br.com.jmsstudio.model.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountFormatterTest {

    @Test
    public void deveFormatarContaParaXMLCorretamente() {
        Account account = new Account("Titular 1", 500);

        AccountFormatter formatter = new AccountFormatter(Format.XML);

        String expectedValue = "<account><titular>" + account.getTitularName() +
                "</titular><saldo>" + account.getBalance() +
                "</saldo></account>";

        assertEquals(expectedValue, formatter.format(account));
    }

    @Test
    public void deveFormatarContaParaCSVCorretamente() {
        Account account = new Account("Titular 1", 500);

        AccountFormatter formatter = new AccountFormatter(Format.CSV);

        String expectedValue = account.getTitularName() + "," + account.getBalance();

        assertEquals(expectedValue, formatter.format(account));
    }

    @Test
    public void deveFormatarContaParaPorcentagemCorretamente() {
        Account account = new Account("Titular 1", 500);

        AccountFormatter formatter = new AccountFormatter(Format.PORCENTAGEM);

        String expectedValue = account.getTitularName() + "%" + account.getBalance();

        assertEquals(expectedValue, formatter.format(account));
    }

    @Test
    public void deveDevolverContaSemFormatacao() {
        Account account = new Account("Titular 1", 500);

        AccountFormatter formatter = new AccountFormatter(null);

        String expectedValue = account.toString();

        assertEquals(expectedValue, formatter.format(account));
    }

}
