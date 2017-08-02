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

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.CustomerIdOnly;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class ExternalAccountDocument extends ModelBase {
	
	private Integer customerId;
	private Integer externalAccountId;
	private String documentType;
	private String documentName;
	private byte[] documentContent;
	private String reasonType;
	
	public ExternalAccountDocument(){
		
	}
	
	public ExternalAccountDocument(Integer customerId, Integer externalAccountId){
		this();
		this.setCustomerId(customerId);
		this.setExternalAccountId(externalAccountId);
	}
	
    public static void upload(Integer customerId, Integer externalAccountId, String documentType, String documentName, byte[] documentContent, String reasonType, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
    	ExternalAccountDocument doc = new ExternalAccountDocument(customerId, externalAccountId);
    	doc.setDocumentType(documentType);
    	doc.setDocumentName(documentName);
    	doc.setDocumentContent(documentContent);
    	doc.setReasonType(reasonType);
    	doc.upload(connection, userDefinedObjectForLogging);
    }
    
    public void upload(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerIdOnly> envelope = new Envelope<>();
		Type envelopeType = new TypeToken<Envelope<CustomerIdOnly>>(){}.getType();
    	
		Requestor.performPost("externalaccountdocument/upload", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
		
    }

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getExternalAccountId() {
		return externalAccountId;
	}

	public void setExternalAccountId(Integer externalAccountId) {
		this.externalAccountId = externalAccountId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public byte[] getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(byte[] documentContent) {
		this.documentContent = documentContent;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

}
