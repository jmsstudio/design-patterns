package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Orcamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DescontoVendaCombinada implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Orcamento orcamento) {
        double desconto;

        if (isVendaCombinada(orcamento)) {
            desconto = orcamento.getValor() * 0.5;
        } else {
            desconto = this.proximo.calcularDesconto(orcamento);
        }

        return desconto;
    }

    private boolean isVendaCombinada(Orcamento orcamento) {
        List<String> itensDesconto = new ArrayList<>();
        itensDesconto.add("lapis");
        itensDesconto.add("caneta");

        return orcamento.getItems().stream()
                .map(i -> i.getNome().toLowerCase())
                .collect(Collectors.toList())
                .containsAll(itensDesconto);
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
