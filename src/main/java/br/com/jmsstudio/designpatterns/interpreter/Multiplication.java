package br.com.jmsstudio.designpatterns.interpreter;

public class Multiplication implements Expression {

    private Expression expression1;
    private Expression expression2;

    public Multiplication(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public Number evaluate() {
        return (Double) this.expression1.evaluate() * (Double) this.expression2.evaluate();
    }
}
