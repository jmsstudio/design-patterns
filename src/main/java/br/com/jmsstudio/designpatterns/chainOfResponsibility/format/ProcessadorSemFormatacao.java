package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Conta;

public class ProcessadorSemFormatacao implements ProcessadorFormatacao {
    @Override
    public String processa(Formato formato, Conta conta) {
        return conta.toString();
    }

}
