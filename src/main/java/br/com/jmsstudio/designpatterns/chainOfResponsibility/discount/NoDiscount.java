package br.com.jmsstudio.designpatterns.chainOfResponsibility.discount;

import br.com.jmsstudio.model.Budget;

public class NoDiscount implements IDiscount {
    @Override
    public double calculateDiscount(Budget budget) {
        return 0;
    }

    @Override
    public void setNext(IDiscount desconto) {
        //no next
    }
}
