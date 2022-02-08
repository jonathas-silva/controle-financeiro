package com.jonathas.gerenciadorfinanceiro.repositorios;

import com.jonathas.gerenciadorfinanceiro.domain.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosRepository extends JpaRepository<Gastos, Integer> {
    //o código será auto gerado pelo Spring
}
