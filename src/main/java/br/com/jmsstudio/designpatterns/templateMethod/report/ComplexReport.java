package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Conta;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplexReport extends ReportTemplate {
    @Override
    protected String createHeader(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Banco: ")
                .append(infoRelatorio.getBanco())
                .append(" | Endereço: ")
                .append(infoRelatorio.getEndereco())
                .append(" ")
                .append(" | Telefone: ")
                .append(infoRelatorio.getTelefone());

        return builder.toString();

    }

    @Override
    protected String createBody(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder("\n\n");

        for (Conta conta : infoRelatorio.getContas()) {
            builder
                    .append("Titular: ")
                    .append(conta.getNomeTitular())
                    .append(" | Agência: ")
                    .append(conta.getAgencia())
                    .append(" | Conta: ")
                    .append(conta.getConta())
                    .append(" | Saldo: ")
                    .append(conta.getSaldo())
                    .append("\n\n");
        }

        return builder.toString();
    }

    @Override
    protected String createFooter(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Email: ")
                .append(infoRelatorio.getEmail())
                .append(" | Data: ")
                .append(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        return builder.toString();

    }

}
