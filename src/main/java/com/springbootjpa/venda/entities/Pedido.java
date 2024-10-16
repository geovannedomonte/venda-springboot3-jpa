package com.springbootjpa.venda.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springbootjpa.venda.entities.enums.StatusPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT" )
	private Instant momento;
	private Integer statusPedido;	// integer: mostra explicitamente que esta gravando no banco de dados um numero inteiro
	
	@ManyToOne //Relacionamento
	@JoinColumn(name = "cliente_id") // chave estrangeira 
	private Usuario cliente; // Associação / cliente: nome do papel que esta no diagrama
	
	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public StatusPedido getStatusPedido() { 
		return StatusPedido.valueOf(statusPedido); // convetendo número inteiro para StatusPedido
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.statusPedido = statusPedido.getCode(); // pegar um numero inteiro correspondente a statusPedido
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	
}
