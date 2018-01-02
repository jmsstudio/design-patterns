package br.com.jmsstudio.designpatterns.interpreter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {

    @Test
    public void shouldEvaluateNumberExpression() {
        Expression expression = new NumericValue(10);

        assertEquals(10D, expression.evaluate());
    }

    @Test
    public void shouldEvaluateSumExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        assertEquals(15D, new Sum(expression1, expression2).evaluate());
    }

    @Test
    public void shouldEvaluateSubtractionExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        assertEquals(5D, new Subtraction(expression1, expression2).evaluate());
    }

    @Test
    public void shouldEvaluateDivisionExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(2);

        assertEquals(5D, new Division(expression1, expression2).evaluate());
    }

    @Test
    public void shouldEvaluateMultiplicationExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(4);

        assertEquals(40D, new Multiplication(expression1, expression2).evaluate());
    }

    @Test
    public void shouldEvaluateSquareRootExpression() {
        Expression expression = new NumericValue(100);

        assertEquals(10D, new SquareRoot(expression).evaluate());
    }
}
