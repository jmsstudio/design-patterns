package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.model.Orcamento;

public interface Imposto {

    double calcula(Orcamento orcamento);

}
