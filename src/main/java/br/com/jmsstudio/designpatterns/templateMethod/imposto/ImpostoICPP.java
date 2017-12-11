package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Budget;

public class ImpostoICPP extends TemplateImpostoCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.07;
    public static final double TAXA_MINIMA_IMPOSTO = 0.05;

    public ImpostoICPP(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoICPP() {
        super();
    }

    @Override
    public boolean deveUsarTaxaMaxima(Budget budget) {
        return budget.getValor() > 500;
    }

    @Override
    public double calcularTaxaMaxima(Budget budget) {
        return budget.getValor() * TAXA_MAXIMA_IMPOSTO;
    }

    @Override
    public double calcularTaxaMinima(Budget budget) {
        return budget.getValor() * TAXA_MINIMA_IMPOSTO;
    }
}
