package br.com.jmsstudio.designpatterns.builder;

import br.com.jmsstudio.designpatterns.observer.TaxInvoiceObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaxInvoiceBuilder {

    private String companyName;
    private String cnpj;
    private double bruteValue;
    private double taxValue;
    private LocalDate emissionDate;
    private String observations;
    private List<TaxInvoiceItem> items = new ArrayList<>();
    private Set<TaxInvoiceObserver> observers = new HashSet<>();

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

    public TaxInvoiceBuilder withObserver(TaxInvoiceObserver observer) {
        this.observers.add(observer);
        return this;
    }

    public TaxInvoice build() {
        return new TaxInvoice(this.companyName, this.cnpj, this.bruteValue, this.taxValue, this.emissionDate,
                this.observations, this.items, this.observers);
    }

}
