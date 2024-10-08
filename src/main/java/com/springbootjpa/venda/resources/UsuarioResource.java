package com.springbootjpa.venda.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjpa.venda.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario u = new Usuario(1L, "Geovanne", "geo@gmail.com", "219878787", "123");
		return ResponseEntity.ok().body(u);
	}
}
