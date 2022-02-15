package com.jonathas.gerenciadorfinanceiro.dto;

import com.jonathas.gerenciadorfinanceiro.domain.Gasto;

import java.io.Serializable;
import java.sql.Date;

public class GastoDTO implements Serializable {
    private Date data;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

