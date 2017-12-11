package br.com.jmsstudio.designpatterns.strategy;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Budget;

public class CalculadoraImpostos {

    public double calcula(Imposto imposto, Budget budget) {
        return imposto.calcula(budget);
    }
}
