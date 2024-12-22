package com.springbootjpa.venda.services.exceptions;

public class DatabaseException extends RuntimeException{ // para Delete

	private static final long serialVersionUID = 1L;

	
	public DatabaseException(String msg) {
		super(msg);
	}
}
