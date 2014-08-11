package io.corepro.sdk;

import java.util.ArrayList;

public class CoreProApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7678868024297694092L;
	private ArrayList<CoreProError> errors;
    private int status;
    private String rawResponseBody;
    
    public CoreProApiException()
    {
    	super();
        this.setErrors(new ArrayList<CoreProError>());
        this.setStatus(-1);
    }

    public CoreProApiException(ArrayList<CoreProError> errors, int status, String body)
    {
    	super((errors.size() > 0 ? errors.get(0).getMessage() + "  " : "") + "See Errors property for full list of error details.");
        this.setErrors(errors);
        this.setStatus(status);
        this.setRawResponseBody(body);
    }
    
    public CoreProApiException(Throwable cause, String message){
    	super(cause);
    	ArrayList<CoreProError> errors = new ArrayList<CoreProError>();
    	CoreProError e = new CoreProError();
    	if (message == null){
        	e.setMessage(cause.getMessage());
    	} else {
        	e.setMessage(message);
    	}
    	e.setCode(-9999);
    	errors.add(e);
    	
    	if (message == null){
    		this.setRawResponseBody(e.getMessage());
    	} else {
    		this.setRawResponseBody(message);
    	}

        this.setErrors(errors);
        this.setStatus(-1);
    }

    public String getFirstErrorMessage()
    {
    	if (getErrors().size() < 1)
    		return null;
    	else
    		return getErrors().get(0).getMessage();
    }

    public Integer getFirstErrorCode()
    {
    	if (getErrors().size() < 1)
    		return null;
    	else
    		return getErrors().get(0).getCode();
    }

    public String getAllErrorInfo(boolean includeRawResponse)
    {
        StringBuilder rv = new StringBuilder();
        for(int i=0;i<this.errors.size();i++){
        	rv.append(this.errors.get(i).toString());
        	rv.append('\n');
        }
        if (includeRawResponse)
        {
            rv.append('\n').append('\n').append(this.getRawResponseBody()).append('\n');
        }
        return rv.toString();
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

	public String getRawResponseBody() {
		return rawResponseBody;
	}

	public void setRawResponseBody(String rawResponseBody) {
		this.rawResponseBody = rawResponseBody;
	}
}

