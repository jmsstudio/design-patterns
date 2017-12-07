package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Account;

public class SimpleReport extends ReportTemplate {
    @Override
    protected String createHeader(InfoRelatorio infoRelatorio) {
        return getCommonData(infoRelatorio);
    }

    @Override
    protected String createBody(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder("\n\n");

        for (Account account : infoRelatorio.getAccounts()) {
            builder
                    .append("Titular: ")
                    .append(account.getNomeTitular())
                    .append(" | Saldo: ")
                    .append(account.getSaldo())
                    .append("\n\n");
        }

        return builder.toString();
    }

    @Override
    protected String createFooter(InfoRelatorio infoRelatorio) {
        return getCommonData(infoRelatorio);
    }

    private String getCommonData(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Banco: ")
                .append(infoRelatorio.getBanco())
                .append(" | Telefone: ")
                .append(infoRelatorio.getTelefone());

        return builder.toString();
    }
}
