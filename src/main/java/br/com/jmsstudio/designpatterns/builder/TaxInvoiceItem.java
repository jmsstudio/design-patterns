package br.com.jmsstudio.designpatterns.builder;

public class TaxInvoiceItem {

    private String description;
    private double value;

    public TaxInvoiceItem() {
    }

    public TaxInvoiceItem(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public TaxInvoiceItemBuilder createBuilder() {
        return new TaxInvoiceItemBuilder();
    }

    class TaxInvoiceItemBuilder {

        private String description;
        private double value;

        public TaxInvoiceItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public TaxInvoiceItemBuilder withValue(double value) {
            this.value = value;
            return this;
        }

        public TaxInvoiceItem build() {
            return new TaxInvoiceItem(this.description, this.value);
        }

    }
}
