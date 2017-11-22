package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.strategy.imposto.Imposto;

public class CalculadoraImpostos {

    public double calcula(Imposto imposto, Orcamento orcamento) {
        return imposto.calcula(orcamento);
    }
}
