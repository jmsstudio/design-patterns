package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.BudgetItem;
import br.com.jmsstudio.model.Budget;

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
    public boolean deveUsarTaxaMaxima(Budget budget) {
        return budget.getValor() > 500 && temItemComValorMaiorQue100(budget);
    }

    private boolean temItemComValorMaiorQue100(Budget budget) {
        BudgetItem budgetItem = budget.getBudgetItems().stream().filter(i -> i.getValor() > 100).findFirst().orElse(null);

        return budgetItem != null;
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
