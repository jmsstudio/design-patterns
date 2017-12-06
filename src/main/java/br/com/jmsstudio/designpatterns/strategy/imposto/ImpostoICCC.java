package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.Orcamento;

public class ImpostoICCC extends Imposto {

    public static final double TAXA_IMPOSTO_1 = 0.05;
    public static final double TAXA_IMPOSTO_2 = 0.07;
    public static final double TAXA_IMPOSTO_3 = 0.08;
    public static final double VALOR_FIXO_IMPOSTO = 30;

    public ImpostoICCC(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoICCC() {
        super();
    }

    @Override
    public double calcula(Orcamento orcamento) {
        double impostoCalculado = 0;
        double valorOrcamento = orcamento.getValor();

        if (valorOrcamento < 1000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_1;
        } else if (valorOrcamento >= 1000 && valorOrcamento <= 3000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_2;
        } else if (valorOrcamento > 3000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_3 + 30;
        }

        return impostoCalculado + calculaImpostoCombinado(orcamento);
    }
}
