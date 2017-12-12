package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Account;

public class SimpleReport extends ReportTemplate {
    @Override
    protected String createHeader(ReportInfo reportInfo) {
        return getCommonData(reportInfo);
    }

    @Override
    protected String createBody(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder("\n\n");

        for (Account account : reportInfo.getAccounts()) {
            builder
                    .append("Titular: ")
                    .append(account.getTitularName())
                    .append(" | Saldo: ")
                    .append(account.getBalance())
                    .append("\n\n");
        }

        return builder.toString();
    }

    @Override
    protected String createFooter(ReportInfo reportInfo) {
        return getCommonData(reportInfo);
    }

    private String getCommonData(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Banco: ")
                .append(reportInfo.getBanco())
                .append(" | Telefone: ")
                .append(reportInfo.getTelefone());

        return builder.toString();
    }
}
