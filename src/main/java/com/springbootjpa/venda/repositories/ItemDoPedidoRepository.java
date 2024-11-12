package com.springbootjpa.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.venda.entities.ItemDoPedido;
import com.springbootjpa.venda.entities.pk.ItemDoPedidoPK;

public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK> {

}
