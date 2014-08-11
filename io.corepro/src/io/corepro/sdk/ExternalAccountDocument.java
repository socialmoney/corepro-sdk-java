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
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		
		Envelope<CustomerIdOnly> envelope = new Envelope<CustomerIdOnly>();
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
