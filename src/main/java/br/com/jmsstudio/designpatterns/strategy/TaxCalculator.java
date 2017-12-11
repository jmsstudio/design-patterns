package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class TaxCalculator {

    public double calcula(Tax tax, Budget budget) {
        return tax.calcula(budget);
    }
}
