package com.ufoblogger.handler;

public interface ILocalOperations extends IUserActivity {
	String getUserToken(String userData);
	String getDecodedToken(String token);
}
