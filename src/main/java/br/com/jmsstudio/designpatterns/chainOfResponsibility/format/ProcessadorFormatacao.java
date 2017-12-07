package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Account;

public interface ProcessadorFormatacao {

    String processa(Formato formato, Account account);
}
