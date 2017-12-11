package br.com.jmsstudio.designpatterns.chainOfResponsibility.discount;

import br.com.jmsstudio.model.Budget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountCombinedSale implements IDiscount {

    private IDiscount next;

    @Override
    public double calculateDiscount(Budget budget) {
        double desconto;

        if (isCombinedSale(budget)) {
            desconto = budget.getValue() * 0.5;
        } else {
            desconto = this.next.calculateDiscount(budget);
        }

        return desconto;
    }

    private boolean isCombinedSale(Budget budget) {
        List<String> itensDesconto = new ArrayList<>();
        itensDesconto.add("pencil");
        itensDesconto.add("pen");

        return budget.getBudgetItems().stream()
                .map(i -> i.getName().toLowerCase())
                .collect(Collectors.toList())
                .containsAll(itensDesconto);
    }

    @Override
    public void setNext(IDiscount desconto) {
        this.next = desconto;
    }
}
