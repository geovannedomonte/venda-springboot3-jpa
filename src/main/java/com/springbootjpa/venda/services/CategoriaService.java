package com.springbootjpa.venda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjpa.venda.entities.Categoria;
import com.springbootjpa.venda.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired // Para o spring resolver a dependencia e associar uma instancia do CategoriaRepository no TestConfig
	private CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj =  repository.findById(id);
		return obj.get();
	}

}
		