package br.com.jmsstudio.model;

public class Conta {

    private String nomeTitular;
    private String agencia;
    private String conta;
    private double saldo;

    public Conta(double saldo) {
        this.nomeTitular = "";
        this.saldo = saldo;
    }

    public Conta(String nomeTitular, double saldo) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public Conta(String nomeTitular, String agencia, String conta, double saldo) {
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

    @Override
    public String toString() {
        return "Conta{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
