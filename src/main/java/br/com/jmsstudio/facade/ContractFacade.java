package br.com.jmsstudio.facade;

import br.com.jmsstudio.model.Contract;
import br.com.jmsstudio.model.ContractStage;

import java.time.LocalDate;

public class ContractFacade {

    private Contract contract;

    public ContractFacade(Contract contract) {
        this.contract = contract;
    }

    public LocalDate getDate() {
        return contract.getDate();
    }

    public void goToNextStage() {
        contract.goToNextStage();
    }

    public String getCustomer() {
        return contract.getCustomer();
    }

    public ContractStage getStage() {
        return contract.getStage();
    }
}
