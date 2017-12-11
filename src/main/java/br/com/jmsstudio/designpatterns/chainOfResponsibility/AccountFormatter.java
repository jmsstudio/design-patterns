package br.com.jmsstudio.designpatterns.chainOfResponsibility;

import br.com.jmsstudio.designpatterns.chainOfResponsibility.format.*;
import br.com.jmsstudio.model.Account;

public class AccountFormatter {

    private Format format;

    public AccountFormatter(Format format) {
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    public String format(Account account) {
        FormatterProcessor p4 = new NoFormatterProcessor();
        FormatterProcessor p3 = new PercentProcessor(p4);
        FormatterProcessor p2 = new CSVProcessor(p3);
        FormatterProcessor p1 = new XMLProcessor(p2);

        return p1.processa(this.format, account);
    }
}
