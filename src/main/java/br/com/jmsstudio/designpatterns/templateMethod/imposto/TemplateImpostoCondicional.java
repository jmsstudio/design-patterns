package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Budget;

public abstract class TemplateImpostoCondicional extends Imposto {

    public TemplateImpostoCondicional(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public TemplateImpostoCondicional() {
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
