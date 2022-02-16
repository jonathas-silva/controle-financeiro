package com.jonathas.gerenciadorfinanceiro.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GastoDTO implements Serializable {

  //  @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR")
    private LocalDate data;
    private Double valor;
    private String descricao;
    private Integer categoria; //inteiro representando categoria

    public GastoDTO(){

    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

