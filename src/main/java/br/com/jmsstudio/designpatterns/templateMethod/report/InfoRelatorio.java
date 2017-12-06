package br.com.jmsstudio.designpatterns.templateMethod.report;

import br.com.jmsstudio.model.Conta;

import java.util.List;

public class InfoRelatorio {

    private String banco;
    private List<Conta> contas;
    private String telefone;
    private String endereco;
    private String email;

    public InfoRelatorio(String banco, List<Conta> contas, String telefone, String endereco, String email) {
        this.banco = banco;
        this.contas = contas;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
