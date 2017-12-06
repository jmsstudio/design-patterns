package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Item;
import br.com.jmsstudio.model.Orcamento;

public class ImpostoIKCV extends TemplateImpostoCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.1;
    public static final double TAXA_MINIMA_IMPOSTO = 0.06;

    public ImpostoIKCV(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoIKCV() {
        super();
    }

    @Override
    public boolean deveUsarTaxaMaxima(Orcamento orcamento) {
        return orcamento.getValor() > 500 && temItemComValorMaiorQue100(orcamento);
    }

    private boolean temItemComValorMaiorQue100(Orcamento orcamento) {
        Item item = orcamento.getItems().stream().filter(i -> i.getValor() > 100).findFirst().orElse(null);

        return item != null;
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
