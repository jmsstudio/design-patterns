package br.com.jmsstudio.designpatterns.decorator.filter;

import br.com.jmsstudio.model.Account;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AbstractFilterDecoratorTest {

    @Test
    public void deveFiltarContasComSaldoMenorQue100() {
        List<Account> accounts = Arrays.asList(new Account(80), new Account(100), new Account(500), new Account(10), new Account(0));

        AbstractFilterDecorator filter = new FilterBalanceLessThan100();

        Assert.assertEquals(Arrays.asList(new Account(80), new Account(10), new Account(0)), filter.filter(accounts));
    }

    @Test
    public void deveFiltarContasComSaldoMaiorQue500() {
        List<Account> accounts = Arrays.asList(new Account(880), new Account(100), new Account(500), new Account(1000), new Account(0));

        AbstractFilterDecorator filter = new FilterBalanceMoreThan500();

        Assert.assertEquals(Arrays.asList(new Account(880), new Account(1000)), filter.filter(accounts));
    }

    @Test
    public void deveFiltarContasDoMesAtual() {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        LocalDate nextMonth = today.plusMonths(1);

        Account account1 = new Account(880);
        Account account2 = new Account(500);
        Account account3 = new Account(100);
        Account account4 = new Account(0);

        account1.setStartDate(nextMonth);
        account2.setStartDate(today);
        account3.setStartDate(lastMonth);
        account4.setStartDate(today);

        List<Account> accounts = Arrays.asList(account1, account2, account3, account4);

        AbstractFilterDecorator filter = new FilterAccountsCurrentMonth();

        Assert.assertEquals(Arrays.asList(account2, account4), filter.filter(accounts));
    }

    @Test
    public void deveCombinarFiltros() {
        LocalDate today = LocalDate.now();
        LocalDate lastMonth = today.minusMonths(1);
        LocalDate nextMonth = today.plusMonths(1);

        Account account1 = new Account(880);
        Account account2 = new Account(500);
        Account account3 = new Account(100);
        Account account4 = new Account(0);

        account1.setStartDate(today);
        account2.setStartDate(nextMonth);
        account3.setStartDate(lastMonth);
        account4.setStartDate(today);

        List<Account> accounts = Arrays.asList(account1, account2, account3, account4);

        AbstractFilterDecorator filter = new FilterAccountsCurrentMonth(new FilterBalanceLessThan100());

        Assert.assertEquals(Arrays.asList(account4), filter.filter(accounts));

    }
}
