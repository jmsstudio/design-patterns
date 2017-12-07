package br.com.jmsstudio.designpatterns.decorator.filter;

import br.com.jmsstudio.model.Account;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFilterDecorator {

    private AbstractFilterDecorator combinedFilter;

    public AbstractFilterDecorator(AbstractFilterDecorator combinedFilter) {
        this.combinedFilter = combinedFilter;
    }

    public AbstractFilterDecorator() {
        this.combinedFilter = null;
    }

    public List<Account> filter(List<Account> accounts) {
        return processCombinedFilter(doFilter(accounts));
    }

    protected abstract List<Account> doFilter(List<Account> accounts);

    protected List<Account> processCombinedFilter(List<Account> accounts) {
        List<Account> accountsResult = new ArrayList<>();

        if (this.combinedFilter != null) {
            if (accounts != null && !accounts.isEmpty()) {
                accountsResult.addAll(this.combinedFilter.filter(accounts));
            }
        } else {
            accountsResult = accounts;
        }

        return accountsResult;
    }
}
