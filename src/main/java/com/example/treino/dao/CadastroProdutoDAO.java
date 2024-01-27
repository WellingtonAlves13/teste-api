package com.example.treino.dao;

import com.example.treino.entity.CadastroProdutoEntity;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

public class CadastroProdutoDAO {
    public CadastroProdutoDAO(CadastroProdutoEntity produto){
        BeanUtils.copyProperties(produto, this);
    }

    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private String marca;

    public Long getId() {
        return id;
    }

    public CadastroProdutoDAO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
