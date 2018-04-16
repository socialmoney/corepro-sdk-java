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

package io.corepro.sdk.models;

import io.corepro.sdk.CoreProError;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Envelope<T> {
	private T data;
    private String rawRequestBody;
    private String rawResponseBody;
    private List<CoreProError> errors;
    private int status;
    private UUID requestId;

    public Envelope()
    {
        setErrors(new ArrayList<>());
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
	public List<CoreProError> getErrors() {
		return errors;
	}
	public void setErrors(List<CoreProError> errors) {
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
