package io.corepro.sdk.utils;

public class HttpRequestException extends java.lang.Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4050825758678401745L;
	public HttpRequestException(String url, int statusCode, String message) {
		super(message);
		this.url = url;
		this.statusCode = statusCode;
	}
	
	private int statusCode;
	public int getStatusCode() { 
		return this.statusCode;
	}
	public void setStatusCode(int value){
		this.statusCode = value;
	}

	private String url;
	public String getUrl(){
		return this.url;
	}
	public void setUrl(String value){
		this.url = value;
	}

}
