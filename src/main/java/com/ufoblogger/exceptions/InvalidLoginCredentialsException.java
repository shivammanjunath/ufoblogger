package com.ufoblogger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidLoginCredentialsException extends UFOBloggerException {
	
	private Object entityObj;

	public InvalidLoginCredentialsException() {
		
	}

	public InvalidLoginCredentialsException(String message) {
		super(message);
	}

	public InvalidLoginCredentialsException(Throwable cause) {
		super(cause);
	}

	public InvalidLoginCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidLoginCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public void setEntity(Object entity) {
		this.entityObj = entity;
	}
	
	@Override
	public Response toResponse(UFOBloggerException exception) {
		return Response.status(500).entity(entityObj).type("text/plain").build();
	}

}
