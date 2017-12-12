package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Account;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComplexReport extends ReportTemplate {
    @Override
    protected String createHeader(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Banco: ")
                .append(reportInfo.getBanco())
                .append(" | Endereço: ")
                .append(reportInfo.getEndereco())
                .append(" ")
                .append(" | Telefone: ")
                .append(reportInfo.getTelefone());

        return builder.toString();

    }

    @Override
    protected String createBody(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder("\n\n");

        for (Account account : reportInfo.getAccounts()) {
            builder
                    .append("Titular: ")
                    .append(account.getTitularName())
                    .append(" | Agência: ")
                    .append(account.getAgency())
                    .append(" | Account: ")
                    .append(account.getAccountNumber())
                    .append(" | Saldo: ")
                    .append(account.getBalance())
                    .append("\n\n");
        }

        return builder.toString();
    }

    @Override
    protected String createFooter(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Email: ")
                .append(reportInfo.getEmail())
                .append(" | Data: ")
                .append(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        return builder.toString();

    }

}
