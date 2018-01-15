package br.com.jmsstudio.command;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {

    private List<OrderCommand> commmands;

    public OrderProcessor() {
        this.commmands = new ArrayList<>();
    }

    public void add(OrderCommand command) {
        this.commmands.add(command);
    }

    public void process() {
        this.commmands.stream().forEach(OrderCommand::execute);
    }
}
