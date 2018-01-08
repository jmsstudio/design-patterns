package br.com.jmsstudio.designpatterns.visitor;

import br.com.jmsstudio.designpatterns.interpreter.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FormatterVisitorTest {

    @Test
    public void shouldFormatNumberExpression() {
        Expression expression = new NumericValue(10);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        expression.accept(new PrinterVisitor(printStream));

        assertEquals(expression.evaluate().toString(), baos.toString());
    }

    @Test
    public void shouldFormatSumExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Sum sum = new Sum(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        sum.accept(new PrinterVisitor(printStream));

        assertEquals("( 10.0 + 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatSubtractionExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Subtraction subtraction = new Subtraction(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        subtraction.accept(new PrinterVisitor(printStream));

        assertEquals("( 10.0 - 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatMultiplicationExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Multiplication multiplication = new Multiplication(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        multiplication.accept(new PrinterVisitor(printStream));

        assertEquals("( 10.0 x 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatDivisionExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Division division = new Division(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        division.accept(new PrinterVisitor(printStream));

        assertEquals("( 10.0 / 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatSquareRootExpression() {
        Expression expression = new NumericValue(25);

        SquareRoot squareRoot = new SquareRoot(expression);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        squareRoot.accept(new PrinterVisitor(printStream));

        assertEquals("( SQRT ( 25.0 ) )", baos.toString());
    }

    @Test
    public void shouldFormatComposedExpression() {
        Expression sqrtExp = new NumericValue(25);
        SquareRoot squareRoot = new SquareRoot(sqrtExp);

        Expression sumExpression = new NumericValue(5);
        Sum sum = new Sum(squareRoot, sumExpression);

        Expression divisionExp = new NumericValue(2);
        Division division = new Division(sum, divisionExp);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        division.accept(new PrinterVisitor(printStream));

        assertEquals("( ( ( SQRT ( 25.0 ) ) + 5.0 ) / 2.0 )", baos.toString());
    }


    @Test
    public void shouldFormatNumberPrefixedExpression() {
        Expression expression = new NumericValue(10);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        expression.accept(new PrefixFormatterVisitor(printStream));

        assertEquals(expression.evaluate().toString(), baos.toString());
    }

    @Test
    public void shouldFormatSumPrefixExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Sum sum = new Sum(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        sum.accept(new PrefixFormatterVisitor(printStream));

        assertEquals(" + ( 10.0, 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatSubtractionPrefixedExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Subtraction subtraction = new Subtraction(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        subtraction.accept(new PrefixFormatterVisitor(printStream));

        assertEquals(" - ( 10.0, 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatMultiplicationPrefixedExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Multiplication multiplication = new Multiplication(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        multiplication.accept(new PrefixFormatterVisitor(printStream));

        assertEquals(" x ( 10.0, 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatDivisionPrefixedExpression() {
        Expression expression1 = new NumericValue(10);
        Expression expression2 = new NumericValue(5);

        Division division = new Division(expression1, expression2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        division.accept(new PrefixFormatterVisitor(printStream));

        assertEquals(" / ( 10.0, 5.0 )", baos.toString());
    }

    @Test
    public void shouldFormatSquareRootPrefixedExpression() {
        Expression expression = new NumericValue(25);

        SquareRoot squareRoot = new SquareRoot(expression);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        squareRoot.accept(new PrefixFormatterVisitor(printStream));

        assertEquals("SQRT ( 25.0 )", baos.toString());
    }
}
