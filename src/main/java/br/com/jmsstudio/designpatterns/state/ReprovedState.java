package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public class ReprovedState implements BudgetState {
    @Override
    public void applyDiscount(Budget budget) {
        //
    }

    @Override
    public void approve(Budget budget) {
        throw new RuntimeException("Reproved budgeds cannot be approved");
    }

    @Override
    public void reprove(Budget budget) {
        throw new RuntimeException("The budged is already reproved");
    }

    @Override
    public void finish(Budget budget) {
        budget.setCurrentState(new FinishedState());
    }
}
