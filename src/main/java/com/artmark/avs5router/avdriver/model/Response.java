package com.artmark.avs5router.avdriver.model;

/**
 * Created by nikolay on 23.11.17.
 */
public class Response<T> {
	public T body;
	public Error error;

	public static class Error {
		public String message;
		public String details;
	}

	public static <T> Response<T> success(T body) {
		Response<T> response = new Response<>();
		response.body = body;
		return response;
	}


	public static <T> Response<T> error(String message, String details) {
		Response<T> response = new Response<>();
		response.error = new Error();
		response.error.message = message;
		response.error.details = details;
		return response;
	}
}
