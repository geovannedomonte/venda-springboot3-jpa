package com.springbootjpa.venda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjpa.venda.entities.Pedido;
import com.springbootjpa.venda.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired // Para o spring resolver a dependencia e associar uma instancia do PedidoRepository no TestConfig
	private PedidoRepository repository;
	
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj =  repository.findById(id);
		return obj.get();
	}

}
		