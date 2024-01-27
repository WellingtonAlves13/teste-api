package com.example.treino.controller;


import com.example.treino.dto.ProdutoDTO;
import com.example.treino.entity.ProdutoEntity;
import com.example.treino.record.ListagemProduto;
import com.example.treino.repository.CadastroProdutoRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/produto")
@CrossOrigin
public class CadastroProdutoController {

    @Autowired
    CadastroProdutoRepository cadastroProdutoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProduto(@RequestBody @Valid ProdutoDTO produto, UriComponentsBuilder builder) {
        var newProdutos = new ProdutoEntity(produto);
        cadastroProdutoRepository.save(newProdutos);
        var uri = builder.path("/produto/{id}").buildAndExpand(newProdutos.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListagemProduto(newProdutos));

    }

    @GetMapping
    public ResponseEntity<List<ListagemProduto>> buscarTodos() {
        var busca = cadastroProdutoRepository.findAll().stream().map(ListagemProduto::new).toList();
        return ResponseEntity.ok(busca);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ListagemProduto produto){
        var newProduto = cadastroProdutoRepository.getReferenceById(produto.id());
        newProduto.atualizarInformacoes(produto);
        return ResponseEntity.ok(new ListagemProduto(newProduto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cadastroProdutoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
