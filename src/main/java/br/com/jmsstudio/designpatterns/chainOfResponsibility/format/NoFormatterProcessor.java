package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public class NoFormatterProcessor implements FormatterProcessor {
    @Override
    public String processa(Format format, Account account) {
        return account.toString();
    }

}
