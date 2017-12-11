package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public class WaitingForApprovalState implements BudgetState {

    public static final double DISCOUNT_RATE = 0.05;

    @Override
    public void applyDiscount(Budget budget) {
        budget.setValor(budget.getValor() - budget.getValor() * DISCOUNT_RATE);
    }

    @Override
    public void approve(Budget budget) {
        budget.setCurrentState(new ApprovedState());
    }

    @Override
    public void reprove(Budget budget) {
        budget.setCurrentState(new ReprovedState());
    }

    @Override
    public void finish(Budget budget) {
        throw new RuntimeException("Waiting for approval budgeds cannot be finalized");
    }
}
