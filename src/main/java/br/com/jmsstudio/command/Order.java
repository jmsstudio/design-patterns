package br.com.jmsstudio.command;

import java.time.LocalDate;

public class Order {
    private String customer;
    private Double value;
    private OrderStatus status;
    private LocalDate conclusionDate;

    public Order(String customer, Double value) {
        this.customer = customer;
        this.value = value;
    }

    public String getCustomer() {
        return customer;
    }

    public Double getValue() {
        return value;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDate getConclusionDate() {
        return conclusionDate;
    }

    public void pay() {
        this.status = OrderStatus.PAYED;
    }

    public void deliver() {
        if (this.status == OrderStatus.PAYED) {
            this.status = OrderStatus.DELIVERED;
            this.conclusionDate = LocalDate.now();
        } else {
            throw new IllegalStateException("Order is in invalid status, it cannot be delivered");
        }
    }
}
