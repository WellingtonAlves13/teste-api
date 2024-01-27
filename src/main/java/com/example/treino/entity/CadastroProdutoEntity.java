package com.example.treino.entity;
import com.example.treino.dao.CadastroProdutoDAO;
import com.example.treino.dto.ProdutoDTO;
import com.example.treino.record.AlterarProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "produtos")
@Validated
public class CadastroProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    @NotEmpty
    private String descricao;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private String marca;

    public CadastroProdutoEntity(CadastroProdutoDAO produto){
        BeanUtils.copyProperties(produto, this);
    }
    public CadastroProdutoEntity(ProdutoDTO dados){
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
    }

    public CadastroProdutoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void atualizarInformacoes(AlterarProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.marca() != null) {
            this.marca = dados.marca();
        }
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
