package com.jonathas.gerenciadorfinanceiro.repositorios;

import com.jonathas.gerenciadorfinanceiro.domain.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
    //o código será auto gerado pelo Spring
}
