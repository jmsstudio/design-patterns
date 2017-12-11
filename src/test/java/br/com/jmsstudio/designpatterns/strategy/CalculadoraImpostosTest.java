package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICCC;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoICMS;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoISS;
import br.com.jmsstudio.designpatterns.strategy.imposto.ImpostoMuitoAlto;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoICPP;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoIHIT;
import br.com.jmsstudio.designpatterns.templateMethod.imposto.ImpostoIKCV;
import br.com.jmsstudio.model.Budget;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraImpostosTest {

    @Test
    public void calculaIcms() {
        Imposto imposto = new ImpostoICMS();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICMS.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaISS() {
        Imposto imposto = new ImpostoISS();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoISS.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMenor1000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_1, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCEntre1000E3000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 1500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_2, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMaior3000() {
        Imposto imposto = new ImpostoICCC();
        double valor = 3500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICCC.TAXA_IMPOSTO_3 + ImpostoICCC.VALOR_FIXO_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMaior500ComItemMaior100() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.adicionaItem("teste", 550);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoIKCV.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMaior500SemItemMaior100() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.adicionaItem("teste", 50);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMenor500() {
        Imposto imposto = new ImpostoIKCV();
        double valor = 50;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMenor500() {
        Imposto imposto = new ImpostoICPP();
        double valor = 50;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICPP.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMaior500() {
        Imposto imposto = new ImpostoICPP();
        double valor = 550;
        Budget budget = new Budget(valor);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoICPP.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITComItensNomeRepetido() {
        Imposto imposto = new ImpostoIHIT();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 100);
        budget.adicionaItem("Item 1", 200);
        budget.adicionaItem("Item 2", 200);
        budget.adicionaItem("Item 3", 50);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoIHIT.TAXA_MAXIMA_IMPOSTO + ImpostoIHIT.PARCELA_FIXA_IMPOSTO_MAXIMO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITSemItensRepetidos() {
        Imposto imposto = new ImpostoIHIT();
        double valor = 500;
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 200);
        budget.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(imposto, budget);

        assertEquals(valor * ImpostoIHIT.TAXA_MINIMA_IMPOSTO * budget.getBudgetItems().stream().count(), impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinados() {

        Imposto impostoISS = new ImpostoISS();
        Imposto impostoICMS = new ImpostoICMS(impostoISS);

        double valor = 500;
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 200);
        budget.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoICMS, budget);

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
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 200);
        budget.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoMuitoAlto, budget);

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
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 200);
        budget.adicionaItem("Item 2", 300);

        double impostoCalculado = new CalculadoraImpostos().calcula(impostoIKCV, budget);

        assertEquals(valor * ImpostoICPP.TAXA_MINIMA_IMPOSTO + valor * ImpostoIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

}
