package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class ProcessadorXML implements ProcessadorFormatacao {

    private ProcessadorFormatacao next;

    public ProcessadorXML(ProcessadorFormatacao next) {
        this.next = next;
    }

    @Override
    public String processa(Formato formato, Account account) {
        String retorno;

        if (Formato.XML.equals(formato)) {
            retorno = "<account><titular>" + account.getNomeTitular() +
                    "</titular><saldo>" + account.getSaldo() +
                    "</saldo></account>";
        } else {
            retorno = this.next.processa(formato, account);
        }

        return retorno;
    }

}
