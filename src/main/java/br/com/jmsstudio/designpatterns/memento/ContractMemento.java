package br.com.jmsstudio.designpatterns.memento;

import br.com.jmsstudio.model.Contract;

import java.time.LocalDate;

public class ContractMemento {

    private Contract contract;
    private LocalDate dateCreated;

    public ContractMemento(Contract contract) {
        this.contract = new Contract(contract.getDate(), contract.getCustomer(), contract.getStage());
        this.dateCreated = LocalDate.now();
    }

    public Contract getContract() {
        return contract;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}
