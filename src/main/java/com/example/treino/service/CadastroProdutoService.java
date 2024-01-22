package com.example.treino.service;

import com.example.treino.dao.CadastroProdutoDAO;
import com.example.treino.entity.CadastroProdutoEntity;
import com.example.treino.repository.CadastroProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroProdutoService {
    @Autowired
    private CadastroProdutoRepository cadastroProdutoRepository;

    public List<CadastroProdutoDAO> buscarProdutos(){
        List<CadastroProdutoEntity> produtos = cadastroProdutoRepository.findAll();
        return produtos.stream().map(CadastroProdutoDAO::new).toList();
    }
    public Optional<CadastroProdutoEntity> buscarProduto(Long id){
      return cadastroProdutoRepository.findById(id);
    }
    @Transactional
    public void cadastrarProdutos(CadastroProdutoDAO produto){
            CadastroProdutoEntity cadastroProdutoEntity = new CadastroProdutoEntity(produto);
            cadastroProdutoRepository.save(cadastroProdutoEntity);
    }
    public void excluirProduto(Long id) {
        CadastroProdutoEntity usuario = cadastroProdutoRepository.findById(id).get();
        cadastroProdutoRepository.delete(usuario);

    }
}
