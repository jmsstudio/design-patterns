package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;

public interface BudgetState {

    void applyDiscount(Budget budget);

    void approve(Budget budget);

    void reprove(Budget budget);

    void finish(Budget budget);
}
