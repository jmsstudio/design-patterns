package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.model.Orcamento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraDescontosTest {

    @Test
    public void calculaDescontoParaOrcamentoComValorMenorQue500() {
        double valor = 100;
        Orcamento orcamento = new Orcamento(valor);

        double desconto = new CalculadoraDescontos().calcularDesconto(orcamento);

        assertEquals(0, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaOrcamentoComValorMaiorQue500() {
        double valor = 600;
        Orcamento orcamento = new Orcamento(valor);

        double desconto = new CalculadoraDescontos().calcularDesconto(orcamento);

        assertEquals(valor * 0.07, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaOrcamentoComMaisDe5Itens() {
        double valor = 500;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Item 1", 100);
        orcamento.adicionaItem("Item 2", 100);
        orcamento.adicionaItem("Item 3", 100);
        orcamento.adicionaItem("Item 4", 100);
        orcamento.adicionaItem("Item 5", 50);
        orcamento.adicionaItem("Item 6", 50);

        double desconto = new CalculadoraDescontos().calcularDesconto(orcamento);

        assertEquals(valor * 0.1, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaVendaCombinada() {
        double valor = 200;
        Orcamento orcamento = new Orcamento(valor);
        orcamento.adicionaItem("Lapis", 100);
        orcamento.adicionaItem("CANETA", 100);

        double desconto = new CalculadoraDescontos().calcularDesconto(orcamento);

        assertEquals(valor * 0.5, desconto, 0.0);
    }
}
