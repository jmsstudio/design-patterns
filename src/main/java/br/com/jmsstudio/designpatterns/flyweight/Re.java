package br.com.jmsstudio.designpatterns.flyweight;

public class Re implements MusicalNote {

    private String symbol = "D";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
