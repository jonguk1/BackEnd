package com.common.exception;

public class NotUserException extends Exception{

	public NotUserException() {
		super("ȸ���� �ƴմϴ�");
	}
	
	public NotUserException(String msg) {
		super(msg);
	}
}
