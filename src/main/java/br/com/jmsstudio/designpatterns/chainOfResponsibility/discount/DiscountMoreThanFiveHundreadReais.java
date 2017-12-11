package br.com.jmsstudio.designpatterns.chainOfResponsibility.discount;

import br.com.jmsstudio.model.Budget;

public class DiscountMoreThanFiveHundreadReais implements IDiscount {

    private IDiscount next;

    @Override
    public double calculateDiscount(Budget budget) {

        double discount;

        if (budget.getValue() > 500) {
            discount = budget.getValue() * 0.07;
        } else {
            discount = this.next.calculateDiscount(budget);
        }

        return discount;
    }

    @Override
    public void setNext(IDiscount desconto) {
        this.next = desconto;
    }
}
