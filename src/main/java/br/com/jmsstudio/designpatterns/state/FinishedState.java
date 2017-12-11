package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public class FinishedState implements BudgetState {
    @Override
    public void applyDiscount(Budget budget) {
        //do nothing
    }

    @Override
    public void approve(Budget budget) {
        throw new RuntimeException("Finished budged cannot be approved");
    }

    @Override
    public void reprove(Budget budget) {
        throw new RuntimeException("Finished budged cannot be reproved");
    }

    @Override
    public void finish(Budget budget) {
        throw new RuntimeException("The budget is already finalized");
    }
}
