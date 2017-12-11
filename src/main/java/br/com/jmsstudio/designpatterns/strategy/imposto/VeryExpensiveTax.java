package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class VeryExpensiveTax extends Tax {

    public static final double TAXA_IMPOSTO = 0.2;

    public VeryExpensiveTax(Tax taxCombinado) {
        super(taxCombinado);
    }

    public VeryExpensiveTax() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        return budget.getValue() * TAXA_IMPOSTO + calculaImpostoCombinado(budget);
    }
}
