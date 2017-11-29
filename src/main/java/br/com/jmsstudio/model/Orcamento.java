package br.com.jmsstudio.model;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {

    private double valor;
    private List<Item> items;

    public Orcamento(double valor) {
        this.valor = valor;
        this.items = new ArrayList<>();
    }

    public double getValor() {
        return valor;
    }

    public List<Item> getItems() {
        return items;
    }

    public void adicionaItem(String descricao, double valor) {
        this.items.add(new Item(descricao, valor));
    }
}
