package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.designpatterns.strategy.imposto.ICCCTax;
import br.com.jmsstudio.designpatterns.strategy.imposto.ICMSTax;
import br.com.jmsstudio.designpatterns.strategy.imposto.ISSTax;
import br.com.jmsstudio.designpatterns.strategy.imposto.VeryExpensiveTax;
import br.com.jmsstudio.designpatterns.templateMethod.tax.TaxICPP;
import br.com.jmsstudio.designpatterns.templateMethod.tax.TaxIHIT;
import br.com.jmsstudio.designpatterns.templateMethod.tax.TaxIKCV;
import br.com.jmsstudio.model.Budget;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void calculaIcms() {
        Tax tax = new ICMSTax();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * ICMSTax.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaISS() {
        Tax tax = new ISSTax();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * ISSTax.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMenor1000() {
        Tax tax = new ICCCTax();
        double valor = 500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * ICCCTax.TAXA_IMPOSTO_1, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCEntre1000E3000() {
        Tax tax = new ICCCTax();
        double valor = 1500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * ICCCTax.TAXA_IMPOSTO_2, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICCCMaior3000() {
        Tax tax = new ICCCTax();
        double valor = 3500;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * ICCCTax.TAXA_IMPOSTO_3 + ICCCTax.VALOR_FIXO_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMaior500ComItemMaior100() {
        Tax tax = new TaxIKCV();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.addItem("teste", 550);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxIKCV.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMaior500SemItemMaior100() {
        Tax tax = new TaxIKCV();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.addItem("teste", 50);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIKCVMenor500() {
        Tax tax = new TaxIKCV();
        double valor = 50;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMenor500() {
        Tax tax = new TaxICPP();
        double valor = 50;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxICPP.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaICPPMaior500() {
        Tax tax = new TaxICPP();
        double valor = 550;
        Budget budget = new Budget(valor);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxICPP.TAXA_MAXIMA_IMPOSTO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITComItensNomeRepetido() {
        Tax tax = new TaxIHIT();
        double valor = 550;
        Budget budget = new Budget(valor);
        budget.addItem("Item 1", 100);
        budget.addItem("Item 1", 200);
        budget.addItem("Item 2", 200);
        budget.addItem("Item 3", 50);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxIHIT.TAXA_MAXIMA_IMPOSTO + TaxIHIT.PARCELA_FIXA_IMPOSTO_MAXIMO, impostoCalculado, 0.0);
    }

    @Test
    public void calculaIHITSemItensRepetidos() {
        Tax tax = new TaxIHIT();
        double valor = 500;
        Budget budget = new Budget(valor);
        budget.addItem("Item 1", 200);
        budget.addItem("Item 2", 300);

        double impostoCalculado = new TaxCalculator().calcula(tax, budget);

        assertEquals(valor * TaxIHIT.TAXA_MINIMA_IMPOSTO * budget.getBudgetItems().stream().count(), impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinados() {

        Tax taxISS = new ISSTax();
        Tax taxICMS = new ICMSTax(taxISS);

        double valor = 500;
        Budget budget = new Budget(valor);
        budget.addItem("Item 1", 200);
        budget.addItem("Item 2", 300);

        double impostoCalculado = new TaxCalculator().calcula(taxICMS, budget);

        assertEquals(valor * ICMSTax.TAXA_IMPOSTO + valor * ISSTax.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinadosComImpostoMuitoAlto() {

        Tax taxISS = new ISSTax();
        Tax taxICMS = new ICMSTax(taxISS);
        Tax taxMuitoAlto = new VeryExpensiveTax(taxICMS);

        double valor = 500;
        Budget budget = new Budget(valor);
        budget.addItem("Item 1", 200);
        budget.addItem("Item 2", 300);

        double impostoCalculado = new TaxCalculator().calcula(taxMuitoAlto, budget);

        assertEquals(valor * ICMSTax.TAXA_IMPOSTO + valor * ISSTax.TAXA_IMPOSTO + valor * VeryExpensiveTax.TAXA_IMPOSTO, impostoCalculado, 0.0);
    }

    /**
     * Test decorator
     */
    @Test
    public void calculaImpostosCombinadosComImpostosCondicionais() {

        Tax taxICPP = new TaxICPP();
        Tax taxIKCV = new TaxIKCV(taxICPP);

        double valor = 500;
        Budget budget = new Budget(valor);
        budget.addItem("Item 1", 200);
        budget.addItem("Item 2", 300);

        double impostoCalculado = new TaxCalculator().calcula(taxIKCV, budget);

        assertEquals(valor * TaxICPP.TAXA_MINIMA_IMPOSTO + valor * TaxIKCV.TAXA_MINIMA_IMPOSTO, impostoCalculado, 0.0);
    }

}
