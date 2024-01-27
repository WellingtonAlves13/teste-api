package com.example.treino.record;

import com.example.treino.entity.ProdutoEntity;

public record ListagemProduto(Long id, String nome, String descricao, Double preco, String marca) {

    public ListagemProduto(ProdutoEntity produto){
        this(produto.getId(), produto.getNome(), produto.getMarca(),produto.getPreco() , produto.getDescricao());

    }
}
