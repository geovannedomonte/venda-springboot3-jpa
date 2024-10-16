package com.springbootjpa.venda.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springbootjpa.venda.entities.Pedido;
import com.springbootjpa.venda.entities.Usuario;
import com.springbootjpa.venda.entities.enums.StatusPedido;
import com.springbootjpa.venda.repositories.PedidoRepository;
import com.springbootjpa.venda.repositories.UsuarioRepository;

@Configuration  //Annotation para o spring saber que é uma classe de teste.
@Profile("test") // Annotation especifica para perfil de teste. (’’test’’) tem que ser igual esta em application.propeties
public class TestConfig implements CommandLineRunner{ //executar os objetos que foram instanciados e salvar no banco de dados
	
	@Autowired
	private UsuarioRepository usuarioRepository; //declarando a dependencia / usuarioRepository  objeto repository que acessa os dados

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Alice Cavalcante", "lili@gmail.com", "648978884", "123456"); 
		Usuario u2 = new Usuario(null, "Marcelo Jorge", "marcelojpc@gmail.com", "55679878755", "123456"); 
		
		Pedido o1 = new Pedido(null, Instant.parse("2024-06-20T19:53:07Z"), StatusPedido.ENTREGUE, u1); 
		Pedido o2 = new Pedido(null, Instant.parse("2024-07-21T03:42:10Z"), StatusPedido.CANCELADO, u2); 
		Pedido o3 = new Pedido(null, Instant.parse("2024-07-22T15:21:22Z"),StatusPedido.ENTREGUE, u1);
		
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
	}
	

}
