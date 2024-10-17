package com.springbootjpa.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.venda.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
