package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICCC;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICMS;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoISS;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoMuitoAlto;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoICPP;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoIHIT;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoIKCV;
import br.com.jmsstudio.model.Orcamento;
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

    @Test
    public void calculaIKCVMaior500ComItemMaior100() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 550;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("teste", 550);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoIKCV.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMaior500SemItemMaior100() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 550;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("teste", 50);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMenor500() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 50;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMenor500() {
        Imposto imposto = new ImpostoICPP();
        double valor = 50;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICPP.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMaior500() {
        Imposto imposto = new ImpostoICPP();
        double valor = 550;
        Orcamento orcamento = new Orcamento(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoICPP.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITComItensNomeRepetido() {
        Imposto imposto = new ImpostoIHIT();
        double valor = 550;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 100);
        orcamento.adicionaItem("Item 1", 200);
        orcamento.adicionaItem("Item 2", 200);
        orcamento.adicionaItem("Item 3", 50);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoIHIT.TAXA_MAXIMA_IMPOSTO + ImpostoIHIT.PARCELA_FIXA_IMPOSTO_MAXIMO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITSemItensRepetidos() {
        Imposto imposto = new ImpostoIHIT();
        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 200);
        orcamento.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, orcamento);

        assertEquals(valor * ImpostoIHIT.TAXA_MINIMA_IMPOSTO * orcamento.getItems().stream().count(), impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinados() {

        Imposto impostoISS = new ImpostoISS();
        Imposto impostoICMS = new ImpostoICMS(impostoISS);

        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 200);
        orcamento.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoICMS, orcamento);

        assertEquals(valor * ImpostoICMS.TAXA_IMPOSTO + valor * ImpostoISS.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinadosComImpostoMuitoAlto() {

        Imposto impostoISS = new ImpostoISS();
        Imposto impostoICMS = new ImpostoICMS(impostoISS);
        Imposto impostoMuitoAlto = new ImpostoMuitoAlto(impostoICMS);

        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 200);
        orcamento.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoMuitoAlto, orcamento);

        assertEquals(valor * ImpostoICMS.TAXA_IMPOSTO + valor * ImpostoISS.TAXA_IMPOSTO + valor * ImpostoMuitoAlto.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinadosComImpostosCondicionais() {

        Imposto impostoICPP = new ImpostoICPP();
        Imposto impostoIKCV = new ImpostoIKCV(impostoICPP);

        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 200);
        orcamento.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoIKCV, orcamento);

        assertEquals(valor * ImpostoICPP.TAXA_MINIMA_IMPOSTO + valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

}
