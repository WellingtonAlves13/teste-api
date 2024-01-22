package com.example.treino.repository;

import com.example.treino.entity.CadastroProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroProdutoRepository extends JpaRepository<CadastroProdutoEntity, Long> {

}
