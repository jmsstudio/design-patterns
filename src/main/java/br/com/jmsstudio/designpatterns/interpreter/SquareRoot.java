package br.com.jmsstudio.designpatterns.interpreter;

public class SquareRoot implements Expression {

    private Expression baseExpression;

    public SquareRoot(Expression baseExpression) {
        this.baseExpression = baseExpression;
    }

    @Override
    public Number evaluate() {
        return Math.sqrt((Double) this.baseExpression.evaluate());
    }
}
