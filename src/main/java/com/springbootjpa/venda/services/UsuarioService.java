package com.springbootjpa.venda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.springbootjpa.venda.entities.Usuario;
import com.springbootjpa.venda.repositories.UsuarioRepository;
import com.springbootjpa.venda.services.exceptions.DatabaseException;
import com.springbootjpa.venda.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired // Para o spring resolver a dependencia e associar uma instancia do UsuarioRepository no TestConfig
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));  //return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	/*
	public void delete(Long id) {
		repository.deleteById(id);
	} 
	*/
	/*
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	*/
	public void delete(Long id) {
	    try {
	        if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }	
	} 
	/*
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	*/
	
	public Usuario update(Long id, Usuario obj) {
		try {
			Usuario entity =  findById(id); // User entity = repository.getOne(id); // User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

	

	private void updateData(Usuario entity, Usuario obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
		