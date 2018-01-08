package br.com.jmsstudio.designpatterns.interpreter;

import br.com.jmsstudio.designpatterns.visitor.FormatterVisitor;

public interface Expression<T extends Number> {

    T evaluate();

    void accept(FormatterVisitor visitor);
}
