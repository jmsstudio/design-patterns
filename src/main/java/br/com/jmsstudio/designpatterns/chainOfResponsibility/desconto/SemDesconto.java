package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Orcamento;

public class SemDesconto implements IDesconto {
    @Override
    public double calcularDesconto(Orcamento orcamento) {
        return 0;
    }

    @Override
    public void setProximo(IDesconto desconto) {
        //sem proximo
    }
}
