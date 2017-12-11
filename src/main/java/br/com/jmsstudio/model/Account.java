package br.com.jmsstudio.model;

import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private String titularName;
    private String agency;
    private String accountNumber;
    private double saldo;
    private LocalDate startDate = LocalDate.now();

    public Account(double saldo) {
        this.titularName = "";
        this.saldo = saldo;
    }

    public Account(String titularName, double saldo) {
        this.titularName = titularName;
        this.saldo = saldo;
    }

    public Account(String titularName, String agency, String accountNumber, double saldo) {
        this.titularName = titularName;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.saldo = saldo;
    }

    public String getTitularName() {
        return titularName;
    }

    public void setTitularName(String titularName) {
        this.titularName = titularName;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
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
        return Objects.equals(saldo, account.saldo) &&
                Objects.equals(titularName, account.titularName) &&
                Objects.equals(agency, account.agency) &&
                Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titularName, agency, accountNumber, saldo);
    }

    @Override
    public String toString() {
        return "Account{" +
                "titularName='" + titularName + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
