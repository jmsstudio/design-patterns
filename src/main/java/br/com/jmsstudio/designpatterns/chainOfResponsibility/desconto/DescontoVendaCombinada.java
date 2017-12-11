package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Budget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DescontoVendaCombinada implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Budget budget) {
        double desconto;

        if (isVendaCombinada(budget)) {
            desconto = budget.getValor() * 0.5;
        } else {
            desconto = this.proximo.calcularDesconto(budget);
        }

        return desconto;
    }

    private boolean isVendaCombinada(Budget budget) {
        List<String> itensDesconto = new ArrayList<>();
        itensDesconto.add("lapis");
        itensDesconto.add("caneta");

        return budget.getBudgetItems().stream()
                .map(i -> i.getNome().toLowerCase())
                .collect(Collectors.toList())
                .containsAll(itensDesconto);
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
