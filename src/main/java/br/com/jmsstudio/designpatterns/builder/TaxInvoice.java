package br.com.jmsstudio.designpatterns.builder;

import br.com.jmsstudio.designpatterns.observer.TaxInvoiceObserver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaxInvoice {

    private String companyName;
    private String cnpj;
    private double bruteValue;
    private double taxValue;
    private LocalDate emissionDate;
    private String observations;
    private List<TaxInvoiceItem> items = new ArrayList<>();
    private Set<TaxInvoiceObserver> observers = new HashSet<>();

    public TaxInvoice(String companyName, String cnpj, double bruteValue, double taxValue, LocalDate emissionDate,
                      String observations, List<TaxInvoiceItem> items, Set<TaxInvoiceObserver> observers) {
        this.companyName = companyName;
        this.cnpj = cnpj;
        this.bruteValue = bruteValue;
        this.taxValue = taxValue;
        this.emissionDate = emissionDate;
        this.observations = observations;
        this.items = items;
        this.observers = observers;

        for (TaxInvoiceObserver observer : observers) {
            observer.execute(this);
        }

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getBruteValue() {
        return bruteValue;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public String getObservations() {
        return observations;
    }

    public List<TaxInvoiceItem> getItems() {
        return items;
    }

    public Set<TaxInvoiceObserver> getObservers() {
        return observers;
    }

    public void addObserver(TaxInvoiceObserver observer) {
        this.observers.add(observer);
    }
}
