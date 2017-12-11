package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public class ApprovedState implements BudgetState {
    public static final double DISCOUNT_RATE = 0.02;
    private boolean isDiscountApplied = false;

    @Override
    public void applyDiscount(Budget budget) {
        if (!isDiscountApplied) {
            budget.setValue(budget.getValue() - budget.getValue() * DISCOUNT_RATE);
            this.isDiscountApplied = true;
        } else {
            throw new RuntimeException("The discount has already been applied");
        }

    }

    @Override
    public void approve(Budget budget) {
        budget.setCurrentState(new FinishedState());
    }

    @Override
    public void reprove(Budget budget) {
        throw new RuntimeException("Approved budgeds cannot be reproved");
    }

    @Override
    public void finish(Budget budget) {
        budget.setCurrentState(new FinishedState());
    }

}
