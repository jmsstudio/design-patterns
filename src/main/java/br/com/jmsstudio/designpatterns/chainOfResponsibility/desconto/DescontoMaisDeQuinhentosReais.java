package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Orcamento;

public class DescontoMaisDeQuinhentosReais implements IDesconto {

    private IDesconto proximo;

    @Override
    public double calcularDesconto(Orcamento orcamento) {

        double desconto;

        if (orcamento.getValor() > 500) {
            desconto = orcamento.getValor() * 0.07;
        } else {
            desconto = this.proximo.calcularDesconto(orcamento);
        }

        return desconto;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        this.proximo = desconto;
    }
}
