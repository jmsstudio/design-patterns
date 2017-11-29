package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto.DescontoMaisDeCincoItens;
import br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto.DescontoMaisDeQuinhentosReais;
import br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto.IDesconto;
import br.com.jmsstudio.designpatterns.chainOfResponsibility.desconto.SemDesconto;
import br.com.jmsstudio.model.Orcamento;

public class CalculadoraDescontos {

    public double calcularDesconto(Orcamento orcamento) {
        IDesconto desconto1 = new DescontoMaisDeCincoItens();
        IDesconto desconto2 = new DescontoMaisDeQuinhentosReais();
        IDesconto desconto3 = new SemDesconto();

        desconto1.setProximo(desconto2);
        desconto2.setProximo(desconto3);

        return desconto1.calcularDesconto(orcamento);
    }
}
