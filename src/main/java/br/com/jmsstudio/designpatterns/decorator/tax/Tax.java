package br.com.jmsstudio.designpatterns.decorator.tax;

import br.com.jmsstudio.model.Budget;

public abstract class Tax {

    private Tax taxCombinado;

    public Tax(Tax taxCombinado) {
        this.taxCombinado = taxCombinado;
    }

    public Tax() {
        this.taxCombinado = null;
    }

    protected double calculaImpostoCombinado(Budget budget) {
        double total = 0;

        if (this.taxCombinado != null) {
            total = taxCombinado.calcula(budget);
        }

        return total;
    }

    public abstract double calcula(Budget budget);

}
