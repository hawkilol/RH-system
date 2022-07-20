package com.RHTec7;

public class Endereço {
    private String bairro;
    private String cidade;
    private String estado;

    public Endereço(String bairro, String cidade, String estado){
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
