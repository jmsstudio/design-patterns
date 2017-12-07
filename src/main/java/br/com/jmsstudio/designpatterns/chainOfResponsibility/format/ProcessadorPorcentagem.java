package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class ProcessadorPorcentagem implements ProcessadorFormatacao {

    private ProcessadorFormatacao next;

    public ProcessadorPorcentagem(ProcessadorFormatacao next) {
        this.next = next;
    }

    @Override
    public String processa(Formato formato, Account account) {
        String retorno;

        if (Formato.PORCENTAGEM.equals(formato)) {
            retorno = account.getNomeTitular() + "%" + account.getSaldo();
        } else {
            retorno = this.next.processa(formato, account);
        }

        return retorno;
    }

}
