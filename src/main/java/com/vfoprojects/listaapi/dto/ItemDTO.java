package com.vfoprojects.listaapi.dto;

import javax.validation.constraints.NotEmpty;

public class ItemDTO {

    @NotEmpty(message = "O campo nome é uma informação obrigatória")
    private String nome;

    @NotEmpty(message = "O campo quantidade é uma informação obrigatória")
    private String quantidade;

    public ItemDTO() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

}
