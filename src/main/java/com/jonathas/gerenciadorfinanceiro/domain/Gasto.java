package com.jonathas.gerenciadorfinanceiro.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
public class Gasto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   // @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR")
    private LocalDate data;
    private Double valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id") //nome da chave estrangeira
    private Categoria categoria;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
