package br.com.jmsstudio.model;

public class Conta {

    private String nomeTitular;

    private double saldo;

    public Conta(double saldo) {
        this.nomeTitular = "";
        this.saldo = saldo;
    }

    public Conta(String nomeTitular, double saldo) {
        this.nomeTitular = nomeTitular;
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

    @Override
    public String toString() {
        return "Conta{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
