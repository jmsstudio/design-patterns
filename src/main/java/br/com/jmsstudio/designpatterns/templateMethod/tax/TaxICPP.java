package br.com.jmsstudio.designpatterns.templateMethod.tax;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class TaxICPP extends TemplateTaxCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.07;
    public static final double TAXA_MINIMA_IMPOSTO = 0.05;

    public TaxICPP(Tax taxCombinado) {
        super(taxCombinado);
    }

    public TaxICPP() {
        super();
    }

    @Override
    public boolean deveUsarTaxaMaxima(Budget budget) {
        return budget.getValue() > 500;
    }

    @Override
    public double calcularTaxaMaxima(Budget budget) {
        return budget.getValue() * TAXA_MAXIMA_IMPOSTO;
    }

    @Override
    public double calcularTaxaMinima(Budget budget) {
        return budget.getValue() * TAXA_MINIMA_IMPOSTO;
    }
}
