package com.artmark.avs5router.avdriver;

/**
 * Created by nikolay on 23.10.17.
 */
public class RemoteException extends RuntimeException {
	private final String code;

	public RemoteException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
