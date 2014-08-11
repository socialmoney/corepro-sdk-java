package io.corepro.sdk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.reflect.TypeToken;

import io.corepro.sdk.models.Envelope;
import io.corepro.sdk.models.ModelBase;
import io.corepro.sdk.utils.Requestor;

public class Document extends ModelBase {
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
	
	public static ArrayList<Document> list(String cultureName, String documentType, Connection connection, Object userDefinedObjectForLogging) throws CoreProApiException {
		if (connection == null){
			connection = Connection.createFromConfig(null,  null,  null);
		}
		Envelope<ArrayList<Document>> envelope = new Envelope<ArrayList<Document>>();
		Type envelopeType = new TypeToken<Envelope<ArrayList<Document>>>(){}.getType();
		
		ArrayList<Document> docs = Requestor.performGet(String.format("document/list/%d/%d",  cultureName, documentType), connection, envelope, envelopeType, userDefinedObjectForLogging);
		return docs;
	}
}
