package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Categoria;
import com.jonathas.gerenciadorfinanceiro.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Iterable<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
}
