package com.accio.mongodb.utilities;


public enum HttpStatusEnum {

	GENERALERROR(9999, "General Error."),
	OK(200, "Ok"),
	CREATED(201, "Created"),
	ACCEPTED(202, "Accepted"),
	PARTIAL_CONTENT(206, "Partial Content"),
	BADREQUEST(400, "Bad Request"),
	PAYMENT_REQUIRED(402, "Payment Required"),
	NOTFOUND(404, "Not Found"),
	NOTACCEPTABLE(406,"Not Acceptable"),
	TIMEOUT(408, "Request Timeout"),
	CONFLICT(409, "Conflict"),
	INTERNALERROR(500,"Internal Server Error"),
	UNAVAILABLE(503, "Service Unavailable");

	private int code;

	private String description;

	HttpStatusEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
