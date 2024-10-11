package com.springbootjpa.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.venda.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
