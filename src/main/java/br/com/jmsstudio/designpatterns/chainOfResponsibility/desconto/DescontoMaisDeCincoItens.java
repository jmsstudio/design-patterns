package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Budget;

public class DescontoMaisDeCincoItens implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Budget budget) {
        double desconto;

        if (budget.getBudgetItems().size() >= 5) {
            desconto = budget.getValor() * 0.1;
        } else {
            desconto = proximo.calcularDesconto(budget);
        }

        return desconto;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
