package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.strategy.Orcamento;

public class ImpostoICMS implements Imposto {

    public static final double TAXA_IMPOSTO = 0.06;

    @Override
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * TAXA_IMPOSTO;
    }
}
