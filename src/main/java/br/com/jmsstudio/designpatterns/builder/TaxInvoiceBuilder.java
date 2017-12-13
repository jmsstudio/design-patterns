package br.com.jmsstudio.designpatterns.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaxInvoiceBuilder {

    private String companyName;
    private String cnpj;
    private double bruteValue;
    private double taxValue;
    private LocalDate emissionDate;
    private String observations;
    private List<TaxInvoiceItem> items = new ArrayList<>();

    public TaxInvoiceBuilder() {
        this.companyName = "";
        this.cnpj = "";
        this.emissionDate = null;
        this.observations = "";
    }

    public TaxInvoiceBuilder withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public TaxInvoiceBuilder withCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public TaxInvoiceBuilder emmitedToday() {
        this.emissionDate = LocalDate.now();
        return this;
    }

    public TaxInvoiceBuilder emmitedIn(LocalDate date) {
        this.emissionDate = date;
        return this;
    }

    public TaxInvoiceBuilder withObservations(String observations) {
        this.observations = observations;
        return this;
    }

    public TaxInvoiceBuilder withItem(TaxInvoiceItem taxInvoiceItem) {
        this.items.add(taxInvoiceItem);
        this.bruteValue += taxInvoiceItem.getValue();
        this.taxValue += taxInvoiceItem.getValue() * 0.05;

        return this;
    }

    public TaxInvoice build() {
        return new TaxInvoice(this.companyName, this.cnpj, this.bruteValue, this.taxValue, this.emissionDate, this.observations, this.items);
    }

}
