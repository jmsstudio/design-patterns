package br.com.jmsstudio.designpatterns.decorator.imposto;

import br.com.jmsstudio.model.Budget;

public abstract class Imposto {

    private Imposto impostoCombinado;

    public Imposto(Imposto impostoCombinado) {
        this.impostoCombinado = impostoCombinado;
    }

    public Imposto() {
        this.impostoCombinado = null;
    }

    protected double calculaImpostoCombinado(Budget budget) {
        double total = 0;

        if (this.impostoCombinado != null) {
            total = impostoCombinado.calcula(budget);
        }

        return total;
    }

    public abstract double calcula(Budget budget);

}
