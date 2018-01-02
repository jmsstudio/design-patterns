package br.com.jmsstudio.designpatterns.interpreter;

public interface Expression<T extends Number> {

    T evaluate();
}
