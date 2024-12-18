package com.springbootjpa.venda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootjpa.venda.entities.Usuario;
import com.springbootjpa.venda.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired // Para o spring resolver a dependencia e associar uma instancia do UsuarioRepository no TestConfig
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

}
		