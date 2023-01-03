package com.example.javaeedemo.common;

public class Ex extends RuntimeException {
	public Ex() {
		super();
	}

	public Ex(String message, Throwable cause) {
		super(message, cause);
	}

	public Ex(String message) {
		super(message);
	}

	public Ex(Throwable cause) {
		super(cause);
	}

	protected Ex(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
