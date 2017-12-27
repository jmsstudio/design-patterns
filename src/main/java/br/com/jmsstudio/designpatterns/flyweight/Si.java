package br.com.jmsstudio.designpatterns.flyweight;

public class Si implements MusicalNote {

    private String symbol = "B";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
