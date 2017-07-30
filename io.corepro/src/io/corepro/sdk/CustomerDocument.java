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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.CustomerIdOnly;
import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.FileContent;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class CustomerDocument extends ModelBase {

	private Integer customerId;
	private Integer documentId;
	private String documentType;
	private String documentName;
	private byte[] documentContent;
	private String downloadUrl;
	private String reasonType;
	private String tag;
	private String customField1;
	private String customField2;
	private String customField3;
	private String customField4;
	private String customField5;

	public CustomerDocument(){
		
	}
	
	public CustomerDocument(Integer customerId){
		this();
		this.setCustomerId(customerId);
	}
	
    public static CustomerDocument upload(Integer customerId, String documentType, String documentName, byte[] documentContent, String reasonType, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
    	CustomerDocument doc = new CustomerDocument(customerId);
    	doc.setDocumentType(documentType);
    	doc.setDocumentName(documentName);
    	doc.setDocumentContent(documentContent);
    	doc.setReasonType(reasonType);
    	return doc.upload(connection, userDefinedObjectForLogging);
    }
    
    public CustomerDocument upload(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException{
		Envelope<CustomerDocument> envelope = new Envelope<CustomerDocument>();
		Type envelopeType = new TypeToken<Envelope<CustomerDocument>>(){}.getType();
		return Requestor.performPost("customerdocument/upload", connection, this, envelope, envelopeType, userDefinedObjectForLogging);
    }

	public ArrayList<CustomerDocument> list(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<ArrayList<CustomerDocument>> envelope = new Envelope<ArrayList<CustomerDocument>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<CustomerDocument>>>() {}.getType();
		return Requestor.performGet(String.format("customerdocument/list/%d",  this.getCustomerId()), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public CustomerDocument get(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<CustomerDocument> envelope = new Envelope<CustomerDocument>();
		Type envelopeType = new TypeToken<Envelope<CustomerDocument>>() {}.getType();
		return Requestor.performGet(String.format("customerdocument/get/%d/%d",  this.getCustomerId(), this.documentId), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public CustomerDocument getByTag(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<CustomerDocument> envelope = new Envelope<CustomerDocument>();
		Type envelopeType = new TypeToken<Envelope<CustomerDocument>>() {}.getType();
		String urlEncodedTag = this.getTag();
		try {
			urlEncodedTag = java.net.URLEncoder.encode(urlEncodedTag, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Requestor.performGet(String.format("customerdocument/get/%d/%s",  this.getCustomerId(), urlEncodedTag), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}

	public FileContent download(Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<FileContent> envelope = new Envelope<FileContent>();
		Type envelopeType = new TypeToken<Envelope<FileContent>>() {}.getType();
		return Requestor.performGet(String.format("customerdocument/download/%d/%d",  this.getCustomerId(), this.documentId), connection, envelope, envelopeType, userDefinedObjectForLogging);
	}


	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public String getCustomField4() {
		return customField4;
	}

	public void setCustomField4(String customField4) {
		this.customField4 = customField4;
	}

	public String getCustomField5() {
		return customField5;
	}

	public void setCustomField5(String customField5) {
		this.customField5 = customField5;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
}
