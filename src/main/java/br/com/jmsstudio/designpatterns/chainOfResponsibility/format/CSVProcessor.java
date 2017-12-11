package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class CSVProcessor implements FormatterProcessor {

    private FormatterProcessor next;

    public CSVProcessor(FormatterProcessor next) {
        this.next = next;
    }

    @Override
    public String processa(Format format, Account account) {
        String retorno;

        if (Format.CSV.equals(format)) {
            retorno = account.getTitularName() + "," + account.getSaldo();
        } else {
            retorno = this.next.processa(format, account);
        }

        return retorno;
    }

}
