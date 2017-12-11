package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public class WaitingForApprovalState implements BudgetState {

    public static final double DISCOUNT_RATE = 0.05;
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
