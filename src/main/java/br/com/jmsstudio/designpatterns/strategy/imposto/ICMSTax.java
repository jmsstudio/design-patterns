package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class ICMSTax extends Tax {

    public static final double TAXA_IMPOSTO = 0.06;

    public ICMSTax(Tax taxCombinado) {
        super(taxCombinado);
    }

    public ICMSTax() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        return budget.getValue() * TAXA_IMPOSTO + calculaImpostoCombinado(budget);
    }
}
