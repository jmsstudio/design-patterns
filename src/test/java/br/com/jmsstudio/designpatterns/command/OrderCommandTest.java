package br.com.jmsstudio.designpatterns.command;

import br.com.jmsstudio.command.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderCommandTest {

    @Test
    public void shouldUpdateOrderStatusWhenSingleCommandIsExecuted() {
        Order order = new Order("Customer 1", 100D);

        OrderCommand command = new PayOrderCommand(order);

        OrderProcessor processor = new OrderProcessor();
        processor.add(command);

        processor.process();

        assertEquals(OrderStatus.PAYED, order.getStatus());
    }

    @Test
    public void shouldUpdateOrderStatusWhenMoreThanOneCommandIsExecuted() {
        Order order = new Order("Customer 1", 100D);

        OrderCommand command1 = new PayOrderCommand(order);
        OrderCommand command2 = new FinishOrderCommand(order);

        OrderProcessor processor = new OrderProcessor();
        processor.add(command1);
        processor.add(command2);

        processor.process();

        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowErrorWhenTryingToProcessCommandInInvalidState() {
        Order order = new Order("Customer 1", 100D);

        OrderCommand command = new FinishOrderCommand(order);

        OrderProcessor processor = new OrderProcessor();
        processor.add(command);

        processor.process();
    }
}
