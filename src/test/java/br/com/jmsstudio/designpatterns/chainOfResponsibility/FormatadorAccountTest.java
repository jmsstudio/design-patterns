package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.format.Formato;
import br.com.jmsstudio.model.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatadorAccountTest {

    @Test
    public void deveFormatarContaParaXMLCorretamente() {
        Account account = new Account("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.XML);

        String valorEsperado = "<account><titular>" + account.getNomeTitular() +
                "</titular><saldo>" + account.getSaldo() +
                "</saldo></account>";

        assertEquals(valorEsperado, formatador.format(account));
    }

    @Test
    public void deveFormatarContaParaCSVCorretamente() {
        Account account = new Account("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.CSV);

        String valorEsperado = account.getNomeTitular() + "," + account.getSaldo();

        assertEquals(valorEsperado, formatador.format(account));
    }

    @Test
    public void deveFormatarContaParaPorcentagemCorretamente() {
        Account account = new Account("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.PORCENTAGEM);

        String valorEsperado = account.getNomeTitular() + "%" + account.getSaldo();

        assertEquals(valorEsperado, formatador.format(account));
    }

    @Test
    public void deveDevolverContaSemFormatacao() {
        Account account = new Account("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(null);

        String valorEsperado = account.toString();

        assertEquals(valorEsperado, formatador.format(account));
    }

}
