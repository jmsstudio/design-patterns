package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public interface FormatterProcessor {

    String processa(Format format, Account account);
}
