package br.com.jmsstudio.designpatterns.templateMethod.imposto;

import br.com.jmsstudio.designpatterns.decorator.imposto.Imposto;
import br.com.jmsstudio.model.BudgetItem;
import br.com.jmsstudio.model.Budget;

import java.util.List;
import java.util.stream.Collectors;

public class ImpostoIHIT extends TemplateImpostoCondicional {
    public static final double TAXA_MAXIMA_IMPOSTO = 0.13;
    public static final double PARCELA_FIXA_IMPOSTO_MAXIMO = 100;
    public static final double TAXA_MINIMA_IMPOSTO = 0.01;

    public ImpostoIHIT(Imposto impostoCombinado) {
        super(impostoCombinado);
    }

    public ImpostoIHIT() {
        super();
    }

    @Override
    public boolean deveUsarTaxaMaxima(Budget budget) {

        List<String> nomesItens = budget.getBudgetItems().stream().map(BudgetItem::getNome).collect(Collectors.toList());

        boolean temMaisDeUmItemComMesmoNome = false;

        for (String nomeItem : nomesItens) {
            if (!temMaisDeUmItemComMesmoNome) {
                temMaisDeUmItemComMesmoNome = nomesItens.stream().filter(n -> n.equals(nomeItem)).count() > 1;
            }
        }

        return temMaisDeUmItemComMesmoNome;
    }

    @Override
    public double calcularTaxaMaxima(Budget budget) {
        return budget.getValor() * TAXA_MAXIMA_IMPOSTO + PARCELA_FIXA_IMPOSTO_MAXIMO;
    }

    @Override
    public double calcularTaxaMinima(Budget budget) {
        return budget.getValor() * TAXA_MINIMA_IMPOSTO * budget.getBudgetItems().stream().count();
    }
}
