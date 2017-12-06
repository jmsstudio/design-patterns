package br.com.jmsstudio.designpatterns.templateMethod.report;

public abstract class ReportTemplate {

    public String printReport(InfoRelatorio infoRelatorio) {
        StringBuilder builder = new StringBuilder();

        builder.append(createHeader(infoRelatorio));
        builder.append("\n");
        builder.append(createBody(infoRelatorio));
        builder.append("\n");
        builder.append(createFooter(infoRelatorio));

        return builder.toString();
    }

    protected abstract String createHeader(InfoRelatorio infoRelatorio);

    protected abstract String createBody(InfoRelatorio infoRelatorio);

    protected abstract String createFooter(InfoRelatorio infoRelatorio);

}
