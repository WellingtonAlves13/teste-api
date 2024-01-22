package com.example.treino.controller;

import com.example.treino.dao.CadastroProdutoDAO;
import com.example.treino.entity.CadastroProdutoEntity;
import com.example.treino.service.CadastroProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/produto")
@CrossOrigin
public class CadastroProdutoController {

    @Autowired
    CadastroProdutoService cadastroProdutoService;

    @GetMapping("/{id}")
    public Optional<CadastroProdutoEntity> buscarProduto(@PathVariable @Valid Long id){
        return cadastroProdutoService.buscarProduto(id);
    }

    @GetMapping
    public List<CadastroProdutoDAO> buscarTodos(){
        return cadastroProdutoService.buscarProdutos();
    }
    @PostMapping
    public void cadastrarProdutos(@RequestBody @Valid CadastroProdutoDAO produto){
        cadastroProdutoService.cadastrarProdutos(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cadastroProdutoService.excluirProduto(id);
        return ResponseEntity.ok().build();
    }


}
