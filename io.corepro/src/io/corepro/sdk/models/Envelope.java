package io.corepro.sdk.models;

import io.corepro.sdk.CoreProError;

import java.util.ArrayList;
import java.util.UUID;

public class Envelope<T> {
	private T data;
    private String rawRequestBody;
    private String rawResponseBody;
    private ArrayList<CoreProError> errors;
    private int status;
    private UUID requestId;

    public Envelope()
    {
        setErrors(new ArrayList<CoreProError>());
    }
    
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
    public String getRawRequestBody() {
		return rawRequestBody;
	}
	public void setRawRequestBody(String rawRequestBody) {
		this.rawRequestBody = rawRequestBody;
	}
	public String getRawResponseBody() {
		return rawResponseBody;
	}
	public void setRawResponseBody(String rawResponseBody) {
		this.rawResponseBody = rawResponseBody;
	}
	public ArrayList<CoreProError> getErrors() {
		return errors;
	}
	public void setErrors(ArrayList<CoreProError> errors) {
		this.errors = errors;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UUID getRequestId() {
		return requestId;
	}
	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}
}
