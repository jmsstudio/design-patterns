package br.com.jmsstudio.designpatterns.decorator.filter;

import br.com.jmsstudio.model.Account;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAccountsCurrentMonth extends AbstractFilterDecorator {
    public FilterAccountsCurrentMonth(AbstractFilterDecorator combinedFilter) {
        super(combinedFilter);
    }

    public FilterAccountsCurrentMonth() {
        super();
    }

    @Override
    protected List<Account> doFilter(List<Account> accounts) {
        List<Account> accountsResult = Collections.emptyList();

        if (accounts != null) {
            accountsResult = accounts.stream().filter(a -> LocalDate.now().getMonth().equals(a.getStartDate().getMonth())).collect(Collectors.toList());
        }

        return accountsResult;
    }
}
