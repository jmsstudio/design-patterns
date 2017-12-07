package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class ProcessadorCSV implements ProcessadorFormatacao {

    private ProcessadorFormatacao next;

    public ProcessadorCSV(ProcessadorFormatacao next) {
        this.next = next;
    }

    @Override
    public String processa(Formato formato, Account account) {
        String retorno;

        if (Formato.CSV.equals(formato)) {
            retorno = account.getNomeTitular() + "," + account.getSaldo();
        } else {
            retorno = this.next.processa(formato, account);
        }

        return retorno;
    }

}
