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
