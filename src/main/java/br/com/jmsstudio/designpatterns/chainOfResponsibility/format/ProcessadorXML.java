package br.com.jmsstudio.designpatterns.chainOfResponsibility.format;

import br.com.jmsstudio.model.Conta;

public class ProcessadorXML implements ProcessadorFormatacao {

    private ProcessadorFormatacao next;

    @Override
    public String processa(Formato formato, Conta conta) {
        String retorno;

        if (Formato.XML.equals(formato)) {
            retorno = "<conta><titular>" + conta.getNomeTitular() +
                    "</titular><saldo>" + conta.getSaldo() +
                    "</saldo></conta>";
        } else {
            retorno = this.next.processa(formato, conta);
        }

        return retorno;
    }

    @Override
    public void setNext(ProcessadorFormatacao next) {
        this.next = next;
    }
}
