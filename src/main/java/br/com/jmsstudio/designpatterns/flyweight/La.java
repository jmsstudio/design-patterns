package br.com.jmsstudio.designpatterns.flyweight;

public class La implements MusicalNote {

    private String symbol = "A";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
