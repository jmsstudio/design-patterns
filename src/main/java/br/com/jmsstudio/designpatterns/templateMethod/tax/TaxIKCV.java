package br.com.jmsstudio.designpatterns.templateMethod.tax;

import br.com.jmsstudio.designpatterns.decorator.tax.Tax;
import br.com.jmsstudio.model.BudgetItem;
import br.com.jmsstudio.model.Budget;

public class TaxIKCV extends TemplateTaxCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.1;
    public static final double TAXA_MINIMA_IMPOSTO = 0.06;

    public TaxIKCV(Tax taxCombinado) {
        super(taxCombinado);
    }

    public TaxIKCV() {
        super();
    }

    @Override
    public boolean deveUsarTaxaMaxima(Budget budget) {
        return budget.getValue() > 500 && temItemComValorMaiorQue100(budget);
    }

    private boolean temItemComValorMaiorQue100(Budget budget) {
        BudgetItem budgetItem = budget.getBudgetItems().stream().filter(i -> i.getValue() > 100).findFirst().orElse(null);

        return budgetItem != null;
    }

    @Override
    public double calcularTaxaMaxima(Budget budget) {
        return budget.getValue() * TAXA_MAXIMA_IMPOSTO;
    }

    @Override
    public double calcularTaxaMinima(Budget budget) {
        return budget.getValue() * TAXA_MINIMA_IMPOSTO;
    }
}
