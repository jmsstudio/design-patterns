package br.com.jmsstudio.designpatterns.flyweight;

public class Mi implements MusicalNote {

    private String symbol = "E";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
