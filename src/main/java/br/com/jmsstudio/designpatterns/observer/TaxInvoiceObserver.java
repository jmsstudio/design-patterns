package br.com.jmsstudio.designpatterns.observer;

import br.com.jmsstudio.designpatterns.builder.TaxInvoice;

public interface TaxInvoiceObserver {

    void execute(TaxInvoice taxInvoice);
}
