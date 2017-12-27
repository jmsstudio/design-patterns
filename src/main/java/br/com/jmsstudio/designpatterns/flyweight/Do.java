package br.com.jmsstudio.designpatterns.flyweight;

public class Do implements MusicalNote {

    private String symbol = "C";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
