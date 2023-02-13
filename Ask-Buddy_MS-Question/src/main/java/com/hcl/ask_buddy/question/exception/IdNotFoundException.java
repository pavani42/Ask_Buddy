package com.hcl.ask_buddy.question.exception;

public class IdNotFoundException extends RuntimeException {

	private String msg;

	public IdNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

}
