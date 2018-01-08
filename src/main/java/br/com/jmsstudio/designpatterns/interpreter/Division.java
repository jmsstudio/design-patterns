package br.com.jmsstudio.designpatterns.interpreter;

import br.com.jmsstudio.designpatterns.visitor.FormatterVisitor;

import java.util.Objects;

public class Division implements Expression {

    private Expression expression1;
    private Expression expression2;

    public Division(Expression expression1, Expression expression2) {
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
        Number returnValue = 0;
        if (!Objects.equals(this.expression2.evaluate().toString(), "0")) {
            returnValue = (Double) this.expression1.evaluate() / (Double) this.expression2.evaluate();
        }

        return returnValue;
    }

    @Override
    public void accept(FormatterVisitor visitor) {
        visitor.visitDivision(this);
    }
}
