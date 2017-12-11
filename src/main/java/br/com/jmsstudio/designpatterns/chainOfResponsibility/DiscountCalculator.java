package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.discount.*;
import br.com.jmsstudio.model.Budget;

public class DiscountCalculator {

    public double calcularDesconto(Budget budget) {
        IDiscount desconto1 = new DiscountMoreThanFiveItems();
        IDiscount desconto2 = new DiscountMoreThanFiveHundreadReais();
        IDiscount desconto3 = new DiscountCombinedSale();
        IDiscount desconto4 = new NoDiscount();

        desconto1.setNext(desconto2);
        desconto2.setNext(desconto3);
        desconto3.setNext(desconto4);

        return desconto1.calculateDiscount(budget);
    }
}
