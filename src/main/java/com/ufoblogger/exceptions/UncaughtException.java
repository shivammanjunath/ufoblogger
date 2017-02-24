package com.ufoblogger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {

	public UncaughtException() {
		
	}

	public UncaughtException(String message) {
		super(message);
		
	}

	public UncaughtException(Throwable cause) {
		super(cause);
		
	}

	public UncaughtException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UncaughtException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	@Override
	public Response toResponse(Throwable exception) {
		return Response.status(500).entity("Unexpected error occurred, please try again!").type("text/plain").build();
	}

}
