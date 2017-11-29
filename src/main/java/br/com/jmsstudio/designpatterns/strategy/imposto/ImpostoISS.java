package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.model.Orcamento;

public class ImpostoISS implements Imposto {

    public static final double TAXA_IMPOSTO = 0.1;

    @Override
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * TAXA_IMPOSTO;
    }
}
