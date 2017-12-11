package br.com.jmsstudio.designpatterns.templateMethod.tax;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public abstract class TemplateTaxCondicional extends Tax {

    public TemplateTaxCondicional(Tax taxCombinado) {
        super(taxCombinado);
    }

    public TemplateTaxCondicional() {
        super();
    }

    @Override
    public double calcula(Budget budget) {

        double valorCalculado;

        if (deveUsarTaxaMaxima(budget)) {
            valorCalculado = calcularTaxaMaxima(budget);
        } else {
            valorCalculado = calcularTaxaMinima(budget);
        }

        return valorCalculado + calculaImpostoCombinado(budget);
    }

    public abstract boolean deveUsarTaxaMaxima(Budget budget);

    public abstract double calcularTaxaMaxima(Budget budget);

    public abstract double calcularTaxaMinima(Budget budget);
}
