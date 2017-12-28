package br.com.jmsstudio.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class ContractHistory {

    private List<ContractMemento> history = new ArrayList<>();

    public ContractMemento getHistoryByIndex(int index) {
        return history.get(index);
    }

    public void addContract(ContractMemento contractMemento) {
        this.history.add(contractMemento);
    }
}
