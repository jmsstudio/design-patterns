package br.com.jmsstudio.model;

import br.com.jmsstudio.designpatterns.state.BudgetState;
import br.com.jmsstudio.designpatterns.state.WaitingForApprovalState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Budget {

    private double value;
    private List<BudgetItem> budgetItems;
    private BudgetState currentState;


    public Budget(double value) {
        this.value = value;
        this.budgetItems = new ArrayList<>();
        this.currentState = new WaitingForApprovalState();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (this.value < 0) {
            throw new RuntimeException("The budget value shouldn't be negative.");
        }

        this.value = value;
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

    public void addItem(String description, double valor) {
        this.budgetItems.add(new BudgetItem(description, valor));
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
