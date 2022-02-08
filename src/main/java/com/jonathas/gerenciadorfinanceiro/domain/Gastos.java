package com.jonathas.gerenciadorfinanceiro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


public class Gastos {

    private Integer id;
    private Date data; //adicionado por último
    private Double valor;
    private String descricao;
    private Integer pgto;
}
