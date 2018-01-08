package br.com.jmsstudio.designpatterns.interpreter;

import br.com.jmsstudio.designpatterns.visitor.FormatterVisitor;

public class SquareRoot implements Expression {

    private Expression baseExpression;

    public SquareRoot(Expression baseExpression) {
        this.baseExpression = baseExpression;
    }

    public Expression getBaseExpression() {
        return baseExpression;
    }

    @Override
    public Number evaluate() {
        return Math.sqrt((Double) this.baseExpression.evaluate());
    }

    @Override
    public void accept(FormatterVisitor visitor) {
        visitor.visitSquareRoot(this);
    }
}
