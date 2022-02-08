package com.jonathas.gerenciadorfinanceiro.repositorios;

import com.jonathas.gerenciadorfinanceiro.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    //o código será auto gerado pelo Spring
}
