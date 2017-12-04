package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.model.Orcamento;

public class ImpostoICPP extends TemplateImpostoCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.07;
    public static final double TAXA_MINIMA_IMPOSTO = 0.05;


    @Override
    public boolean deveUsarTaxaMaxima(Orcamento orcamento) {
        return orcamento.getValor() > 500;
    }

    @Override
    public double calcularTaxaMaxima(Orcamento orcamento) {
        return orcamento.getValor() * TAXA_MAXIMA_IMPOSTO;
    }

    @Override
    public double calcularTaxaMinima(Orcamento orcamento) {
        return orcamento.getValor() * TAXA_MINIMA_IMPOSTO;
    }
}
