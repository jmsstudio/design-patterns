package br.com.jmsstudio.model;

import br.com.jmsstudio.designpatterns.state.account.AccountState;
import br.com.jmsstudio.designpatterns.state.account.NegativeState;
import br.com.jmsstudio.designpatterns.state.account.PositiveState;

import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private String titularName;
    private String agency;
    private String accountNumber;
    private double balance;
    private LocalDate startDate = LocalDate.now();
    private AccountState currentState;

    public Account(double balance) {
        this.titularName = "";
        this.balance = balance;
        this.initState();
    }

    public Account(String titularName, double balance) {
        this.titularName = titularName;
        this.balance = balance;
        this.initState();
    }

    public Account(String titularName, String agency, String accountNumber, double balance) {
        this.titularName = titularName;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.initState();
    }

    private void initState() {
        if (this.balance >= 0) {
            this.currentState = new PositiveState();
        } else {
            this.currentState = new NegativeState();
        }
    }

    public String getTitularName() {
        return titularName;
    }

    public void setTitularName(String titularName) {
        this.titularName = titularName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AccountState currentState) {
        this.currentState = currentState;
    }

    public void deposit(double value) {
        this.currentState.processDeposit(this, value);
    }

    public void withdraw(double value) {
        this.currentState.processWithdraw(this, value);
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(balance, account.balance) &&
                Objects.equals(titularName, account.titularName) &&
                Objects.equals(agency, account.agency) &&
                Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titularName, agency, accountNumber, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "titularName='" + titularName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
