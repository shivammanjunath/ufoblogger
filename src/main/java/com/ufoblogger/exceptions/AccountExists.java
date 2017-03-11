package com.ufoblogger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AccountExists extends UFOBloggerException {

	public AccountExists() {

	}

	public AccountExists(String message) {
		super(message);

	}

	public AccountExists(Throwable cause) {
		super(cause);

	}

	public AccountExists(String message, Throwable cause) {
		super(message, cause);

	}

	public AccountExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	@Override
	public Response toResponse(UFOBloggerException exception) {
		return Response.status(500).entity("An account with the same email already exists, please Login or use different email id.").type("text/plain").build();
	}
}
