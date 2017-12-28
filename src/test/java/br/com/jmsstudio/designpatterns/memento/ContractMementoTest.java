package br.com.jmsstudio.designpatterns.memento;

import br.com.jmsstudio.model.Contract;
import br.com.jmsstudio.model.ContractStage;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class ContractMementoTest {

    @Test
    public void shouldCreateHistoryForAllChangesOfContract() {
        Contract contract = new Contract(LocalDate.of(2017, Month.DECEMBER, 1), "John Armless");

        contract.goToNextStage();

        assertEquals(ContractStage.IN_PROGRESS, contract.getStage());
        assertEquals(1, contract.getHistory().size());
        assertEquals(ContractStage.NEW, contract.getHistoryByIndex(0).getContract().getStage());

        contract.goToNextStage();

        assertEquals(ContractStage.DEAL, contract.getStage());
        assertEquals(2, contract.getHistory().size());
        assertEquals(ContractStage.NEW, contract.getHistoryByIndex(0).getContract().getStage());
        assertEquals(ContractStage.IN_PROGRESS, contract.getHistoryByIndex(1).getContract().getStage());

        contract.goToNextStage();

        assertEquals(ContractStage.FINISHED, contract.getStage());
        assertEquals(3, contract.getHistory().size());
        assertEquals(ContractStage.NEW, contract.getHistoryByIndex(0).getContract().getStage());
        assertEquals(ContractStage.IN_PROGRESS, contract.getHistoryByIndex(1).getContract().getStage());
        assertEquals(ContractStage.DEAL, contract.getHistoryByIndex(2).getContract().getStage());

        contract.goToNextStage();

        assertEquals(ContractStage.FINISHED, contract.getStage());
        assertEquals(4, contract.getHistory().size());
        assertEquals(ContractStage.NEW, contract.getHistoryByIndex(0).getContract().getStage());
        assertEquals(ContractStage.IN_PROGRESS, contract.getHistoryByIndex(1).getContract().getStage());
        assertEquals(ContractStage.DEAL, contract.getHistoryByIndex(2).getContract().getStage());
        assertEquals(ContractStage.FINISHED, contract.getHistoryByIndex(3).getContract().getStage());
    }
}
