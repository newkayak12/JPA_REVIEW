package com.jpa.chapter11_web.exception;

public class NotEnoughStockException extends Exception {
	
	public NotEnoughStockException(){}
	public NotEnoughStockException (String message){
		super(message);
	}
	
}
