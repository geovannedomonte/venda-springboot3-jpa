package com.springbootjpa.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.venda.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
