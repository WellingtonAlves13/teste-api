package com.example.treino.repository;

import com.example.treino.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
