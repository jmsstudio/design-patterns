package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class XMLProcessor implements FormatterProcessor {

    private FormatterProcessor next;

    public XMLProcessor(FormatterProcessor next) {
        this.next = next;
    }

    @Override
    public String processa(Format format, Account account) {
        String retorno;

        if (Format.XML.equals(format)) {
            retorno = "<account><titular>" + account.getTitularName() +
                    "</titular><saldo>" + account.getSaldo() +
                    "</saldo></account>";
        } else {
            retorno = this.next.processa(format, account);
        }

        return retorno;
    }

}
