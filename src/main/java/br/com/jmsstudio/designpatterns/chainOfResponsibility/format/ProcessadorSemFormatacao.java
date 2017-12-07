package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class ProcessadorSemFormatacao implements ProcessadorFormatacao {
    @Override
    public String processa(Formato formato, Account account) {
        return account.toString();
    }

}
