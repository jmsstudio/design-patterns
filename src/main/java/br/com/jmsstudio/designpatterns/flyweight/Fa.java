package br.com.jmsstudio.designpatterns.flyweight;

public class Fa implements MusicalNote {

    private String symbol = "F";

    @Override
    public String getSymbol() {
        return symbol;
    }
}
