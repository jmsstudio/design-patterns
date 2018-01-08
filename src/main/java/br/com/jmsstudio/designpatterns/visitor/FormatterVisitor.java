package br.com.jmsstudio.designpatterns.visitor;

import br.com.jmsstudio.designpatterns.interpreter.*;

public interface FormatterVisitor {

    void visitNumericValue(NumericValue value);

    void visitSum(Sum sum);

    void visitSubtraction(Subtraction subtraction);

    void visitMultiplication(Multiplication multiplication);

    void visitDivision(Division division);

    void visitSquareRoot(SquareRoot squareRoot);

}
