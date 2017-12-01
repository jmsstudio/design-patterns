package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Conta;

public interface ProcessadorFormatacao {

    String processa(Formato formato, Conta conta);
}
