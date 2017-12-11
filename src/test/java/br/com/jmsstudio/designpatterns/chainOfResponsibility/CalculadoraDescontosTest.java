package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.model.Budget;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraDescontosTest {

    @Test
    public void calculaDescontoParaOrcamentoComValorMenorQue500() {
        double valor = 100;
        Budget budget = new Budget(valor);

        double desconto = new CalculadoraDescontos().calcularDesconto(budget);

        assertEquals(0, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaOrcamentoComValorMaiorQue500() {
        double valor = 600;
        Budget budget = new Budget(valor);

        double desconto = new CalculadoraDescontos().calcularDesconto(budget);

        assertEquals(valor * 0.07, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaOrcamentoComMaisDe5Itens() {
        double valor = 500;
        Budget budget = new Budget(valor);
        budget.adicionaItem("Item 1", 100);
        budget.adicionaItem("Item 2", 100);
        budget.adicionaItem("Item 3", 100);
        budget.adicionaItem("Item 4", 100);
        budget.adicionaItem("Item 5", 50);
        budget.adicionaItem("Item 6", 50);

        double desconto = new CalculadoraDescontos().calcularDesconto(budget);

        assertEquals(valor * 0.1, desconto, 0.0);
    }

    @Test
    public void calculaDescontoParaVendaCombinada() {
        double valor = 200;
        Budget budget = new Budget(valor);
        budget.adicionaItem("Lapis", 100);
        budget.adicionaItem("CANETA", 100);

        double desconto = new CalculadoraDescontos().calcularDesconto(budget);

        assertEquals(valor * 0.5, desconto, 0.0);
    }
}
