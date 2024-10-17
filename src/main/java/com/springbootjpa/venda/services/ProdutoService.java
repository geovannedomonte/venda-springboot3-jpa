package com.springbootjpa.venda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjpa.venda.entities.Produto;
import com.springbootjpa.venda.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired // Para o spring resolver a dependencia e associar uma instancia do ProdutoRepository no TestConfig
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj =  repository.findById(id);
		return obj.get();
	}

}
		