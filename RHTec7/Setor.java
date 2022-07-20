package com.RHTec7;

public enum Setor {
    REQUISITOS("Requisitos"),
    MODELAGEM("Modelagem"),
    CODIFICAÇÃO("Codificação"),
    TESTE("Teste"),
    RECURSOSHUMANOS("RecursosHumanos");


    private String descricao;

    Setor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
