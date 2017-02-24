package com.ufoblogger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Provider
public class UFOBloggerException extends RuntimeException implements ExceptionMapper<UFOBloggerException> {

	
	public UFOBloggerException() {
		
	}

	public UFOBloggerException(String message) {
		super(message);
	}

	public UFOBloggerException(Throwable cause) {
		super(cause);
	}

	public UFOBloggerException(String message, Throwable cause) {
		super(message, cause);
	}

	public UFOBloggerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	@Override
	public Response toResponse(UFOBloggerException exception) {
		return Response.status(500).entity("Unexpected error occurred, please try again!").type("text/plain").build();
	}
}
