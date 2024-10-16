package com.springbootjpa.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.venda.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
