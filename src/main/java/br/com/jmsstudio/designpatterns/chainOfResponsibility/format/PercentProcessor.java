package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class PercentProcessor implements FormatterProcessor {

    private FormatterProcessor next;

    public PercentProcessor(FormatterProcessor next) {
        this.next = next;
    }

    @Override
    public String processa(Format format, Account account) {
        String retorno;

        if (Format.PORCENTAGEM.equals(format)) {
            retorno = account.getTitularName() + "%" + account.getBalance();
        } else {
            retorno = this.next.processa(format, account);
        }

        return retorno;
    }

}
