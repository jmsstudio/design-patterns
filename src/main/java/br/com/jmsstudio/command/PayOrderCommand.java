package br.com.jmsstudio.command;

public class PayOrderCommand implements OrderCommand {

    private Order order;

    public PayOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        this.order.pay();
    }
}
