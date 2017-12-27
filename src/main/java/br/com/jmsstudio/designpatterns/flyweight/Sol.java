package br.com.jmsstudio.designpatterns.flyweight;

public class Sol implements MusicalNote {

    private String symbol = "G";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
