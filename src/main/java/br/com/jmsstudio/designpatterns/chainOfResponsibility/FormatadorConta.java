package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.format.*;
import br.com.jmsstudio.model.Conta;

public class FormatadorConta {

    private Formato formato;

    public FormatadorConta(Formato formato) {
        this.formato = formato;
    }

    public Formato getFormato() {
        return formato;
    }

    public String format(Conta conta) {
        ProcessadorFormatacao p1 = new ProcessadorXML();
        ProcessadorFormatacao p2 = new ProcessadorCSV();
        ProcessadorFormatacao p3 = new ProcessadorPorcentagem();
        ProcessadorFormatacao p4 = new ProcessadorSemFormatacao();

        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);

        return p1.processa(this.formato, conta);
    }
}
