package br.com.jmsstudio.designpatterns.templateMethod.report;

public abstract class ReportTemplate {

    public String printReport(ReportInfo reportInfo) {
        StringBuilder builder = new StringBuilder();

        builder.append(createHeader(reportInfo));
        builder.append("\n");
        builder.append(createBody(reportInfo));
        builder.append("\n");
        builder.append(createFooter(reportInfo));

        return builder.toString();
    }

    protected abstract String createHeader(ReportInfo reportInfo);

    protected abstract String createBody(ReportInfo reportInfo);

    protected abstract String createFooter(ReportInfo reportInfo);

}
