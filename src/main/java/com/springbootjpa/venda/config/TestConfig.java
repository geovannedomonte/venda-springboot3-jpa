package com.springbootjpa.venda.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springbootjpa.venda.entities.Categoria;
import com.springbootjpa.venda.entities.ItemDoPedido;
import com.springbootjpa.venda.entities.Pagamento;
import com.springbootjpa.venda.entities.Pedido;
import com.springbootjpa.venda.entities.Produto;
import com.springbootjpa.venda.entities.Usuario;
import com.springbootjpa.venda.entities.enums.StatusPedido;
import com.springbootjpa.venda.repositories.CategoriaRepository;
import com.springbootjpa.venda.repositories.ItemDoPedidoRepository;
import com.springbootjpa.venda.repositories.PedidoRepository;
import com.springbootjpa.venda.repositories.ProdutoRepository;
import com.springbootjpa.venda.repositories.UsuarioRepository;

@Configuration  //Annotation para o spring saber que é uma classe de teste.
@Profile("test") // Annotation especifica para perfil de teste. (’’test’’) tem que ser igual esta em application.propeties
public class TestConfig implements CommandLineRunner{ //executar os objetos que foram instanciados e salvar no banco de dados
	
	@Autowired
	private UsuarioRepository usuarioRepository; //declarando a dependencia / usuarioRepository  objeto repository que acessa os dados

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
 
		

		
		Categoria cat1 = new Categoria(null, "Consoles"); 
		Categoria cat2 = new Categoria(null, "Jogos"); 
		Categoria cat3 = new Categoria(null, "Acessorios"); 
		Categoria cat4 = new Categoria(null, "Geek_Store");
		
		Produto p1 = new Produto(null, "Halo Infinite (Xbox)", "Jogo de tiro em primeira pessoa com campanha épica e multiplayer emocionante.", 355.50, ""); 
		Produto p2 = new Produto(null, "Playstantion 4 + 2 Controles", "Console de videogame da Sony com gráficos avançados e grande biblioteca de jogos.", 5989.99, ""); 
		Produto p3 = new Produto(null, "Controle PS4", "Controle sem fio DualShock 4 com sensor de movimento e feedback tátil.", 350.0, ""); 
		Produto p4 = new Produto(null, "Cabo de força AC para Xbox", "Cabo de alimentação para conexão e energia do console.", 35.0, ""); 
		Produto p5 = new Produto(null, "Demon's Souls (PS5)", "Jogo de RPG de ação desafiador com gráficos incríveis e combates intensos.", 259.99, ""); 
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat4);
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Usuario u1 = new Usuario(null, "Alice Cavalcante", "lili@gmail.com", "648978884", "123456"); 
		Usuario u2 = new Usuario(null, "Marcelo Jorge", "marcelojpc@gmail.com", "55679878755", "123456");
		Usuario u3 = new Usuario(null, "Geovanne do Monte", "geo@gmail.com", "21998789568", "123456");
		
		Pedido o1 = new Pedido(null, Instant.parse("2024-06-20T19:53:07Z"), StatusPedido.ENTREGUE, u1); 
		Pedido o2 = new Pedido(null, Instant.parse("2024-07-21T03:42:10Z"), StatusPedido.CANCELADO, u2); 
		Pedido o3 = new Pedido(null, Instant.parse("2024-07-22T15:21:22Z"),StatusPedido.ENTREGUE, u1);
		Pedido o4 = new Pedido(null, Instant.parse("2024-10-22T12:25:15Z"),StatusPedido.PAGO, u3);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
		ItemDoPedido oi1 = new ItemDoPedido(o1, p1, 2, p1.getPreco()); 
		ItemDoPedido oi2 = new ItemDoPedido(o1, p3, 1, p3.getPreco()); 
		ItemDoPedido oi3 = new ItemDoPedido(o2, p3, 2, p3.getPreco()); 
		ItemDoPedido oi4 = new ItemDoPedido(o3, p5, 2, p5.getPreco()); 
		ItemDoPedido oi5 = new ItemDoPedido(o4, p5, 2, p5.getPreco()); 
		ItemDoPedido oi6 = new ItemDoPedido(o4, p2, 3, p2.getPreco());

		itemDoPedidoRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4, oi5, oi6));

		Pagamento pag1 = new Pagamento(null, Instant.parse("2024-10-22T14:25:15Z"), o4);
		o4.setPagamento(pag1);
		
		pedidoRepository.save(o4);
		
		
	}
	

}
