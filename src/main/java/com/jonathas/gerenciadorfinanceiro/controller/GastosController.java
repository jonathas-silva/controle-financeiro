package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Gasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jonathas.gerenciadorfinanceiro.repositorios.GastosRepository;

@RestController
@RequestMapping(path="/gastos")
public class GastosController {
    @Autowired
    private GastosRepository gastosRepository;

    //método GET
    @GetMapping
    public Iterable<Gasto> listarGastos() {
        return gastosRepository.findAll();
    }

    //método GET por id específico
    @GetMapping(path = "/{id}")
    public ResponseEntity buscar(@PathVariable Integer id) {
        return gastosRepository.findById(id)
                .map(objeto -> ResponseEntity.ok().body(objeto)) //se encontrar retorna o status 200 e o objeto
                .orElse(ResponseEntity.notFound().build()); //se não retorna 404
    }

    //método POST
    //Utiliza o método save de repository e retorna para o usuário o corpo da requisição salva
    @PostMapping
    public Gasto create(@RequestBody Gasto gastos) {
        return gastosRepository.save(gastos);
    }

    //Método delete.
/*  Foi feito com programação imperativa em detrimento de programação funcional,
    para compreender o funcionamento intrínseco dos métodos*/
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!gastosRepository.findById(id).isEmpty()) {
            gastosRepository.deleteById(id); //se não estiver vazio o objeto, deleta
            return ResponseEntity.ok().build(); //e retorna um status 200
        } else {
            return ResponseEntity.notFound().build(); //se estiver vazio retorna 404
        }
    }
}
