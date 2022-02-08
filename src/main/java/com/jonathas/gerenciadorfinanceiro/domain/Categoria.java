package com.jonathas.gerenciadorfinanceiro.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*Classe para representar as formas de pagamento disponíveis e utilizadas*/
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private double valor; //valor restante

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}





