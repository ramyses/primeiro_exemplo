package com.teste.primeiro_exemplo.Model;

public class Produto {
    //#region Atributos

    //como vou ter menos de 1000 produtos vou usar Integer, caso use mais o melhor e que id seja long
    private Integer id;

    private String nome;

    private Integer quantidade;

    private Double valor;
    
    private String observacao;
    //#endregion

    //#region getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //#endregion
    

}
