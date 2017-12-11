package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Budget;

public class ImpostoMuitoAlto extends Imposto {

    public static final double TAXA_IMPOSTO = 0.2;

    public ImpostoMuitoAlto(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoMuitoAlto() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        return budget.getValor() * TAXA_IMPOSTO + calculaImpostoCombinado(budget);
    }
}
