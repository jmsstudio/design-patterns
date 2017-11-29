package br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto;

import br.com.jmsstudio.model.Orcamento;

public interface IDesconto {

    double calcularDesconto(Orcamento orcamento);

    void setProximo(IDesconto desconto);
}
