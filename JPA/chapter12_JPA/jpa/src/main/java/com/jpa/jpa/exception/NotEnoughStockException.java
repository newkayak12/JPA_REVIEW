package com.jpa.jpa.exception;

public class NotEnoughStockException extends Exception {
	
	public NotEnoughStockException(){}
	public NotEnoughStockException (String message){
		super(message);
	}
	
}
