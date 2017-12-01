package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto.*;
import br.com.jmsstudio.model.Orcamento;

public class CalculadoraDescontos {

    public double calcularDesconto(Orcamento orcamento) {
        IDesconto desconto1 = new DescontoMaisDeCincoItens();
        IDesconto desconto2 = new DescontoMaisDeQuinhentosReais();
        IDesconto desconto3 = new DescontoVendaCombinada();
        IDesconto desconto4 = new SemDesconto();

        desconto1.setProximo(desconto2);
        desconto2.setProximo(desconto3);
        desconto3.setProximo(desconto4);

        return desconto1.calcularDesconto(orcamento);
    }
}
