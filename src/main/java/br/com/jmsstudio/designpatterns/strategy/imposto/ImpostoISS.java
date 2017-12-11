package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Budget;

public class ImpostoISS extends Imposto {

    public static final double TAXA_IMPOSTO = 0.1;

    public ImpostoISS(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoISS() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        return budget.getValor() * TAXA_IMPOSTO + calculaImpostoCombinado(budget);
    }
}
