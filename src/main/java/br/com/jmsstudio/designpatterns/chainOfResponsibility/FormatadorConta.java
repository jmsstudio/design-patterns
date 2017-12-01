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
        ProcessadorFormatacao p4 = new ProcessadorSemFormatacao();
        ProcessadorFormatacao p3 = new ProcessadorPorcentagem(p4);
        ProcessadorFormatacao p2 = new ProcessadorCSV(p3);
        ProcessadorFormatacao p1 = new ProcessadorXML(p2);

        return p1.processa(this.formato, conta);
    }
}
