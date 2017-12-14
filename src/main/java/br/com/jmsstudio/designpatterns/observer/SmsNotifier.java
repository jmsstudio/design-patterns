package br.com.jmsstudio.designpatterns.observer;

import br.com.jmsstudio.designpatterns.builder.TaxInvoice;

public class SmsNotifier implements TaxInvoiceObserver {
    @Override
    public void execute(TaxInvoice taxInvoice) {
        System.out.println("Sending SMS");
    }
}
