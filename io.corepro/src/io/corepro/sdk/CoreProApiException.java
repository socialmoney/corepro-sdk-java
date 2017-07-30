/*
 * Copyright (C) 2017 Q2 Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
		for(CoreProError e : this.errors){
        	rv.append(e.toString());
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

