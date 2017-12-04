package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.strategy.imposto.Imposto;
import br.com.jmsstudio.model.Orcamento;

public abstract class TemplateImpostoCondicional implements Imposto {

    @Override
    public double calcula(Orcamento orcamento) {

        double valorCalculado;

        if (deveUsarTaxaMaxima(orcamento)) {
            valorCalculado = calcularTaxaMaxima(orcamento);
        } else {
            valorCalculado = calcularTaxaMinima(orcamento);
        }

        return valorCalculado;
    }

    public abstract boolean deveUsarTaxaMaxima(Orcamento orcamento);

    public abstract double calcularTaxaMaxima(Orcamento orcamento);

    public abstract double calcularTaxaMinima(Orcamento orcamento);
}
