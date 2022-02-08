package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jonathas.gerenciadorfinanceiro.repositorios.GastoRepository;

@RestController
@RequestMapping(path="/gastos")
public class GastoController {
    @Autowired
    private GastoRepository gastoRepository;

    //método GET
}
