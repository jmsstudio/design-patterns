package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Budget;

public interface IDesconto {

    double calcularDesconto(Budget budget);

    void setProximo(IDesconto desconto);
}
