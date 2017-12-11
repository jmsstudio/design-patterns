package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Budget;

public class SemDesconto implements IDesconto {
    @Override
    public double calcularDesconto(Budget budget) {
        return 0;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        //sem proximo
    }
}
