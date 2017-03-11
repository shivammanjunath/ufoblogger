package com.ufoblogger.exceptions;

import javax.ws.rs.core.Response;

public class DatabaseException extends UFOBloggerException {

	public DatabaseException() {
	}

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(Throwable cause) {
		super(cause);
	}

	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	@Override
	public Response toResponse(UFOBloggerException exception) {
		return Response.status(500).entity("An unexpected error occured while reading from database!").type("text/plain").build();
	}
}
