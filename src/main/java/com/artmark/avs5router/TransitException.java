package com.artmark.avs5router;

/**
 * Created by nikolay on 20.03.17.
 */
public class TransitException extends RuntimeException {
	public TransitException() {
	}

	public TransitException(String s) {
		super(s);
	}

	public TransitException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public TransitException(Throwable throwable) {
		super(throwable);
	}

	public TransitException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}
