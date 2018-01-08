package br.com.jmsstudio.designpatterns.interpreter;

import br.com.jmsstudio.designpatterns.visitor.FormatterVisitor;

public class NumericValue implements Expression {

    private double number;

    public NumericValue(Number number) {
        if (number instanceof Double) {
            this.number = (Double) number;
        } else {
            this.number = (double) number.intValue();
        }
    }

    @Override
    public Number evaluate() {
        return number;
    }

    @Override
    public void accept(FormatterVisitor visitor) {
        visitor.visitNumericValue(this);
    }
}
