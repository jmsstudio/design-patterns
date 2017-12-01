package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.format.Formato;
import br.com.jmsstudio.model.Conta;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatadorContaTest {

    @Test
    public void deveFormatarContaParaXMLCorretamente() {
        Conta conta = new Conta("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.XML);

        String valorEsperado = "<conta><titular>" + conta.getNomeTitular() +
                "</titular><saldo>" + conta.getSaldo() +
                "</saldo></conta>";

        assertEquals(valorEsperado, formatador.format(conta));
    }

    @Test
    public void deveFormatarContaParaCSVCorretamente() {
        Conta conta = new Conta("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.CSV);

        String valorEsperado = conta.getNomeTitular() + "," + conta.getSaldo();

        assertEquals(valorEsperado, formatador.format(conta));
    }

    @Test
    public void deveFormatarContaParaPorcentagemCorretamente() {
        Conta conta = new Conta("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(Formato.PORCENTAGEM);

        String valorEsperado = conta.getNomeTitular() + "%" + conta.getSaldo();

        assertEquals(valorEsperado, formatador.format(conta));
    }

    @Test
    public void deveDevolverContaSemFormatacao() {
        Conta conta = new Conta("Titular 1", 500);

        FormatadorConta formatador = new FormatadorConta(null);

        String valorEsperado = conta.toString();

        assertEquals(valorEsperado, formatador.format(conta));
    }

}
