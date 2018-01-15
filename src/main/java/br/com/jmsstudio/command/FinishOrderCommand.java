package br.com.jmsstudio.command;

public class FinishOrderCommand implements OrderCommand {

    private Order order;

    public FinishOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.deliver();
    }
}
