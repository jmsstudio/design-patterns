package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Account;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ReportTest {

    @Test
    public void deveImprimirRelatorioSimples() {
        ReportTemplate report = new SimpleReport();

        Account account1 = new Account("Titular 1", "0120", "11520", 500);
        Account account2 = new Account("Titular 2", "4582", "44589-9", 1500);

        InfoRelatorio infoRelatorio = new InfoRelatorio("Itaú", Arrays.asList(account1, account2), "(11) 3252-5566", "Rua teste, nº 123 - São Paulo, SP", "johnarmless@ja.com");

        String reportData = report.printReport(infoRelatorio);

        Assert.assertEquals("Banco: Itaú | Telefone: (11) 3252-5566\n" +
                "\n" +
                "\n" +
                "Titular: Titular 1 | Saldo: 500.0\n" +
                "\n" +
                "Titular: Titular 2 | Saldo: 1500.0\n" +
                "\n" +
                "\n" +
                "Banco: Itaú | Telefone: (11) 3252-5566",

                reportData);
    }

    @Test
    public void deveImprimirRelatorioComplexo() {
        ReportTemplate report = new ComplexReport();

        Account account1 = new Account("Titular 1", "0120", "11520", 500);
        Account account2 = new Account("Titular 2", "4582", "44589-9", 1500);

        InfoRelatorio infoRelatorio = new InfoRelatorio("Itaú", Arrays.asList(account1, account2), "(11) 3252-5566", "Rua teste, nº 123 - São Paulo, SP", "johnarmless@ja.com");

        String reportData = report.printReport(infoRelatorio);

        Assert.assertEquals("Banco: Itaú | Endereço: Rua teste, nº 123 - São Paulo, SP  | Telefone: (11) 3252-5566\n" +
                "\n" +
                "\n" +
                "Titular: Titular 1 | Agência: 0120 | Account: 11520 | Saldo: 500.0\n" +
                "\n" +
                "Titular: Titular 2 | Agência: 4582 | Account: 44589-9 | Saldo: 1500.0\n" +
                "\n" +
                "\n" +
                "Email: johnarmless@ja.com | Data: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()),

                reportData);
    }
}
