package br.com.jmsstudio.designpatterns.strategy.imposto;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.Budget;

public class ICCCTax extends Tax {

    public static final double TAXA_IMPOSTO_1 = 0.05;
    public static final double TAXA_IMPOSTO_2 = 0.07;
    public static final double TAXA_IMPOSTO_3 = 0.08;
    public static final double VALOR_FIXO_IMPOSTO = 30;

    public ICCCTax(Tax taxCombinado) {
        super(taxCombinado);
    }

    public ICCCTax() {
        super();
    }

    @Override
    public double calcula(Budget budget) {
        double impostoCalculado = 0;
        double valorOrcamento = budget.getValue();

        if (valorOrcamento < 1000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_1;
        } else if (valorOrcamento >= 1000 && valorOrcamento <= 3000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_2;
        } else if (valorOrcamento > 3000) {
            impostoCalculado = valorOrcamento * TAXA_IMPOSTO_3 + 30;
        }

        return impostoCalculado + calculaImpostoCombinado(budget);
    }
}
