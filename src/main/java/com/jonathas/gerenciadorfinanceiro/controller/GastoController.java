package com.jonathas.gerenciadorfinanceiro.controller;

import com.jonathas.gerenciadorfinanceiro.domain.Categoria;
import com.jonathas.gerenciadorfinanceiro.domain.Gasto;
import com.jonathas.gerenciadorfinanceiro.dto.GastoDTO;
import com.jonathas.gerenciadorfinanceiro.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jonathas.gerenciadorfinanceiro.repositorios.GastoRepository;

import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping(path="/gastos")
public class GastoController {

    @Autowired
    private GastoRepository gastoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

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

    /*Aparentemente é melhor utilizar o método findById em detrimento do GetById*/
    @PostMapping
    public Gasto inserir(@RequestBody GastoDTO gastoDTO){
        Gasto gasto = new Gasto();
        Optional<Categoria> categoria = categoriaRepository.findById(gastoDTO.getCategoria());
        gasto.setValor(gastoDTO.getValor());
        gasto.setDescricao(gastoDTO.getDescricao());
        gasto.setCategoria(categoria.get());
        gasto.setData(gastoDTO.getData());
        return gastoRepository.save(gasto);
    }
    @PutMapping(path = "/{id}")
    public Gasto update(@RequestBody GastoDTO gastoDTO, @PathVariable Integer id){
        Gasto gasto = gastoRepository.findById(id).get(); //pegando o objeto com o id dado.

        //trocando as categorias que foram informadas
        //se não for informada a categoria no json, então não fazer nada (manter a categoria original)
        if(gastoDTO.getCategoria()!=null){
            Optional<Categoria> categoria = categoriaRepository.findById(gastoDTO.getCategoria());
            gasto.setCategoria(categoria.get());
        }
        if(gastoDTO.getValor()!=null){
            gasto.setValor(gastoDTO.getValor());
        }

        if(gastoDTO.getDescricao()!=null){
            gasto.setDescricao(gastoDTO.getDescricao());
        }

        if(gastoDTO.getData()!=null){
            gasto.setData(gastoDTO.getData());
        }

        return gastoRepository.save(gasto);
    }
}
