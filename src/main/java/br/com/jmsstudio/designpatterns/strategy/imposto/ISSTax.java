package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class ISSTax extends Tax {

    public static final double TAXA_IMPOSTO = 0.1;

    public ISSTax(Tax taxCombinado) {
        super(taxCombinado);
    }

    public ISSTax() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        return budget.getValue() * TAXA_IMPOSTO + calculaImpostoCombinado(budget);
    }
}
