package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Categoria;
import com.jonathas.gerenciadorfinanceiro.domain.Gasto;
import com.jonathas.gerenciadorfinanceiro.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jonathas.gerenciadorfinanceiro.repositorios.GastoRepository;

import java.sql.Date;

@RestController
@RequestMapping(path="/gastos")
public class GastoController {

    @Autowired
    private GastoRepository gastoRepository;

    @GetMapping
    public Iterable<Gasto> listarTudo(){
        return gastoRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity listarUm(@PathVariable Integer id){
        if(gastoRepository.existsById(id)){
            return ResponseEntity.ok().body(gastoRepository.findById(id));
        }else return ResponseEntity.notFound().build();
    } //Sim, esse método foi feito diferente do método GET de Categoria. Para fins de comparação/ estudo

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarUm(@PathVariable Integer id){
        if(gastoRepository.existsById(id)){
            gastoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else return ResponseEntity.notFound().build();
    }
}
