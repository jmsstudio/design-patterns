package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.strategy.Orcamento;

public interface Imposto {

    double calcula(Orcamento orcamento);

}
