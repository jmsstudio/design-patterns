package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Orcamento;

public class DescontoMaisDeCincoItens implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Orcamento orcamento) {
        double desconto;

        if (orcamento.getItems().size() >= 5) {
            desconto = orcamento.getValor() * 0.1;
        } else {
            desconto = proximo.calcularDesconto(orcamento);
        }

        return desconto;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
