package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.strategy.imposto.Imposto;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICCC;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICMS;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoISS;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraImpostosTest {

    @Test
    public void calculaIcms() {
        Imposto imposto = new ImpostoICMS();
        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICMS.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaISS() {
        Imposto imposto = new ImpostoISS();
        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoISS.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMenor1000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_1, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCEntre1000E3000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 1500;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_2, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMaior3000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 3500;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_3 + ImpostoICCC.VALOR_FIXO_IMPOSTO, impostoCalculado, 0.0);
    }
}
