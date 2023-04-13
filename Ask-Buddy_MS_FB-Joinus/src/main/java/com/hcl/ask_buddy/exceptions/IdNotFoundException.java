package com.hcl.ask_buddy.exceptions;

public class IdNotFoundException extends RuntimeException {

	private String msg;

	public IdNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
