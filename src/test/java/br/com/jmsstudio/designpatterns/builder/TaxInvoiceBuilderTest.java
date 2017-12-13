package br.com.jmsstudio.designpatterns.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxInvoiceBuilderTest {

    @Test
    public void shouldCreateATaxInvoiceUsingFluentInterface() {
        String compayName = "Company 1";
        String cnpj = "12.123.123/0001-20";

        TaxInvoice taxInvoice = new TaxInvoiceBuilder()
                .withCompanyName(compayName)
                .withCNPJ(cnpj)
                .emmitedToday()
                .withItem(new TaxInvoiceItem("item 1", 100))
                .withItem(new TaxInvoiceItem("item 2", 300))
                .withItem(new TaxInvoiceItem("item 3", 50))
                .withObservations("")
                .build();

        double calculatedTaxes = 450 * 0.05;

        assertEquals(compayName, taxInvoice.getCompanyName());
        assertEquals(cnpj, taxInvoice.getCnpj());
        assertEquals("", taxInvoice.getObservations());
        assertEquals(450, taxInvoice.getBruteValue(), 0);
        assertEquals(calculatedTaxes, taxInvoice.getTaxValue(), 0);
    }

    @Test
    public void shouldCreateATaxInvoiceAndItemsUsingFluentInterface() {
        String compayName = "Company 1";
        String cnpj = "12.123.123/0001-20";

        TaxInvoiceItem item1 = new TaxInvoiceItem().createBuilder().withDescription("Item 1").withValue(100).build();
        TaxInvoiceItem item2 = new TaxInvoiceItem().createBuilder().withDescription("Item 2").withValue(50).build();

        TaxInvoice taxInvoice = new TaxInvoiceBuilder()
                .withCompanyName(compayName)
                .withCNPJ(cnpj)
                .emmitedToday()
                .withItem(item1)
                .withItem(item2)
                .withObservations("")
                .build();

        double calculatedTaxes = item1.getValue() * 0.05 + item2.getValue() * 0.05;

        assertEquals(compayName, taxInvoice.getCompanyName());
        assertEquals(cnpj, taxInvoice.getCnpj());
        assertEquals("", taxInvoice.getObservations());
        assertEquals(item1.getValue() + item2.getValue(), taxInvoice.getBruteValue(), 0);
        assertEquals(calculatedTaxes, taxInvoice.getTaxValue(), 0);
    }
}
