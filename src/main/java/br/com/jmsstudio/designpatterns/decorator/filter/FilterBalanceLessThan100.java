package br.com.jmsstudio.designpatterns.decorator.filter;

import br.com.jmsstudio.model.Account;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilterBalanceLessThan100 extends AbstractFilterDecorator {

    public FilterBalanceLessThan100(AbstractFilterDecorator combinedFilter) {
        super(combinedFilter);
    }

    public FilterBalanceLessThan100() {
        super();
    }

    @Override
    protected List<Account> doFilter(List<Account> accounts) {
        List<Account> accountsResult = Collections.emptyList();

        if (accounts != null) {
            accountsResult = accounts.stream().filter(a -> a.getBalance() < 100).collect(Collectors.toList());
        }

        return accountsResult;
    }
}
