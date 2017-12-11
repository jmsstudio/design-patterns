package br.com.jmsstudio.designpatterns.chainOfResponsibility.discount;

import br.com.jmsstudio.model.Budget;

public class DiscountMoreThanFiveItems implements IDiscount {

    private IDiscount next;

    @Override
    public double calculateDiscount(Budget budget) {
        double discount;

        if (budget.getBudgetItems().size() >= 5) {
            discount = budget.getValue() * 0.1;
        } else {
            discount = next.calculateDiscount(budget);
        }

        return discount;
    }

    @Override
    public void setNext(IDiscount desconto) {
        this.next = desconto;
    }
}
