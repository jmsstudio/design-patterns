package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Budget;

public class DescontoMaisDeQuinhentosReais implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Budget budget) {

        double desconto;

        if (budget.getValor() > 500) {
            desconto = budget.getValor() * 0.07;
        } else {
            desconto = this.proximo.calcularDesconto(budget);
        }

        return desconto;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
