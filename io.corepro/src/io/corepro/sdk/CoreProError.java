package io.corepro.sdk;

public class CoreProError {
    private int code;
    private String message;
    
    public CoreProError() {
    	
    }
    
    public CoreProError(int code, String message){
    	this();
    	setCode(code);
    	setMessage(message);
    }

    public String toString()
    {
        return getCode() + ":" + getMessage();
    }
	public int getCode() {
		return this.code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
