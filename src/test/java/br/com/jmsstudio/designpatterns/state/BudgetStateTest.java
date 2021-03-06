package br.com.jmsstudio.designpatterns.state;

import br.com.jmsstudio.model.Budget;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BudgetStateTest {

    @Test
    public void shouldApplyDiscountForBudgetWaitingForApproval() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);

        budget.applyExtraDiscount();

        double expectedValue = saldoInicial - saldoInicial * WaitingForApprovalState.DISCOUNT_RATE;

        assertEquals(expectedValue, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(WaitingForApprovalState.class));
    }

    @Test
    public void shouldApplyDiscountForApprovedBudget() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);
        budget.approve();

        budget.applyExtraDiscount();

        double expectedValue = saldoInicial - saldoInicial * ApprovedState.DISCOUNT_RATE;

        assertEquals(expectedValue, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(ApprovedState.class));
    }

    @Test
    public void shouldApplyDiscountForReprovedBudget() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);
        budget.reprove();

        budget.applyExtraDiscount();

        assertEquals(saldoInicial, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(ReprovedState.class));
    }

    @Test
    public void shouldApplyDiscountForFinishedBudget() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);
        budget.approve();
        budget.finish();

        budget.applyExtraDiscount();

        assertEquals(saldoInicial, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(FinishedState.class));
    }

    @Test(expected = RuntimeException.class)
    public void shouldApplyDiscountForBudgetWaitingForApprovalOnlyOnce() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);

        budget.applyExtraDiscount();

        double expectedValue = saldoInicial - saldoInicial * WaitingForApprovalState.DISCOUNT_RATE;

        assertEquals(expectedValue, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(WaitingForApprovalState.class));

        budget.applyExtraDiscount();

    }

    @Test(expected = RuntimeException.class)
    public void shouldApplyDiscountForApprovedBudgetOnlyOnce() {
        final double saldoInicial = 500;

        Budget budget = new Budget(saldoInicial);
        budget.approve();

        budget.applyExtraDiscount();

        double expectedValue = saldoInicial - saldoInicial * ApprovedState.DISCOUNT_RATE;

        assertEquals(expectedValue, budget.getValue(), 0.0);
        assertThat(budget.getCurrentState(), CoreMatchers.instanceOf(ApprovedState.class));

        budget.applyExtraDiscount();
    }
}
