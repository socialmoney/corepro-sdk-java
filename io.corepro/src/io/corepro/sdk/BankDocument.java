package io.corepro.sdk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.FileContent;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class BankDocument extends ModelBase {
	public Integer bankId;
	public Integer customerId;
	public Integer documentId;
	public String documentType;
	public String culture;
	public String html;
	public String title;
	public String downloadUrl;
	public Date effectiveDate;
	public Date expireDate;
	
	public static ArrayList<BankDocument> list(String cultureName, String documentType, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<ArrayList<BankDocument>> envelope = new Envelope<ArrayList<BankDocument>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<BankDocument>>>(){}.getType();
		
		ArrayList<BankDocument> docs = Requestor.performGet(String.format("bankdocument/list/%d/%d",  cultureName, documentType), connection, envelope, envelopeType, userDefinedObjectForLogging);
		return docs;
	}
	
	public static FileContent download(String cultureName, Integer documentId, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		Envelope<FileContent> envelope = new Envelope<FileContent>();
		Type envelopeType = new TypeToken<Envelope<FileContent>>(){}.getType();
		
		FileContent fc = Requestor.performGet(String.format("bankdocument/download/%d/%i",  cultureName, documentId), connection, envelope, envelopeType, userDefinedObjectForLogging);
		return fc;
	}

}
