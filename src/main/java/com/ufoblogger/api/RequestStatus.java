package com.ufoblogger.api;

public class RequestStatus {

	private boolean requestStatus;
	
	public RequestStatus() {
		
	}
	
	public RequestStatus(boolean status) {
		this.requestStatus = status;
	}

	public boolean isRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}

	
}
