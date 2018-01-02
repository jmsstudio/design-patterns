package br.com.jmsstudio.designpatterns.interpreter;

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
}
