package br.com.jmsstudio.model;

import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private String nomeTitular;
    private String agencia;
    private String conta;
    private double saldo;
    private LocalDate startDate = LocalDate.now();

    public Account(double saldo) {
        this.nomeTitular = "";
        this.saldo = saldo;
    }

    public Account(String nomeTitular, double saldo) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public Account(String nomeTitular, String agencia, String conta, double saldo) {
        this.nomeTitular = nomeTitular;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
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
                Objects.equals(nomeTitular, account.nomeTitular) &&
                Objects.equals(agencia, account.agencia) &&
                Objects.equals(conta, account.conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeTitular, agencia, conta, saldo);
    }

    @Override
    public String toString() {
        return "Account{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
