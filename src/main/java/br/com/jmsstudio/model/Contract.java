package br.com.jmsstudio.model;

import br.com.jmsstudio.designpatterns.memento.ContractMemento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private LocalDate date;
    private String customer;
    private ContractStage stage;
    private List<ContractMemento> history = new ArrayList<>();

    public Contract(LocalDate date, String customer) {
        this.date = date;
        this.customer = customer;
        this.stage = ContractStage.NEW;
    }

    public Contract(LocalDate date, String customer, ContractStage stage) {
        this.date = date;
        this.customer = customer;
        this.stage = stage;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCustomer() {
        return customer;
    }

    public ContractStage getStage() {
        return stage;
    }

    public List<ContractMemento> getHistory() {
        return history;
    }

    public void goToNextStage() {
        this.addContractToHistory(createState());
        switch (this.stage) {
            case NEW:
                this.stage = ContractStage.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                this.stage = ContractStage.DEAL;
                break;
            case DEAL:
                this.stage = ContractStage.FINISHED;
                break;
            case FINISHED:
                break;
            default:
                this.stage = ContractStage.NEW;
                break;
        }
    }

    private ContractMemento createState() {
        return new ContractMemento(this);
    }

    public ContractMemento getHistoryByIndex(int index) {
        return history.get(index);
    }

    private void addContractToHistory(ContractMemento contractMemento) {
        this.history.add(contractMemento);
    }

}
