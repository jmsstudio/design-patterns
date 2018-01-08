package br.com.jmsstudio.designpatterns.visitor;

import br.com.jmsstudio.designpatterns.interpreter.*;

import java.io.PrintStream;

public class PrinterVisitor implements FormatterVisitor {

    private PrintStream printStream;

    public PrinterVisitor() {
        this.printStream = System.out;
    }

    public PrinterVisitor(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void visitNumericValue(NumericValue value) {
        this.printStream.print(value.evaluate().toString());
    }

    @Override
    public void visitSum(Sum sum) {
        this.printStream.print("( ");

        sum.getExpression1().accept(this);

        this.printStream.print(" + ");

        sum.getExpression2().accept(this);

        this.printStream.print(" )");
    }

    @Override
    public void visitSubtraction(Subtraction subtraction) {
        this.printStream.print("( ");

        subtraction.getExpression1().accept(this);

        this.printStream.print(" - ");

        subtraction.getExpression2().accept(this);

        this.printStream.print(" )");
    }

    @Override
    public void visitMultiplication(Multiplication multiplication) {
        this.printStream.print("( ");

        multiplication.getExpression1().accept(this);

        this.printStream.print(" x ");

        multiplication.getExpression2().accept(this);

        this.printStream.print(" )");
    }

    @Override
    public void visitDivision(Division division) {
        this.printStream.print("( ");

        division.getExpression1().accept(this);

        this.printStream.print(" / ");

        division.getExpression2().accept(this);

        this.printStream.print(" )");

    }

    @Override
    public void visitSquareRoot(SquareRoot squareRoot) {
        this.printStream.print("( ");

        this.printStream.print("SQRT ( ");

        squareRoot.getBaseExpression().accept(this);

        this.printStream.print(" )");

        this.printStream.print(" )");

    }

}
