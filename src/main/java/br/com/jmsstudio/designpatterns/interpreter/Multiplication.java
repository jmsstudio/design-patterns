package br.com.jmsstudio.designpatterns.interpreter;

import br.com.jmsstudio.designpatterns.visitor.FormatterVisitor;

public class Multiplication implements Expression {

    private Expression expression1;
    private Expression expression2;

    public Multiplication(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    public Expression getExpression1() {
        return expression1;
    }

    public Expression getExpression2() {
        return expression2;
    }

    @Override
    public Number evaluate() {
        return (Double) this.expression1.evaluate() * (Double) this.expression2.evaluate();
    }

    @Override
    public void accept(FormatterVisitor visitor) {
        visitor.visitMultiplication(this);
    }
}
