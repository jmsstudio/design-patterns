package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Conta;

public class ProcessadorCSV implements ProcessadorFormatacao {

    private ProcessadorFormatacao next;

    @Override
    public String processa(Formato formato, Conta conta) {
        String retorno;

        if (Formato.CSV.equals(formato)) {
            retorno = conta.getNomeTitular() + "," + conta.getSaldo();
        } else {
            retorno = this.next.processa(formato, conta);
        }

        return retorno;
    }

    @Override
    public void setNext(ProcessadorFormatacao next) {
        this.next = next;
    }
}
