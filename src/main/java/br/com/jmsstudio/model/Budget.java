package br.com.jmsstudio.model;

import br.com.jmsstudio.designpatterns.state.BudgetState;
import br.com.jmsstudio.designpatterns.state.WaitingForApprovalState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Budget {

    private double valor;
    private List<BudgetItem> budgetItems;
    private BudgetState currentState;


    public Budget(double valor) {
        this.valor = valor;
        this.budgetItems = new ArrayList<>();
        this.currentState = new WaitingForApprovalState();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (this.valor < 0) {
            throw new RuntimeException("The budget value shouldn't be negative.");
        }

        this.valor = valor;
    }

    public BudgetState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(BudgetState currentState) {
        this.currentState = currentState;
    }

    public List<BudgetItem> getBudgetItems() {
        return Collections.unmodifiableList(budgetItems);
    }

    public void adicionaItem(String descricao, double valor) {
        this.budgetItems.add(new BudgetItem(descricao, valor));
    }

    public void applyExtraDiscount() {
        currentState.applyDiscount(this);
    }

    public void approve() {
        currentState.approve(this);
    }

    public void reprove() {
        currentState.reprove(this);
    }

    public void finish() {
        currentState.finish(this);
    }
}
