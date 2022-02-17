package com.jonathas.gerenciadorfinanceiro.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*Classe para representar as formas de pagamento disponíveis e utilizadas*/
@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Double orcamento;

    @OneToMany(mappedBy = "categoria")
    private List<Gasto> gastos = new ArrayList<>();
    /*Uma categoria tem vários gastos, mas um gasto tem apenas uma categoria*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }
}





