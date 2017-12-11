package br.com.jmsstudio.designpatterns.chainOfResponsibility.discount;

import br.com.jmsstudio.model.Budget;

public interface IDiscount {

    double calculateDiscount(Budget budget);

    void setNext(IDiscount desconto);
}
