package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Categoria;
import com.jonathas.gerenciadorfinanceiro.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Iterable<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity selecionarCategoria(@PathVariable Integer id){
        if(categoriaRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(categoriaRepository.findById(id));
        }
    }

    @PostMapping
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Integer id){
        if(categoriaRepository.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
    @PutMapping(path = "/{id}")
    public Categoria atualizar(@RequestBody Categoria categoria,@PathVariable Integer id){
        Categoria categoriaDb = categoriaRepository.findById(id).get();
        if(categoria.getDescricao()!=null) {
            categoriaDb.setDescricao(categoria.getDescricao());
        }
        if(categoria.getValor()!=0){
            categoriaDb.setValor(categoria.getValor());
        }

        return categoriaRepository.save(categoriaDb);
    }
}
