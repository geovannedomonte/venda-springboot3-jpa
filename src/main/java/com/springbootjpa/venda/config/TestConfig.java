package com.springbootjpa.venda.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springbootjpa.venda.entities.Usuario;
import com.springbootjpa.venda.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{ //executar os objetos que foram instanciados e salvar no banco de dados
	
	@Autowired
	private UsuarioRepository usuarioRepository; //declarando a dependencia / usuarioRepository  objeto repository que acessa os dados

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Alice Cavalcante", "lili@gmail.com", "648978884", "123456"); 
		Usuario u2 = new Usuario(null, "Marcelo Jorge", "marcelojpc@gmail.com", "55679878755", "123456"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	

}
