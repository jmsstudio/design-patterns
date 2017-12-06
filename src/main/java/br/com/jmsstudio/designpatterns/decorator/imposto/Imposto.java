package br.com.jmsstudio.designpatterns.decorator.imposto;

import br.com.jmsstudio.model.Orcamento;

public abstract class Imposto {

    private Imposto impostoCombinado;

    public Imposto(Imposto impostoCombinado) {
        this.impostoCombinado = impostoCombinado;
    }

    public Imposto() {
        this.impostoCombinado = null;
    }

    protected double calculaImpostoCombinado(Orcamento orcamento) {
        double total = 0;

        if (this.impostoCombinado != null) {
            total = impostoCombinado.calcula(orcamento);
        }

        return total;
    }

    public abstract double calcula(Orcamento orcamento);

}
